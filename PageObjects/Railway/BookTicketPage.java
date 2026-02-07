package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Common.Utilities;
import Constant.Constant;

public class BookTicketPage extends GeneralPage{
	private final By _departDate = By.name("Date");
	private final By _departStation = By.name("DepartStation");
	private final By _arriveStation = By.name("ArriveStation");
	private final By _seatType = By.name("SeatType");
	private final By _ticketAmount = By.name("TicketAmount");
	private final By _btnBookTicket = By.xpath("//input[@value=\"Book ticket\"]");
	private final By _lblSuccessfulBooking = By.xpath("//div[@id=\"content\"]/h1[text()=\"Ticket booked successfully!\"]");
	private final String _dymTableHeaderXpath = "//div[@class=\"DivTable\"]//th[text()=\"%s\"]";
	private final String _dymTableDataXpath = "//div[@class=\"DivTable\"]//td[%s]";

	
	public WebElement getDepartDate () {
		return Constant.WEBDRIVER.findElement(_departDate);
	}
	public WebElement getDepartStation () {
		return Constant.WEBDRIVER.findElement(_departStation);
	}
	public WebElement getArriveStation () {
		return Constant.WEBDRIVER.findElement(_arriveStation);
	}
	public WebElement getSeatType () {
		return Constant.WEBDRIVER.findElement(_seatType);
	}
	public WebElement getTicketAmount () {
		return Constant.WEBDRIVER.findElement(_ticketAmount);
	}
	public WebElement getLblSuccessfulBooking () {
		return Constant.WEBDRIVER.findElement(_lblSuccessfulBooking);
	}
	public WebElement getBtnBookTicket() {
		return Constant.WEBDRIVER.findElement(_btnBookTicket);
	}
	
	
	public BookTicketPage selectDepartDate(String date) {
		Select selectDate = new Select(this.getDepartDate());
        selectDate.selectByVisibleText(date);
        return this;
	}
	
	public BookTicketPage selectDepartStation(String departStation) {
		Select selectDepartStation = new Select(this.getDepartStation());
		selectDepartStation.selectByVisibleText(departStation);
		return this;
	}
	
	public BookTicketPage selectArriveStation(String arriveStation) {
		Select selectArriveStation = new Select(this.getArriveStation());
		selectArriveStation.selectByVisibleText(arriveStation);
		return this;
	}
	
	public BookTicketPage selectSeatType(String seatType) {
		Select selectSeatType = new Select(this.getSeatType());
		selectSeatType.selectByVisibleText(seatType);
		return this;
	}
	
	public BookTicketPage selectTicketAmount(String ticketAmount) {
		Select selectTicketAmount = new Select(this.getTicketAmount());
		selectTicketAmount.selectByVisibleText(ticketAmount);
		return this;
	}
	
	public BookTicketPage bookNewTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
		this.selectDepartDate(departDate);
		this.selectDepartStation(departStation);
		Utilities.waitForOptionPresent(_arriveStation, arriveStation, 10);
		this.selectArriveStation(arriveStation);
		this.selectSeatType(seatType);
		this.selectTicketAmount(ticketAmount);
		this.getBtnBookTicket().click();
		return this;
	}
	
	public String getLblSuccessfulBookingMsg () {
		Utilities.waitForElementVisible(_lblSuccessfulBooking, 10);
		return this.getLblSuccessfulBooking().getText();
	}
	
	public int getCellIndexOfTableHeader (String thName) {
		String xpathString = String.format(_dymTableHeaderXpath, thName);
		return Integer.parseInt(Constant.WEBDRIVER.findElement(By.xpath(xpathString)).getAttribute("cellIndex"));
	}
	
	public String getDataOfTableColumn (String thName) {
		int index = getCellIndexOfTableHeader(thName) + 1;
		return Constant.WEBDRIVER.findElement(By.xpath(String.format(_dymTableDataXpath, index))).getText();
	}
}
