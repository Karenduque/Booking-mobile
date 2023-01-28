package extensions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/*
This class extends the basic functionalities of Appium, allowing to have new actions
 */
public class UiAutomator2Extension {

	private static AppiumDriver driver;
	private static WebDriverWait wait;

	public static void setDriver ( AppiumDriver appiumDriver ) {
		driver = appiumDriver;
		wait = new WebDriverWait( driver, Duration.ofSeconds( 20 ) );
	}

	/*
	Function to swipe an element to any direction. If the element is null, the full screen of the device will be swiped.
	 */
	public static void swipe ( DIRECTION direction, float percent, RemoteWebElement element ) {
		Map< String, Object > params = new HashMap<>( );

		if ( element != null ) {
			params.put( "elementId", element.getId( ) );
		} else {
			Dimension size = driver.manage( ).window( ).getSize( );
			int width = size.getWidth( );
			int height = size.getHeight( );
			int left = ( int ) ( width * 0.1 );
			int top = ( int ) ( height * 0.1 );

			params.put( "left", left );
			params.put( "top", top );
			params.put( "width", width );
			params.put( "height", height );
		}

		switch ( direction ) {
			case UP:
				params.put( "direction", "up" );
				break;
			case DOWN:
				params.put( "direction", "down" );
				break;
			case LEFT:
				params.put( "direction", "left" );
				break;
			case RIGHT:
				params.put( "direction", "right" );
				break;
		}

		params.put( "percent", percent );
		params.put( "speed", "1100" );

		driver.executeScript( "mobile: swipeGesture", params );
	}

	public static void swipe ( DIRECTION direction ) {
		swipe( direction, ( float ) 0.8, null );
	}

	/*
	Function to scroll an element in any direction. In case the element is null, the full screen of the device is scrolled
	 */
	public static void scroll ( DIRECTION direction, RemoteWebElement element ) {
		Map< String, Object > params = new HashMap<>( );

		if ( element != null ) {
			params.put( "elementId", element.getId( ) );
		} else {
			Dimension size = driver.manage( ).window( ).getSize( );
			int width = size.getWidth( );
			int height = size.getHeight( );
			int left = ( int ) ( width * 0.1 );
			int top = ( int ) ( height * 0.1 );

			params.put( "left", left );
			params.put( "top", top );
			params.put( "width", width );
			params.put( "height", height );
		}

		switch ( direction ) {
			case UP:
				params.put( "direction", "up" );
				break;
			case DOWN:
				params.put( "direction", "down" );
				break;
			case LEFT:
				params.put( "direction", "left" );
				break;
			case RIGHT:
				params.put( "direction", "right" );
				break;
		}

		params.put( "percent", 0.8 );

		driver.executeScript( "mobile: scrollGesture", params );
	}

	public static void scroll ( DIRECTION direction ) {
		scroll( direction, null );
	}

	public static RemoteWebElement getElement ( By locator ) {
		return wait.until( ( ExpectedCondition< RemoteWebElement > ) androidDriver -> {
			assert androidDriver != null;
			return ( RemoteWebElement ) androidDriver.findElement( locator );
		} );
	}

	/*
	Function to wait for an element to disappear
	 */
	public static void waitForElementToDisappear ( By locator ) {
		wait.until( ExpectedConditionsExtension.elementDisappear( locator ) );
	}

	public enum DIRECTION {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}

}
