package Common;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constant.Constant;

public class Utilities {
	public static By waitForElementClickable (By locator) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(Constant.TIMEOUT_WAIT_SECOND));
		wait.until(
				ExpectedConditions.elementToBeClickable(locator)
		);
		return locator;
	}
	
	public static By waitForElementVisible (By locator) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(Constant.TIMEOUT_WAIT_SECOND));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(locator)
		);
		return locator;
	}
	
	public static void waitForOptionPresent(By selectLocator, String optionText, int timeout) {
	    WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(timeout));
	    wait.until(driver -> {
	    	Select select = new Select(driver.findElement(selectLocator));
	    	return select.getOptions().stream().anyMatch(o -> o.getText().trim().equals(optionText));
	    });
	}
	
	public static void waitForPageFullyLoad() {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(Constant.TIMEOUT_WAIT_SECOND));
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
	}
	
	public static WebElement waitForElementLocated(By locator) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(Constant.TIMEOUT_WAIT_SECOND));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void waitForTitleExist(String title) {
		 WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.titleIs(title));
	}

	public static void scrollToEndPage () {
		JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void scrollByPixel (int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
		js.executeScript("window.scrollBy(0,arguments[0])", pixel);
	}
	
	public static void scrollToElement(By locator) {
		waitForElementVisible(locator);
		WebElement webElement = Constant.WEBDRIVER.findElement(locator);
		scrollToElement(webElement);
	}
	
	public static void scrollToElement(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
		js.executeScript("arguments[0].scrollIntoView(true)", webElement);
	}
	
	public static boolean isDisplayed(By locator) {
		try {
			Utilities.waitForElementLocated(locator);
			Constant.WEBDRIVER.findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String generateRandomEmail() { 
		String keys = "asdfghjkqwertyuiopzxcvbnmqwertyuioopASDFGHJKLQWERTYUIOPZXCVBNM1234567890";
		Random randomIntRandom = new Random();
		int length = 10;
		String randomString = "";
		for(int i = 0;i < length;i++) {
			int randomIndex = randomIntRandom.nextInt(keys.length());
			randomString += keys.charAt(randomIndex);
		}
		return randomString + "@sharklasers.com";
	}
	
	public static String getEmailPartName(String email) {
		return email.split("@")[0];
	}
	
	public static void switchToLatestTab() {
	    List<String> tabs = new ArrayList<>(Constant.WEBDRIVER.getWindowHandles());
	    Constant.WEBDRIVER.switchTo().window(tabs.get(tabs.size() - 1));
	}
	
	public static void click (By locator) {
		Utilities.waitForElementLocated(locator);
		WebElement element = waitForElementLocated(locator);
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].click();", element);
	}
	
	public static void enter (By locator, String text) {
		Utilities.waitForElementLocated(locator);
		WebElement element = Constant.WEBDRIVER.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	public static String getTextOfElement (WebElement webElement) {
		return webElement.getText();
	}
	
	public static String getTextOfElement (By locator) {
		Utilities.waitForElementVisible(locator);
		WebElement webElement = Constant.WEBDRIVER.findElement(locator);
		return getTextOfElement(webElement);
	}
	
	public static String getToday() {
	    return LocalDate.now()
	            .format(DateTimeFormatter.ofPattern(Constant.DATE_FORMAT));
	}
	
	public static String getDatePlusDays(int plusDays) {
	    return LocalDate.now()
	            .plusDays(plusDays)
	            .format(DateTimeFormatter.ofPattern(Constant.DATE_FORMAT));
	}
	
	public static void closeAllTabsExceptMain(String tabtitle) {
		for (String handle : Constant.WEBDRIVER.getWindowHandles()) {
			Constant.WEBDRIVER.switchTo().window(handle);
			if(!Constant.WEBDRIVER.getTitle().contains(tabtitle)) {
				Constant.WEBDRIVER.close();
			}
		}
		String mainTab = Constant.WEBDRIVER.getWindowHandle();
		Constant.WEBDRIVER.switchTo().window(mainTab);
	}
	
	public static String getTitle () {
		Utilities.waitForPageFullyLoad();
		return Constant.WEBDRIVER.getTitle();
	}
}


