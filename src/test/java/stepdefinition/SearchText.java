package stepdefinition;

import org.openqa.selenium.By;

import cucumber.api.java.en.When;
import main.CucumberRunner;

public class SearchText extends CucumberRunner {

	@When("^I type \"(.*?)\"$")
	public void searchText(String text) throws Throwable {

		driver.findElement(By.cssSelector("input[name='q']")).sendKeys(text);

	}

}
