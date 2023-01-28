import appium.AppiumServer;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/*
This is the Runner class for failed scenarios, its configuration is similar to the Android Runner class, the only
difference is that the scenarios are loaded from a rerun.txt file that contains all the scenarios that have failed
in previous runs.
 */
@CucumberOptions(
		features = "@target/rerun.txt",
		glue = { "hooks", "steps" },
		plugin = {
				"pretty",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"rerun:target/rerun.txt"
		} )
public class FailedScenariosRunnerTest extends AbstractTestNGCucumberTests {

	@BeforeClass
	public void setUpAppium ( ) {
		/*
		Get the server index sent in the maven run command.
		 */
		int serverIndex = Integer.parseInt( System.getProperty( "server" ) );

		/*
		Start APPIUM Server.
		 */
		AppiumServer.start( serverIndex );
	}

	@AfterClass
	public void tearDownAppium ( ) {
		/*
		Stop APPIUM Server
		 */
		if ( AppiumServer.isRunning( ) ) AppiumServer.stop( );
	}
}