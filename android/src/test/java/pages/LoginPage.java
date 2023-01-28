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
	@AndroidFindBy( xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]" )
	private RemoteWebElement closeButton;

	public void clickCloseButton( ) {
		closeButton.click( );
		logger.info( "Click on the 'CLOSE' button" );
	}

	public void validateWelcomeToBookingLabel( ) {
		assertTrue( welcomeToBookingLabel.isDisplayed( ), "Sign in or create an account' label is not displayed" );
		logger.info( "The 'Sign in or create an account' label is displayed" );
	}


}
