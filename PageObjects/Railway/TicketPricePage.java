package Railway;

import org.openqa.selenium.By;
import org.testng.Assert;

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
	
	public TicketPricePage checkPriceOfEachSeatType (String expected_HS_Price, String expected_SS_Price, String expected_SSC_Price, String expected_HB_Price, String expected_SB_Price, String expected_SBC_Price) {
		String actual_HS_Price = this.getPriceOfSeatType("HS");
		String actual_SS_Price = this.getPriceOfSeatType("SS");
		String actual_SSC_Price = this.getPriceOfSeatType("SSC");
		String actual_HB_Price = this.getPriceOfSeatType("HB");
		String actual_SB_Price = this.getPriceOfSeatType("SB");
		String actual_SBC_Price = this.getPriceOfSeatType("SBC");
		
		Assert.assertEquals(actual_HS_Price, expected_HS_Price, "HS Price is not displayed as expected");
		Assert.assertEquals(actual_SS_Price, expected_SS_Price, "SS Price is not displayed as expected");
		Assert.assertEquals(actual_SSC_Price, expected_SSC_Price, "SSC Price is not displayed as expected");
		Assert.assertEquals(actual_HB_Price, expected_HB_Price, "HB Price is not displayed as expected");
		Assert.assertEquals(actual_SB_Price, expected_SB_Price, "SB Price is not displayed as expected");
		Assert.assertEquals(actual_SBC_Price, expected_SBC_Price, "SBC Price is not displayed as expected");
		return this;
	}
}
