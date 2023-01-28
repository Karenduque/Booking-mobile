package extensions;

import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;

public class ExpectedConditionsExtension {

	public static ExpectedCondition< Boolean > elementDisappear ( By locator ) {
		return webDriver -> {
			assert webDriver != null;
			return webDriver.findElements( locator ).isEmpty( );
		};
	}

}
