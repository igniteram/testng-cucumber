## Testng-Cucumber-Boilerplate  [![Build Status](https://travis-ci.org/igniteram/testng-cucumber.svg?branch=master)](https://travis-ci.org/igniteram/testng-cucumber)
Simple boilerplate to kick start your testng-cucumber maven java project with some additional features like "CucumberOptions": tags, glue, screenshots, set environment/browser methods
##Features
* Crisp & Clear maven folder structures
* Extensive methods in CucumberRunner class
* CucumberOptions with detailed explanation of using "tags", "glue"
* Screenshots on failure feature in **CucumberRunner** class
* TestNG Annotations/hooks like "BeforeSuite", "AfterClass", "AfterMethod" etc.
* Descriptive pom.xml and testng.xml
* Examples with multiple features and step definition files
* Methods for running tests in Firefox and Chrome browsers

##To Get Started

####Pre-requisites
1. The scripts have been written in **MacOSX** environment. Windows users please change the ```"System.getProperty"``` in the CucumberRunner class
2. Java installed in the system
3. Maven installed in the system
4. IDE(Jetbrains or Eclipse) installed in the system

####Run Scripts
* Fork this repo, keep the folder the structure intact
* Run the testng.xml or mvn clean test since it is an maven project
* The scripts should run successfully in **Firefox** browser as it is defined in the config.properties file.
* To run the scripts in Chrome browser, specific chromedriver(windows/linux) should be downloaded and config.prop should be set to browser_type as "Chrome"
* Target folder should be created with cucumber-html-report and surefire-reports.
* **Test_Output** folder should be created with the default testng reports

####Writing Features
>     Feature: To search cucumber in google
     @Regression
     Scenario: Cucumber Google
       Given I am in google page
       When I type "cucumber"
       Then I click submit button
       Then I clear search textbox

####Writing Step Definitions
>     public class Clearpage extends CucumberRunner {
      @Then("^I clear search textbox$")
      public void Clear() throws Throwable {
      driver.findElement(By.cssSelector("input[name='q']")).clear();
      }
      }

####Cucumber Options
>     @CucumberOptions(
      	strict = true,
      	monochrome = true,
      	features = {"src/test/resources/features/"},
      	glue = "stepdefinition",
      	plugin = {"pretty", "html:target/cucumber-html-report" },
      	tags={"@Regression,@JunitScenario,@TestngScenario"})

####Screenshot Hooks/Annotations
>      @AfterMethod(alwaysRun = true)
     	public void tearDownr(ITestResult result) throws IOException {
     		if (result.isSuccess()) {
     			File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     			String failureImageFileName = result.getMethod().getMethodName()
     					+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
     			File failureImageFile = new File(System.getProperty("user.dir") + "//screenshots//" + failureImageFileName);
     			FileUtils.copyFile(imageFile, failureImageFile);
     		}
     		}

####HTML Reports
Default cucumber HTML reports are generated which can be customized according to specific needs
##### Success Cucumber Report

![successcucumberreport](https://raw.githubusercontent.com/igniteram/testng-cucumber/master/images/success%20cucumber%20report.png)


##Contributions
For contributors who want to improve this repo by contributing some code, reporting bugs, issues or improving documentation - PR's are highly welcome, please maintain the coding style , folder structure , detailed description of documentation and bugs/issues with examples if possible.