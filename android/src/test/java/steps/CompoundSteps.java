package steps;

import io.cucumber.java.en.Given;
import pages.LoginPage;

/*
This class contains all the steps that are made up of different actions
 */
public class CompoundSteps extends BaseSteps {

    @Given("I am an user searching with the characteristics {string}, {string}, {string}, {string}, {string}, {string}")
    public void iAmAnUserSearchingWithTheCharacteristics(String destinationName, String initialDate, String finalDate, String rooms, String adults, String children) {
        instanceOf( LoginPage.class ).clickCloseButton( );
        instanceOf( LoginPage.class ).clickIconDestinationViewText( );
       // instanceOf( LoginPage.class ).fillDestinationViewText( destinationName);

    }

}
