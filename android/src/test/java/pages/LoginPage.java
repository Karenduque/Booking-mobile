package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebElement;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {

	private final Logger logger = LogManager.getLogger( );

	@AndroidFindBy( accessibility = "Sign in or create an account" )
	private RemoteWebElement welcomeToBookingLabel;
	@AndroidFindBy( accessibility = "NEXT" )
	private RemoteWebElement nextButton;

	public void clickCloseButton( ) {
		nextButton.click( );
		logger.info( "Click on the 'NEXT' button" );
	}

	public void validateWelcomeToBookingLabel( ) {
		assertTrue( welcomeToBookingLabel.isDisplayed( ), "Sign in or create an account' label is not displayed" );
		logger.info( "The 'Sign in or create an account' label is displayed" );
	}


}
