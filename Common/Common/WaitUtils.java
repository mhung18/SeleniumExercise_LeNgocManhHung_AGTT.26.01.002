package Common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;

public class WaitUtils {
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
}
