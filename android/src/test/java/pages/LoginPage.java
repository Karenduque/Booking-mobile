package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebElement;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {

	private final Logger logger = LogManager.getLogger( );
	@AndroidFindBy( xpath = "//android.widget.ImageButton" )
	private RemoteWebElement closeButton;
	@AndroidFindBy(id = "com.booking:id/facet_search_box_basic_field_label")
	private RemoteWebElement iconDestinationViewText;

	@AndroidFindBy(xpath = "android.widget.TextView')")
	private RemoteWebElement destinationViewText;

//	@AndroidFindBy( accessibility = "" )
//	private RemoteWebElement dateViewText;

	public void clickCloseButton( ) {
		closeButton.click( );
		logger.info( "Click on the 'CLOSE' button" );
	}

	public void clickIconDestinationViewText( ) {
		iconDestinationViewText.click();
	}
	public void fillDestinationViewText(String destinationName ) {
		destinationViewText.getCssValue(destinationName);

	}
//	public void fillDateViewText( ) {
//
//	}


}
