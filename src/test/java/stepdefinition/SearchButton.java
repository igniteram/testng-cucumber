package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import main.CucumberRunner;

public class SearchButton extends CucumberRunner {

	@Then("^I click search button$")
	public void searchButton() throws Throwable {
		WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));
		explicitWait(searchBox);
		searchBox.sendKeys(Keys.ENTER);

	}

}
