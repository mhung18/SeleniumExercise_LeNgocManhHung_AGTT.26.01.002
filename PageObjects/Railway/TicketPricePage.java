package Railway;

import org.openqa.selenium.By;

import Constant.Constant;

public class TicketPricePage extends GeneralPage{
	private final String _dymSeatType = "//div[@class=\"DivTable\"]//td[text()=\"%s\"]";
	private final String _dymSeatPrice = "//div[@class='DivTable']//th[normalize-space()='Price (VND)']/following-sibling::td[%s]";
	
	public int getCellIndexOfSeatType(String seatType) {
		String xpathString = String.format(_dymSeatType, seatType);
		return Integer.parseInt(Constant.WEBDRIVER.findElement(By.xpath(xpathString)).getAttribute("cellIndex"));
	}
	
	public String getPriceOfSeatType (String seatType) {
		int index = getCellIndexOfSeatType(seatType);
		return Constant.WEBDRIVER.findElement(By.xpath(String.format(_dymSeatPrice, index))).getText();
	}
}
