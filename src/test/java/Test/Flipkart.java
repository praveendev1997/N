package Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import generic_utility.MobileDriver_utility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Flipkart {
	@Test
	public void flipkart() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "poco x2");
		dc.setCapability(MobileCapabilityType.UDID, "6b0ea78c");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability("appPackage","com.flipkart.android");
		dc.setCapability("appActivity",".SplashActivity");
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(1000);
		MobileDriver_utility mu=new MobileDriver_utility(driver);
		driver.findElementByXPath("//android.widget.TextView[@text='Search for products']").click();
		driver.findElementByXPath("//android.widget.EditText[@text='Search for Products, Brands and More']").sendKeys("poco x2");
		driver.hideKeyboard();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@text='poco x2']").click();
		//List<MobileElement> list = (List<MobileElement>)driver.findElementsByXPath("//android.widget.TextView[contains(@text,'POCO') and contains(@text,'GB')]");
		//List<MobileElement> priceList = (List<MobileElement>)driver.findElementsByXPath("//android.widget.TextView[contains(@text,'₹')]");
		for(int j=0;j<=21;j++)
		{
			List<MobileElement> list = (List<MobileElement>)driver.findElementsByXPath("//android.widget.TextView[contains(@text,'POCO') and contains(@text,'GB')]");
			List<MobileElement> priceList = (List<MobileElement>)driver.findElementsByXPath("//android.widget.TextView[contains(@text,'₹')]");
			for(int i=0;i<list.size();i++)
			{
				String name = list.get(i).getText();
				String price = priceList.get(i).getText();
				System.out.println(name+" -> "+price);
			}
			mu.verticalSwipeByPercentage(.9, .2, 0);
		}
		
	}
}
