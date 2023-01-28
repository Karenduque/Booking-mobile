package hooks;

import appium.AppiumServer;
import drivers.IOSAppDriver;
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

public class IOSHooks {

	@Before( value = "@iOS", order = 1 )
	public void setUpDriver ( ) throws MalformedURLException, URISyntaxException {
		/*
		Get the server index sent in the maven run command.
		 */
		int serverIndex = Integer.parseInt( System.getProperty( "server" ) );

		/*
		Start iOS Driver.
		 */
		IOSAppDriver.startDriver( AppiumServer.getURL( ), serverIndex );
	}

	@After( "@iOS" )
	public void tearDownDriver ( Scenario scenario ) {
		/*
		Take a screenshot after executing test cases
		 */
		if ( scenario.isFailed( ) ) {
			Allure.addAttachment( UUID.randomUUID( ).toString( ), new ByteArrayInputStream( ( ( TakesScreenshot ) IOSAppDriver.iosDriver ).getScreenshotAs( OutputType.BYTES ) ) );
		}

		/*
		Stop iOS Driver.
		 */
		IOSAppDriver.stopDriver( );
	}

	@Before( value = "@Skip", order = 0 )
	public void ignore ( ) throws SkipException {
		throw new SkipException( "" );
	}

}
