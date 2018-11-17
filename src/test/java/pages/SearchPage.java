package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import main.CucumberRunner;

public class SearchPage extends CucumberRunner {

    public WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));
    
}