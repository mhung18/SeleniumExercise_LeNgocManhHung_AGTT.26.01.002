package Common;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constant.Constant;

public class Utilities {
	public static By waitForElementClickable (By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(timeout));
		wait.until(
				ExpectedConditions.elementToBeClickable(locator)
		);
		return locator;
	}
	
	public static By waitForElementVisible (By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(timeout));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(locator)
		);
		return locator;
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
		waitForElementVisible(locator, 10);
		WebElement webElement = Constant.WEBDRIVER.findElement(locator);
		scrollToElement(webElement);
	}
	
	public static void scrollToElement(WebElement w) {
		JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
		js.executeScript("arguments[0].scrollIntoView(true)", w);
	}
	
	public static boolean isDisplayed(String element) {
		try {
			return Constant.WEBDRIVER.findElement(By.xpath(element)).isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public static String generateRandomEmail() { 
		String keys = "asdfghjkqwertyuiopzxcvbnmqwertyuioopASDFGHJKLQWERTYUIOPZXCVBNM1234567890";
		Random randomIntRandom = new Random();
		int length = 8;
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
}


