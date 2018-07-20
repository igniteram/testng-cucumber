package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;
import main.CucumberRunner;

public class SearchText extends CucumberRunner {

	@When("^I type \"(.*?)\"$")
	public void searchText(String text) throws Throwable {
		WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));
		explicitWait(searchBox);
		searchBox.sendKeys(text);

	}

}
