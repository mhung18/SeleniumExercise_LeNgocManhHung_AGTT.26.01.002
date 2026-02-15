package Railway;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import Common.Utilities;
import Constant.Constant;

public class BookTicketPage extends GeneralPage{
	private final By _ddlDepartDate = By.name("Date");
	private final By _ddlDepartStation = By.name("DepartStation");
	private final By _ddlArriveStation = By.name("ArriveStation");
	private final By _ddlSeatType = By.name("SeatType");
	private final By _ddlTicketAmount = By.name("TicketAmount");
	private final By _btnBookTicket = By.xpath("//input[@value=\"Book ticket\"]");
	private final By _lblSuccessfulBooking = By.xpath("//div[@id=\"content\"]/h1[text()=\"Ticket booked successfully!\"]");
	private final By _currentDepartDate = By.xpath("//select[@name=\"Date\"]/option[1]");
	private final String _infoTicketBooked = "(//tr/td)[count(//tr/th[text()=\"%s\"]/preceding-sibling::th)+1]";

	
	public WebElement getDepartDate () {
		return Constant.WEBDRIVER.findElement(_ddlDepartDate);
	}
	public WebElement getDepartStation () {
		return Constant.WEBDRIVER.findElement(_ddlDepartStation);
	}
	public WebElement getArriveStation () {
		return Constant.WEBDRIVER.findElement(_ddlArriveStation);
	}
	public WebElement getSeatType () {
		return Constant.WEBDRIVER.findElement(_ddlSeatType);
	}
	public WebElement getTicketAmount () {
		return Constant.WEBDRIVER.findElement(_ddlTicketAmount);
	}
	public WebElement getLblSuccessfulBooking () {
		return Constant.WEBDRIVER.findElement(_lblSuccessfulBooking);
	}
	public WebElement getBtnBookTicket() {
		return Constant.WEBDRIVER.findElement(_btnBookTicket);
	}
	
	public String getSelectedDepartStation() {
	    Utilities.waitForElementLocated(_ddlDepartStation);
	    Select select = new Select(this.getDepartStation());
	    return select.getFirstSelectedOption().getText();
	}

	public String getSelectedArriveStation() {
	    Utilities.waitForElementLocated(_ddlArriveStation);
	    Select select = new Select(this.getArriveStation());
	    return select.getFirstSelectedOption().getText();
	}

	public String getCurrentDepartDate () {
	    Utilities.waitForElementVisible(_currentDepartDate);
	    return Utilities.getTextOfElement(_currentDepartDate).trim();
	}
	
	public BookTicketPage selectDepartDate(String date) {
		Utilities.scrollToElement(_ddlDepartDate);
		Select selectDate = new Select(this.getDepartDate());
        selectDate.selectByVisibleText(date);
        return this;
	}
	
	public BookTicketPage selectDepartStation(String departStation) {
		Utilities.scrollToElement(_ddlDepartStation);
		Select selectDepartStation = new Select(this.getDepartStation());
		selectDepartStation.selectByVisibleText(departStation);
		return this;
	}
	
	public BookTicketPage selectArriveStation(String arriveStation) {
		Utilities.scrollToElement(_ddlArriveStation);
		Select selectArriveStation = new Select(this.getArriveStation());
		selectArriveStation.selectByVisibleText(arriveStation);
		return this;
	}
	
	public BookTicketPage selectSeatType(String seatType) {
		Utilities.scrollToElement(_ddlSeatType);
		Select selectSeatType = new Select(this.getSeatType());
		selectSeatType.selectByVisibleText(seatType);
		return this;
	}
	
	public BookTicketPage selectTicketAmount(String ticketAmount) {
		Utilities.scrollToElement(_ddlTicketAmount);
		Select selectTicketAmount = new Select(this.getTicketAmount());
		selectTicketAmount.selectByVisibleText(ticketAmount);
		return this;
	}
	
	public BookTicketPage bookNewTicket(TicketInfo ticketInfo) {
		if (!ticketInfo.getDepartDate().isEmpty()) {
			this.selectDepartDate(ticketInfo.getDepartDate());
		}
		if (!ticketInfo.getDepartStation().isEmpty()) {
			this.selectDepartStation(ticketInfo.getDepartStation());
		}
		if (!ticketInfo.getArriveStattion().isEmpty()) {
			Utilities.waitForOptionPresent(_ddlArriveStation, ticketInfo.getArriveStattion(), 10);
			this.selectArriveStation(ticketInfo.getArriveStattion());
		}
		if (!ticketInfo.getSeatType().isEmpty()) {
			this.selectSeatType(ticketInfo.getSeatType());
		}
		if (!ticketInfo.getTicketAmount().isEmpty()) {
			this.selectTicketAmount(ticketInfo.getTicketAmount());
		}
		Utilities.click(_btnBookTicket);
		return this;
	}
	
	public BookTicketPage bookNewTicketWithCurrentRoute (TicketInfo ticketInfo) {
		if (!ticketInfo.getDepartDate().isEmpty()) {
			this.selectDepartDate(ticketInfo.getDepartDate());
		}
		if (!ticketInfo.getSeatType().isEmpty()) {
			this.selectSeatType(ticketInfo.getSeatType());
		}
		if (!ticketInfo.getTicketAmount().isEmpty()) {
			this.selectTicketAmount(ticketInfo.getTicketAmount());
		}
		Utilities.click(_btnBookTicket);
		return this;
	}
	
	public String getLblSuccessfulBookingMsg () {
		Utilities.waitForElementVisible(_lblSuccessfulBooking);
		return Utilities.getTextOfElement(_lblSuccessfulBooking);
	}
	
	public String getDataOfTableColumn (String thName) {
		return Utilities.getTextOfElement(By.xpath(String.format(_infoTicketBooked, thName)));
	}

	public String getDatePlusDays(int days) {
	    String currentDepartDate = getCurrentDepartDate();

	    DateTimeFormatter formatter =
	            DateTimeFormatter.ofPattern(Constant.DATE_FORMAT);

	    return LocalDate.parse(currentDepartDate, formatter)
	            .plusDays(days)
	            .format(formatter);
	}
}
