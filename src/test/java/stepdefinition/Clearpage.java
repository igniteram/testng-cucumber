package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import main.CucumberRunner;

public class Clearpage extends CucumberRunner {
	

	@Then("^I clear search textbox$")
	public void Clear() throws Throwable {
		WebElement clearSearchBox = driver.findElement(By.cssSelector("input[name='q']"));
		explicitWait(clearSearchBox);
		clearSearchBox.clear();

	}

}
