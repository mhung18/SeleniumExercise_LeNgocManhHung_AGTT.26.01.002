package Common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import Constant.Constant;

public class Utilities {
	

	public static void scrollToEndPage () {
		JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void scrollByPixel (int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
		js.executeScript("window.scrollBy(0,arguments[0])", pixel);
	}
	
	public static void scrollToElement(By locator) {
		WaitUtils.waitForElementVisible(locator);
		WebElement webElement = Constant.WEBDRIVER.findElement(locator);
		scrollToElement(webElement);
	}
	
	public static void scrollToElement(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
		js.executeScript("arguments[0].scrollIntoView(true)", webElement);
	}
	
	public static boolean isDisplayed(By locator) {
		try {
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
		WaitUtils.waitForElementLocated(locator);
		WebElement element = WaitUtils.waitForElementLocated(locator);
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].click();", element);
	}
	
	public static void enter (By locator, String text) {
		WaitUtils.waitForElementLocated(locator);
		Utilities.scrollToElement(locator);
		WebElement element = Constant.WEBDRIVER.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	public static String getTextOfElement (WebElement webElement) {
		return webElement.getText();
	}
	
	public static String getTextOfElement (By locator) {
		WaitUtils.waitForElementVisible(locator);
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
		WaitUtils.waitForPageFullyLoad();
		return Constant.WEBDRIVER.getTitle();
	}
}


