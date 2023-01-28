package pages;

import drivers.AndroidAppDriver;
import extensions.UiAutomator2Extension;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

/*
This is the base class that all pages extend from.
 */
public class BasePage extends Page {

	/*
	Get an instance of the Android driver
	 */
	protected final AndroidDriver driver = AndroidAppDriver.androidDriver;

	/*
	Custom locators
	 */
	protected final String scrollTextMatch = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textMatches(\"(?i)";
	protected final String scrollDescriptionMatch = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().descriptionMatches(\"(?i)";
	protected final String scrollDescriptionContains = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().descriptionContains(\"";

	protected final String wrapper = "\"))";

	/*
	Function to get the element by the content-desc with regular expression
	 */
	protected RemoteWebElement getElementByDescriptionMatchScroll ( String description ) {
		return UiAutomator2Extension.getElement( AppiumBy.androidUIAutomator( scrollDescriptionMatch + description + wrapper ) );
	}

	/*
	Function to get the element that contains a string in the content-desc
	 */
	protected RemoteWebElement getElementByDescriptionContainsScroll ( String description ) {
		return UiAutomator2Extension.getElement( AppiumBy.androidUIAutomator( scrollDescriptionContains + description + wrapper ) );
	}

	/*
	Function to do a swipe up in an element
	 */
	protected void swipeUp ( RemoteWebElement element ) {
		UiAutomator2Extension.swipe( UiAutomator2Extension.DIRECTION.UP, ( float ) 0.8, element );
	}

	/*
	Function to do a swipe right in an element
	 */
	protected void swipeRight ( RemoteWebElement element ) {
		UiAutomator2Extension.swipe( UiAutomator2Extension.DIRECTION.RIGHT, ( float ) 0.8, element );
	}

	/*
	Function to do a swipe left in an element
	 */
	protected void swipeLeft ( RemoteWebElement element ) {
		UiAutomator2Extension.swipe( UiAutomator2Extension.DIRECTION.LEFT, ( float ) 1.0, element );
	}

	/*
	Function that waits until an element is no more in the screen
	 */
	protected void waitForElementToDisappear ( By locator ) {
		UiAutomator2Extension.waitForElementToDisappear( locator );
	}

}
