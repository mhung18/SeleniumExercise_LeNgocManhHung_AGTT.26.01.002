package Railway;

import org.openqa.selenium.By;
import Constant.Constant;
import Constant.SeatType;

public class TicketPricePage extends GeneralPage{
	private final String _dymSeatPrice = "(//th[starts-with(text(),\"Price\")]/following-sibling::td)[count(//td[text()=\"%s\"]/preceding::td)+1]";
	
	public String getPriceOfSeatType (SeatType seatType) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format(_dymSeatPrice, seatType))).getText();
	}
}
