package stepdefinition;

import org.openqa.selenium.By;

import cucumber.api.java.en.Then;
import main.CucumberRunner;

public class Submit extends CucumberRunner {

	@Then("^I click submit button$")
	public void submitButton() throws Throwable {
		driver.findElement(By.name("btnG")).click();

	}

}
