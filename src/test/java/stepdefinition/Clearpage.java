package stepdefinition;

import cucumber.api.java.en.Then;
import main.CucumberRunner;
import pages.SearchPage;

public class ClearPage extends CucumberRunner {

	SearchPage page = new SearchPage();

	@Then("^I clear search textbox$")
	public void Clear() throws Throwable {
		explicitWait(page.searchBox);
		page.searchBox.clear();

	}

}
