package Railway;

import org.openqa.selenium.By;
import Common.Utilities;
import Constant.Constant;

public class TimeTablePage extends GeneralPage{
	public final String _dymActionWithRoute = "//td[text()=\"%s\"]/following-sibling::td[text()=\"%s\"]/following-sibling::td/a[text()=\"%s\"]";
	
	public TicketPricePage checkPriceRoute (String departStation, String arriveStation) {
		String xpathString = String.format(_dymActionWithRoute, departStation, arriveStation, "check price");
		Utilities.scrollToElement(By.xpath(xpathString));
		Constant.WEBDRIVER.findElement(By.xpath(xpathString)).click();
		return new TicketPricePage();
	}
	
	public BookTicketPage bookTicketWithRoute (String departStation, String arriveStation) {
		String xpathString = String.format(_dymActionWithRoute, departStation, arriveStation, "book ticket");
		Utilities.scrollToElement(By.xpath(xpathString));
		Constant.WEBDRIVER.findElement(By.xpath(xpathString)).click();
		return new BookTicketPage();
	}
}
