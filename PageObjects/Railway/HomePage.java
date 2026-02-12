package Railway;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;

public class HomePage extends GeneralPage{
	public static final By _linkToCreateAccount = By.xpath("//a[text()=\"create an account\"]");
	
	public WebElement getLinkToCreateAccount () {
		return Constant.WEBDRIVER.findElement(_linkToCreateAccount);
	}
	
	public HomePage open() {
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
		return new HomePage();
	}
}
