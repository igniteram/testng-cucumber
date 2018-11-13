package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import main.CucumberRunner;
import pages.SearchPage;

public class SearchButton extends CucumberRunner {

	SearchPage page = new SearchPage();

	@Then("^I click search button$")
	public void clickSearchButton() throws Throwable {
		explicitWait(page.searchBox);
		page.searchBox.sendKeys(Keys.ENTER);

	}

}
