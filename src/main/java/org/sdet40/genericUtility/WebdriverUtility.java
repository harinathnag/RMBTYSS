package org.sdet40.genericUtility;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverUtility {

	private static final String TakesScreenshot = null;
	JavascriptExecutor jsExecutor;

	public WebDriver launchBrowser(String browser)
	{
		WebDriver driver = null;
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("you entered wrong browser key in the property file");
		}
		return driver;
	}

	public void maximizeBrowser(WebDriver driver) {

		driver.manage().window().maximize();

	}

	public void waitTillPageLoad(WebDriver driver,Long longTimeOut) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeOut));
	}

	public void navigateApplication(WebDriver driver, String url) {

		driver.get(url);

	}

	public  WebDriver openBrowserWithApplication(String browser,  String url) {
		WebDriver driver = launchBrowser(browser);
		maximizeBrowser(driver);

		navigateApplication(driver, url);
		return driver;


	}

	public void mouseHoverAction(WebDriver driver, WebElement element) {

		new Actions(driver).doubleClick().perform();

	}

	public void closeBrowser(WebDriver driver) {

		driver.quit();

	}

	public void waitTillElementVisible(WebDriver driver, long timeOuts, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOuts));
		wait.until(ExpectedConditions.visibilityOf(element));


	}

	public void switchToWindow(WebDriver driver, String partialText) {

		Set<String> winIds = driver.getWindowHandles();
		for(String id : winIds)
		{
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains(partialText)) {

				break;

			}
		}

	}
	public void jsInitialization(WebDriver driver) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;

	}

	public void openApplicationUsingJS(String url)
	{

		jsExecutor.executeScript("window.location = arguments[0]", url);

	}

	public void sendKeysUsingJS(WebElement element, String data) {

		jsExecutor.executeScript("arguments[0].value = arguments[1]", element, data);

	}

	public void clickUsingJS(WebElement element) {

		jsExecutor.executeScript("arguments[0].click()", element);

	}

	public void scrollTillElementUsingJS(WebElement element) {

		jsExecutor.executeScript("arguments[0].scrollIntoView()", element);

	}

	public void selectClass(WebElement element, String VisibleText) {

		Select sc = new Select(element);
		sc.selectByVisibleText(VisibleText);

	}

	public String alertHandle(WebDriver driver) {

		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();

		return text;

	} 
	public void screenShot(WebDriver driver, JavaUtility javaUtility, String className) throws IOException
	{
		String currentTime = javaUtility.currentTime();
		TakesScreenshot tss = (TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+className+"_"+currentTime+".png");
		FileUtils.copyFile(src, dst);

	}
	public void tcValidationUsingStringText(String actualCondition, String expectedCondition)
	{
		assertEquals(actualCondition, expectedCondition);
	}
	public void tcValidationUsingSoftAssert(String actualCondition, String expectedCondition)
	{
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(actualCondition.contains(expectedCondition));
		softAssert.assertAll();
	}
/*	public void verifyAccountNumber(WebDriver driver, String expectedCondition)
	{
		
	}   */


		
	}






