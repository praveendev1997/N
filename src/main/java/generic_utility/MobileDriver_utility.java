package generic_utility;

//import org.openqa.selenium.interactions.touch.TouchActions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class MobileDriver_utility {
	private AndroidDriver<MobileElement> driver;
	public MobileDriver_utility(AndroidDriver driver)
	{
		this.driver=driver;
	}
	
	//tap to an element for 250 ms
	public void tapByElement(AndroidElement androidElement)
	{
		new TouchAction(driver)
		.tap(tapOptions().withElement(element(androidElement)))
		.waitAction(waitOptions(ofMillis(250))).perform();
	}
	
	//tap by coordinates
	public void tapByCordinates(int x,int y)
	{
		new TouchAction(driver)
		.tap(point(x, y))
		.waitAction(waitOptions(ofMillis(250))).perform();
	}
	
	//press by element
	public void pressByElement(AndroidElement element, long seconds)
	{
		new TouchAction(driver)
		.press(element(element))
		.waitAction(waitOptions(ofSeconds(seconds)))
		.release().perform();
	}
	
	//horizontal swipe by percentage
	public void horizontalSwipeByPercentage(double startPercentage, double endPercentage,double anchorPercentage)
	{
		Dimension size=driver.manage().window().getSize();
		int anchor=(int) (size.height*anchorPercentage);
		int startPoint=(int) (size.width*startPercentage);
		int endPoint=(int) (size.width*endPercentage);
		new TouchAction(driver)
		.press(point(startPoint,anchor))
		.waitAction(waitOptions(ofMillis(1000)))
		.moveTo(point(endPoint,anchor))
		.release().perform();
	}
	
	//vertical swipe by percentage
	public void verticalSwipeByPercentage(double startPercentage, double endPercentage,double anchorPercentage)
	{
		Dimension size=driver.manage().window().getSize();
		int anchor=(int) (size.width*anchorPercentage);
		int startPoint=(int) (size.height*startPercentage);
		int endPoint=(int) (size.height*endPercentage);
		new TouchAction(driver)
		.press(point(anchor, startPoint))
		.waitAction(waitOptions(ofMillis(1000)))
		.moveTo(point(anchor, endPoint))
		.release().perform();
	}
	
	//swipe by element
	public void swipeByElement(MobileElement stEl, MobileElement element)
	{
		int startX=stEl.getLocation().getX()+(stEl.getSize().getWidth()/2);
		int startY=stEl.getLocation().getY()+(stEl.getSize().getHeight()/2);
		int endX=element.getLocation().getX()+(element.getSize().getWidth()/2);
		int endY=element.getLocation().getY()+(element.getSize().getHeight()/2);
		new TouchAction(driver)
		.press(point(startX, startY))
		.waitAction(waitOptions(ofMillis(1000)))
		.moveTo(point(endX, endY))
		.release().perform();
	}
	
	//multi touch action by using an android element
	public void multiTouchByElement(AndroidElement androidElement)
	{
		TouchAction press=new TouchAction(driver)
				.press(element(androidElement))
				.waitAction(waitOptions(ofSeconds(1)))
				.release();
		new MultiTouchAction(driver)
		.add(press)
		.perform();
	}
}
