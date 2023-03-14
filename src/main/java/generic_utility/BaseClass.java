package generic_utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	public AndroidDriver driver;
	@BeforeSuite
	public void BS()
	{
		System.out.println("bs");
	}
	@BeforeTest
	public void BT()
	{
		System.out.println("bt");
	}
	@BeforeClass
	public void BC()
	{
		System.out.println("bm");
	}
	@BeforeMethod
	public void BM() throws MalformedURLException
	{
		System.out.println("bm");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "poco x2");
		dc.setCapability(MobileCapabilityType.UDID, "6b0ea78c");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability("appPackage","com.flipkart.android");
		dc.setCapability("appActivity",".SplashActivity");
		URL url=new URL("http://localhost:4723/wd/hub");
		driver=new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void AM()
	{
		System.out.println("am");
	}
	@AfterClass
	public void AC()
	{
		System.out.println("ac");
	}
	@AfterTest
	public void At()
	{
		System.out.println("at");
	}
	@AfterSuite
	public void AS()
	{
		System.out.println("as");
	}
	
}
