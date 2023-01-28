package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/*
This class contains all the steps that are made up of different actions
 */
public class CompoundSteps extends BaseSteps {

    @Given("I am an user searching with the characteristics {string}, {string}, {string}, {string}, {string}, {string}")
    public void iAmAnUserSearchingWithTheCharacteristics(String destinationName, String initialDate, String finalDate, String rooms, String adults, String children) {
    }

}
