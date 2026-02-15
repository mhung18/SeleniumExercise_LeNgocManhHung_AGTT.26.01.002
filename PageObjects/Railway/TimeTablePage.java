package Railway;

import org.openqa.selenium.By;
import Common.Utilities;

public class TimeTablePage extends GeneralPage{
	public static By _lblUniqueTimeTablePageTitle = By.xpath("//h1[text()='Train Timetable']");
	public final String _dymActionWithRoute = "//td[text()=\"%s\"]/following-sibling::td[text()=\"%s\"]/following-sibling::td/a[text()=\"%s\"]";
	
	public TicketPricePage checkPriceRoute (String departStation, String arriveStation) {
		String xpathString = String.format(_dymActionWithRoute, departStation, arriveStation, "check price");
		Utilities.scrollToElement(By.xpath(xpathString));
		Utilities.click(By.xpath(xpathString));
		return new TicketPricePage();
	}
	
	public BookTicketPage bookTicketWithRoute (String departStation, String arriveStation) {
		String xpathString = String.format(_dymActionWithRoute, departStation, arriveStation, "book ticket");
		Utilities.scrollToElement(By.xpath(xpathString));
		Utilities.click(By.xpath(xpathString));
		return new BookTicketPage();
	}
}
