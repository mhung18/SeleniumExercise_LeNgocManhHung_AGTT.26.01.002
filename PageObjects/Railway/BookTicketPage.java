package Railway;

import java.lang.invoke.ConstantBootstraps;
import java.lang.invoke.VarHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Constant.Constant;

public class BookTicketPage extends GeneralPage{
	private final By _departDate = By.name("Date");
	private final By _departStation = By.name("DepartStation");
	private final By _arriveStation = By.name("ArriveStation");
	private final By _seatType = By.name("SeatType");
	private final By _ticketAmount = By.name("TicketAmount");
	private final By _btnBookTicket = By.xpath("//input[@value=\"Book ticket\"]");
	
	public BookTicketPage selectDepartDate(String date) {
		WebElement departDateElement =  Constant.WEBDRIVER.findElement(_departDate);
		Select selectDate = new Select(departDateElement);
        selectDate.selectByVisibleText(date);
        return this;
	}
	
	public BookTicketPage selectDepartStation(String departStation) {
		WebElement departStationElement =  Constant.WEBDRIVER.findElement(_departStation);
		Select selectDepartStation = new Select(departStationElement);
		selectDepartStation.selectByVisibleText(departStation);
		return this;
	}
	
	public BookTicketPage selectArriveStation(String arriveStation) {
		WebElement arriveStationElement = Constant.WEBDRIVER.findElement(_arriveStation);
		Select selectArriveStation = new Select(arriveStationElement);
		selectArriveStation.selectByVisibleText(arriveStation);
		return this;
	}
	
	public BookTicketPage selectSeatType(String seatType) {
		WebElement seatTypeElement = Constant.WEBDRIVER.findElement(_seatType);
		Select selectSeatType = new Select(seatTypeElement);
		selectSeatType.selectByVisibleText(seatType);
		return this;
	}
	
	public BookTicketPage selectTicketAmount(String ticketAmount) {
		WebElement ticketAmountElement = Constant.WEBDRIVER.findElement(_ticketAmount);
		Select selectTicketAmount = new Select(ticketAmountElement);
		selectTicketAmount.selectByVisibleText(ticketAmount);
		return this;
	}
	
	public WebElement getBtnBookTicket() {
		return Constant.WEBDRIVER.findElement(_btnBookTicket);
	}
	
	public BookTicketPage bookNewTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
		this.selectDepartDate(departDate);
		this.selectDepartStation(departStation);
		this.selectArriveStation(arriveStation);
		this.selectSeatType(seatType);
		this.selectTicketAmount(ticketAmount);
		
		this.getBtnBookTicket().click();
		
		return this;
	}
}
