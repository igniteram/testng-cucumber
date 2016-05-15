##Testng-Cucumber-Boilerplate
Simple boilerplate to kick start your testng-cucumber maven java project with some additional features like "CucumberOptions": tags, glue and pre-made screenshots, set environment/browser methods
##Features
* Crisp & Clear maven folder structure
* Extensive & Descriptive methods in CucumberRunner class
* CucumberOptions with detailed explanation of using "tags", "glue"
* Screenshots on failure feature in CucumberRunner class
* Testng Annotations/hooks like "BeforeSuite", "AfterClass", "AfterMethod" etc.
* Descriptive pom.xml and testng.xml
* Examples with multiple features and step definition files
* Methods for running tests in Firefox and Chrome browsers
##To Get Started
####Pre-requisites
1. The scripts have been written in Linux/MacOSX environment for Windows users please do not forget to change the "System.getProperty" in the CucumberRunner class
2. Java installed in the system
3. Maven installed in the system
4. IDE(Jetbrains or Eclipse) installed in the system
####Run Scripts
* Fork this repo, keep the folder the structure intact
* Run the testng.xml or cucumberRunner class directly
* The scripts should run successfully in firefox browser as it is defined in the config.properties file.
* Target folder should be created with cucumber-html-report and surefire-reports.
* Test_Output folder should be created with the testng reports
