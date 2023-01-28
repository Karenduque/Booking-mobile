package drivers;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import readers.AppiumJsonReader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class IOSAppDriver {

	private static final Logger logger = LogManager.getLogger( );
	public static IOSDriver iosDriver = null;

	private static void loadDriver ( String appiumURL, int serverIndex ) throws MalformedURLException, URISyntaxException {
		/*
		Get app name.
		 */
		String appName = AppiumJsonReader.getAppName( serverIndex );

		/*
		Load the path to the .app file.
		 */
		File app = new File( Objects.requireNonNull( IOSAppDriver.class.getClassLoader( ).getResource( "apps/" + appName ) ).toURI( ) );

		/*
		Validate the app is in the resources/apps folder.
		 */
		if ( !app.exists( ) ) {
			System.out.println( app.getName( ) + " not found in the 'resource/apps' folder..." );
			return;
		}

		/*
		Load the capabilities required to run the execution.
		 */
		XCUITestOptions options = new XCUITestOptions( AppiumJsonReader.capabilities( serverIndex ) );
		options.setApp( app.getAbsolutePath( ) );

		/*
		Instantiate a new iOS Driver.
		 */
		iosDriver = new IOSDriver( new URL( appiumURL ), options );
	}

	public static void startDriver ( String appiumURL, int serverIndex ) throws MalformedURLException, URISyntaxException {
		/*
		Validate if the driver is already running.
		 */
		if ( iosDriver != null ) return;

		/*
		Load an iOS Driver.
		 */
		loadDriver( appiumURL, serverIndex );
	}

	public static void stopDriver ( ) {
		/*
		Validate if the driver is stopped.
		 */
		if ( iosDriver == null ) return;

		/*
		Stop iOS Driver.
		 */
		iosDriver.quit( );
		iosDriver = null;
		logger.info( "IOSDriver stopped" );
	}
}
