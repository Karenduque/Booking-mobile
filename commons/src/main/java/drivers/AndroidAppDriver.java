package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import readers.AppiumJsonReader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class AndroidAppDriver {

	private static final Logger logger = LogManager.getLogger( );
	public static AndroidDriver androidDriver = null;

	private static void loadDriver ( String appiumURL, int serverIndex ) throws MalformedURLException, URISyntaxException {
		/*
		Get app name.
		 */
		String appName = AppiumJsonReader.getAppName( serverIndex );

		/*
		Load the path to the .apk file
		 */
		File app = new File( Objects.requireNonNull( AndroidAppDriver.class.getClassLoader( ).getResource( "apps/" + appName ) ).toURI( ) );

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
		UiAutomator2Options options = new UiAutomator2Options( AppiumJsonReader.capabilities( serverIndex ) );
		options.setApp( app.getAbsolutePath( ) );

		/*
		Instantiate a new iOS Driver.
		 */
		androidDriver = new AndroidDriver( new URL( appiumURL ), options );
	}

	public static void startDriver ( String appiumURL, int serverIndex ) throws MalformedURLException, URISyntaxException {
		/*
		Validate if the driver is already running.
		 */
		if ( androidDriver != null ) return;

		/*
		Load an Android Driver.
		 */
		loadDriver( appiumURL, serverIndex );
	}

	public static void stopDriver ( ) {
		/*
		Validate if the driver is stopped.
		 */
		if ( androidDriver == null ) return;

		/*
		Stop Android Driver.
		 */
		androidDriver.quit( );
		androidDriver = null;
		logger.info( "AndroidDriver stopped" );
	}
}
