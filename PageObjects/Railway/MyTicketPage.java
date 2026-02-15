package Railway;

import org.openqa.selenium.By;
import Common.Utilities;
import Constant.Constant;

public class MyTicketPage extends GeneralPage{
	private final String _infoTicket = "//div[@class='DivTable']//tr[td[normalize-space()='%s'] "
			+ "and td[normalize-space()='%s'] "
			+ "and td[normalize-space()='%s'] "
			+ "and td[normalize-space()='%s'] "
			+ "and td[normalize-space()='%s'] ]"
			+ "//input[@value='Cancel']";

	public MyTicketPage cancelTicket (TicketInfo ticketInfo) {
		String ticketXpath = String.format(
				_infoTicket, 
				ticketInfo.getDepartStation(), 
				ticketInfo.getArriveStattion(), 
				ticketInfo.getDepartDate(),
				ticketInfo.getSeatType(), 
				ticketInfo.getTicketAmount());
		Utilities.click(By.xpath(ticketXpath));
		Constant.WEBDRIVER.switchTo().alert().accept();
		return this;
	}
	
	public boolean checkIsTicketExist (TicketInfo ticketInfo) {
		String ticketXpath = String.format(
				_infoTicket, 
				ticketInfo.getDepartStation(), 
				ticketInfo.getArriveStattion(), 
				ticketInfo.getDepartDate(),
				ticketInfo.getSeatType(), 
				ticketInfo.getTicketAmount());
		return Utilities.isDisplayed(By.xpath(ticketXpath));
	}
}
