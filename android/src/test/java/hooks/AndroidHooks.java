package hooks;

import appium.AppiumServer;
import drivers.AndroidAppDriver;
import extensions.UiAutomator2Extension;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.SkipException;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.UUID;

public class AndroidHooks {

	@Before( value = "@Android", order = 1 )
	public void setUpDriver ( ) throws MalformedURLException, URISyntaxException {
		/*
		Get the server index sent in the maven run command.
		 */
		int serverIndex = Integer.parseInt( System.getProperty( "server" ) );

		/*
		Start Android Driver.
		 */
		AndroidAppDriver.startDriver( AppiumServer.getURL( ), serverIndex );

		/*
		Set Up Extensions.
		 */
		UiAutomator2Extension.setDriver( AndroidAppDriver.androidDriver );
	}

	@After( "@Android" )
	public void tearDownDriver ( Scenario scenario ) {
		/*
		Take a screenshot after executing test cases
		 */
		if ( scenario.isFailed( ) ) {
			Allure.addAttachment( UUID.randomUUID( ).toString( ), new ByteArrayInputStream( ( ( TakesScreenshot ) AndroidAppDriver.androidDriver ).getScreenshotAs( OutputType.BYTES ) ) );
		}

		/*
		Stop Android Driver.
		 */
		AndroidAppDriver.stopDriver( );
	}

	@Before( value = "@Skip", order = 0 )
	public void ignore ( ) throws SkipException {
		throw new SkipException( "" );
	}

}
