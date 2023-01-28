package appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import readers.AppiumJsonReader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AppiumServer {

	private static AppiumDriverLocalService appiumServer = AppiumDriverLocalService.buildDefaultService( );

	public static void start ( int index ) {
		/*
		Load appium information from appium.json file.
		 */
		AppiumJsonReader.getInstance( );

		/*
		Retrieve ip & port values from properties reader class.
		 */
		String ip = AppiumJsonReader.getIP( index );
		int port = AppiumJsonReader.getPort( index );
		String androidHome = AppiumJsonReader.getAndroidSDKPath( );
		String javaHome = AppiumJsonReader.getJavaHomePath( );
		String nodePath = AppiumJsonReader.getNodePath( );
		String executablePath = AppiumJsonReader.getExecutablePath( );
		String logPath = AppiumJsonReader.getLogPath( );

		/*
		Set the environment variables to run APPIUM SERVER.
		 */
		Map< String, String > env = new HashMap<>( System.getenv( ) );
		env.put( "PATH", "bin:/usr/bin:/sbin:/usr/sbin:/usr/local/bin:" + env.get( "PATH" ) );
		env.put( "ANDROID_HOME", androidHome );
		env.put( "JAVA_HOME", javaHome );

		/*
		Set up appium builder before launch.
		 */
		AppiumServiceBuilder appiumBuilder = new AppiumServiceBuilder( );
		appiumBuilder.withEnvironment( env );
		appiumBuilder.usingDriverExecutable( new File( nodePath ) );
		appiumBuilder.withAppiumJS( new File( executablePath ) );
		appiumBuilder.withIPAddress( ip );
		appiumBuilder.withArgument( GeneralServerFlag.SESSION_OVERRIDE );
		appiumBuilder.withArgument( GeneralServerFlag.LOG_LEVEL, "error" );
		appiumBuilder.withArgument( GeneralServerFlag.BASEPATH, "/wd/hub/" );
		appiumBuilder.withLogFile( new File( logPath ) );

		/*
		If port value is -1, appium will start up with any free port, else appium will start up with port define in json file.
		 */
		if ( port == -1 ) {
			appiumBuilder.usingAnyFreePort( );
		} else {
			appiumBuilder.usingPort( port );
		}

		/*
		Set up appium server and start.
		 */
		appiumServer = AppiumDriverLocalService.buildService( appiumBuilder );
		appiumServer.start( );
	}

	public static String getURL ( ) {
		/*
		Return the appium server URL.
		 */
		return appiumServer.getUrl( ).toString( );
	}

	public static boolean isRunning ( ) {
		/*
		Validate if APPIUM Server is running or not.
		 */
		return appiumServer.isRunning( );
	}

	public static void stop ( ) {
		/*
		Stop APPIUM Server.
		 */
		appiumServer.stop( );
	}

}
