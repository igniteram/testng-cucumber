package stepdefinition;

import org.openqa.selenium.By;

import cucumber.api.java.en.Then;
import main.CucumberRunner;

public class SearchButton extends CucumberRunner {

	@Then("^I click search button$")
	public void searchButton() throws Throwable {
		driver.findElement(By.name("btnG")).click();

	}

}
