package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.MenuPage;
import Constant.Constant;

public class BookTicketTest extends BaseTest{
	@Test
	public void TC12() {
		String expectedMsg = "Ticket booked successfully!";
		TicketInfo ticketInfo = new TicketInfo(
				Constant.DEPARTDATE, 
				Constant.DEPARTSTATION, 
				Constant.ARRIVESTATION, 
				Constant.SEATTYPE, 
				Constant.TICKETAMOUNT);
		System.out.println("User can book 1 ticket at a time");

		System.out.println("Pre-condition: an actived account is existing");
		UserInfo userInfo = createAndActiveAccount();

		System.out.println("1. Navigate to QA Railway Login page");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Login with a valid account ");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, LoginPage.class);
		homePage = loginPage.login(userInfo);
		
		System.out.println("3. Click on \"Book ticket\" tab");
		BookTicketPage bookTicketPage = homePage.goToPage(MenuPage.BOOKTICKET, BookTicketPage.class);
		
		System.out.println("4. Select the next 2 days from \"Depart date\"");
		System.out.println("5. Select Depart from \"Nha Trang\" and Arrive at \"Huế\"");
		ticketInfo.setDepartStation("Nha Trang");
		ticketInfo.setArriveStation("Huế");
		System.out.println("6. Select \"Soft bed with air conditioner\" for \"Seat type\"");
		ticketInfo.setSeatType("Soft bed with air conditioner");
		System.out.println("7. Select \"1\" for \"Ticket amount\"");
		ticketInfo.setTicketAmount("1");
		System.out.println("8. Click on \"Book ticket\" button");
		bookTicketPage.bookNewTicket(
				ticketInfo.getDepartDate(), 
				ticketInfo.getDepartStation(), 
				ticketInfo.getArriveStattion(), 
				ticketInfo.getSeatType(), 
				ticketInfo.getTicketAmount());
		
		System.out.println("VP: Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		String actualMsg = bookTicketPage.getLblSuccessfulBookingMsg();
		Assert.assertEquals(actualMsg, expectedMsg, "Successful Booking Message is not displayed as expected");
		
		String expectedDepartDate = ticketInfo.getDepartDate();
		String expectedDepartStation = ticketInfo.getDepartStation();
		String expectedArriveStation = ticketInfo.getArriveStattion();
		String expectedSeatType = ticketInfo.getSeatType();
		String expectedTicketAmount = ticketInfo.getTicketAmount();
		
		String actualDepartDate = bookTicketPage.getDataOfTableColumn("Depart Date");
		String actualDepartStation = bookTicketPage.getDataOfTableColumn("Depart Station");
		String actualArriveStation = bookTicketPage.getDataOfTableColumn("Arrive Station");
		String actualSeatType = bookTicketPage.getDataOfTableColumn("Seat Type");
		String actualTicketAmount = bookTicketPage.getDataOfTableColumn("Amount");
		
		Assert.assertEquals(actualDepartDate, expectedDepartDate, "Depart Date is not displayed as expected");
		Assert.assertEquals(actualDepartStation, expectedDepartStation, "Depart Station is not displayed as expected");
		Assert.assertEquals(actualArriveStation, expectedArriveStation, "Arrive Station is not displayed as expected");
		Assert.assertEquals(actualSeatType, expectedSeatType, "Seat Type is not displayed as expected");
		Assert.assertEquals(actualTicketAmount, expectedTicketAmount, "Ticket Amount is not displayed as expected");
	}
	
	@Test
	public void TC13() {
		String expectedMsg = "Ticket booked successfully!";
		TicketInfo ticketInfo = new TicketInfo(
				Constant.DEPARTDATE, 
				Constant.DEPARTSTATION, 
				Constant.ARRIVESTATION, 
				Constant.SEATTYPE, 
				Constant.TICKETAMOUNT);
		System.out.println("User can book many tickets at a time");

		System.out.println("Pre-condition: an actived account is existing");
		UserInfo userInfo = createAndActiveAccount();

		System.out.println("1. Navigate to QA Railway Login page");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Login with a valid account ");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, LoginPage.class);
		homePage = loginPage.login(userInfo);
		
		System.out.println("3. Click on \"Book ticket\" tab");
		BookTicketPage bookTicketPage = homePage.goToPage(MenuPage.BOOKTICKET, BookTicketPage.class);
		
		System.out.println("4. Select the next 25 days from \"Depart date\"");
		System.out.println("5. Select \"Nha Trang\" for \"Depart from\" and \"Sài Gòn\" for \"Arrive at\".");
		ticketInfo.setDepartStation("Nha Trang");
		ticketInfo.setArriveStation("Sài Gòn");
		System.out.println("6. Select \"Soft seat with air conditioner\" for \"Seat type\"");
		ticketInfo.setSeatType("Soft seat with air conditioner");
		System.out.println("7. Select \"5\" for \"Ticket amount\"");
		ticketInfo.setTicketAmount("5");
		System.out.println("8. Click on \"Book ticket\" button");
		bookTicketPage.bookNewTicket(
				ticketInfo.getDepartDate(), 
				ticketInfo.getDepartStation(), 
				ticketInfo.getArriveStattion(), 
				ticketInfo.getSeatType(), 
				ticketInfo.getTicketAmount());
		
		System.out.println("VP: Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		String actualMsg = bookTicketPage.getLblSuccessfulBookingMsg();
		System.out.println("actual msg: " + actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "Successful Booking Message is not displayed as expected");
		
		String expectedDepartDate = ticketInfo.getDepartDate();
		String expectedDepartStation = ticketInfo.getDepartStation();
		String expectedArriveStation = ticketInfo.getArriveStattion();
		String expectedSeatType = ticketInfo.getSeatType();
		String expectedTicketAmount = ticketInfo.getTicketAmount();
		
		String actualDepartDate = bookTicketPage.getDataOfTableColumn("Depart Date");
		String actualDepartStation = bookTicketPage.getDataOfTableColumn("Depart Station");
		String actualArriveStation = bookTicketPage.getDataOfTableColumn("Arrive Station");
		String actualSeatType = bookTicketPage.getDataOfTableColumn("Seat Type");
		String actualTicketAmount = bookTicketPage.getDataOfTableColumn("Amount");
		
		Assert.assertEquals(actualDepartDate, expectedDepartDate, "Depart Date is not displayed as expected");
		Assert.assertEquals(actualDepartStation, expectedDepartStation, "Depart Station is not displayed as expected");
		Assert.assertEquals(actualArriveStation, expectedArriveStation, "Arrive Station is not displayed as expected");
		Assert.assertEquals(actualSeatType, expectedSeatType, "Seat Type is not displayed as expected");
		Assert.assertEquals(actualTicketAmount, expectedTicketAmount, "Ticket Amount is not displayed as expected");
	}
	
	@Test
	public void TC14() {
		System.out.println("User can check price of ticket from Timetable");
		
		System.out.println("Pre-condition: an actived account is existing");
		
		System.out.println("1. Navigate to QA Railway Website");
		
		System.out.println("2. Login with a valid account");
		
		System.out.println("3. Click on \"Timetable\" tab");
		
		System.out.println("4. Click on \"check price\" link of the route from \"Đà Nẵng\" to \"Sài Gòn\"");
		
		System.out.println("VP: \"Ticket Price\" page is loaded.\n"
				+ "VP: Ticket table shows \"Ticket price from Đà Nẵng to Sài Gòn\".\n"
				+ "VP: Price for each seat displays correctly\n"
				+ "HS = 310000, SS = 335000, SSC = 360000, HB = 410000, SB = 460000, SBC = 510000");
	}
	
	@Test
	public void TC15() {
		System.out.println("User can book ticket from Timetable");
		
		System.out.println("Pre-condition: an actived account is existing");
		
		System.out.println("1. Navigate to QA Railway Website");
		
		System.out.println("2. Login with a valid account");
		
		System.out.println("3. Click on \"Timetable\" tab");
		
		System.out.println("4. Click on book ticket of route \"Quảng Ngãi\" to \"Huế\"");
		
		System.out.println("5. Select Depart date = tomorrow");
		
		System.out.println("6. Select Ticket amount = 5");
		
		System.out.println("7. Click on \"Book ticket\" button");
		
		System.out.println("VP: Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		
	}
}
