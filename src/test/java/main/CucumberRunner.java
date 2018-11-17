package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.google.common.io.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import helpers.ReportHelper;

@CucumberOptions(strict = true, monochrome = true, features = "src/test/resources/features", glue = "stepdefinition", format = {"pretty","json:target/cucumber.json"}, tags = { "@Regression,@JunitScenario,@TestngScenario" })

public class CucumberRunner extends AbstractTestNGCucumberTests {

	public static Properties config = null;
	public static WebDriver driver = null;

	public void LoadConfigProperty() throws IOException {
		config = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
		config.load(ip);
	}

	public void configureDriverPath() throws IOException {
		if(System.getProperty("os.name").startsWith("Linux")) {
			String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/geckodriver";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
		if(System.getProperty("os.name").startsWith("Mac")) {
			String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/geckodriver";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
		if(System.getProperty("os.name").startsWith("Windows")) {
			String firefoxDriverPath = System.getProperty("user.dir") + "//src//test//resources//drivers//windows//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			String chromeDriverPath = System.getProperty("user.dir") + "//src//test//resources//drivers//windows//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
	}

	public void openBrowser() throws Exception {
		// loads the config options
		LoadConfigProperty();
		// configures the driver path
		configureDriverPath();
		if (config.getProperty("browserType").equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (config.getProperty("browserType").equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options);
		}
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void pageLoad(int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public void setEnv() throws Exception {
		LoadConfigProperty();
		String baseUrl = config.getProperty("siteUrl");
		driver.get(baseUrl);
	}

	public static String currentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String cal1 = dateFormat.format(cal.getTime());
		return cal1;
	}

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		openBrowser();
		maximizeWindow();
		implicitWait(30);
		deleteAllCookies();
		setEnv();
	}

	@AfterClass(alwaysRun = true)
	public void takeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trgtFile = new File(System.getProperty("user.dir") + "//screenshots/screenshot.png");
		trgtFile.getParentFile().mkdir();
		trgtFile.createNewFile();
		Files.copy(scrFile, trgtFile);

	}

	@AfterMethod(alwaysRun = true)
	public void tearDownr(ITestResult result) throws IOException {
		if (result.isSuccess()) {
			File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String failureImageFileName = result.getMethod().getMethodName()
					+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
			File failureImageFile = new File(System.getProperty("user.dir") + "//screenshots//" + failureImageFileName);
			failureImageFile.getParentFile().mkdir();
			failureImageFile.createNewFile();
			Files.copy(imageFile, failureImageFile);
		}

	}
	@AfterSuite(alwaysRun=true)
	public void generateHTMLReports() {
		ReportHelper.generateCucumberReport();
	}

	@AfterSuite(alwaysRun = true)
	public void quit() throws IOException, InterruptedException {
		driver.quit();
	}
}
