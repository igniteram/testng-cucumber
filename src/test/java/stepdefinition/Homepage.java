package stepdefinition;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import main.CucumberRunner;

public class Homepage extends CucumberRunner {

	@Given("^I am in google page$")
	public void googlePage() throws Throwable {

		String title = driver.getTitle();

		Assert.assertEquals(title, "Google");
	}

}
