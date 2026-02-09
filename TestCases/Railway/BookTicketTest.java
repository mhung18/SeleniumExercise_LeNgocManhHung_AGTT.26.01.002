package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import Constant.MenuPage;
import Constant.SeatType;

public class BookTicketTest extends BaseTest{
	@Test
	public void TC12() {
		TicketInfo ticketInfo = new TicketInfo(
				Constant.DEPARTDATE, 
				Constant.DEPARTSTATION, 
				Constant.ARRIVESTATION, 
				Constant.SEATTYPE, 
				Constant.TICKETAMOUNT);
		
		String expectedMsg = "Ticket booked successfully!";
		
		System.out.println("User can book 1 ticket at a time");

		System.out.println("Pre-condition: an actived account is existing");
		UserInfo userInfo = createAndActiveAccount();

		System.out.println("1. Navigate to QA Railway Login page");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Login with a valid account ");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, LoginPage.class);
		homePage = loginPage.login(
				userInfo.getUserEmail(),
				userInfo.getUserPassword());
		
		System.out.println("3. Click on \"Book ticket\" tab");
		BookTicketPage bookTicketPage = homePage.goToPage(MenuPage.BOOKTICKET, BookTicketPage.class);
		
		System.out.println("4. Select the next 2 days from \"Depart date\"");
		String theNext2Days = getDatePlusDays(2);
		ticketInfo.setDepartDate(theNext2Days);
		
		System.out.println("5. Select Depart from \"Nha Trang\" and Arrive at \"Huế\"");
		ticketInfo.setDepartStation("Nha Trang");
		ticketInfo.setArriveStation("Huế");
		
		System.out.println("6. Select \"Soft bed with air conditioner\" for \"Seat type\"");
		ticketInfo.setSeatType(SeatType.SBC);
		
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
		
		bookTicketPage.checkInformationOfCreatedTicket(expectedDepartDate, expectedDepartStation, expectedArriveStation, expectedSeatType, expectedTicketAmount);
	}
	
	@Test
	public void TC13() {
		TicketInfo ticketInfo = new TicketInfo(
				Constant.DEPARTDATE, 
				Constant.DEPARTSTATION, 
				Constant.ARRIVESTATION, 
				Constant.SEATTYPE, 
				Constant.TICKETAMOUNT);
		
		String expectedMsg = "Ticket booked successfully!";
		
		System.out.println("User can book many tickets at a time");

		System.out.println("Pre-condition: an actived account is existing");
		UserInfo userInfo = createAndActiveAccount();

		System.out.println("1. Navigate to QA Railway Login page");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Login with a valid account ");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, LoginPage.class);
		homePage = loginPage.login(
				userInfo.getUserEmail(),
				userInfo.getUserPassword());
		
		System.out.println("3. Click on \"Book ticket\" tab");
		BookTicketPage bookTicketPage = homePage.goToPage(MenuPage.BOOKTICKET, BookTicketPage.class);
		
		System.out.println("4. Select the next 25 days from \"Depart date\"");
		String theNext25Days = getDatePlusDays(25);
		ticketInfo.setDepartDate(theNext25Days);
		
		System.out.println("5. Select \"Nha Trang\" for \"Depart from\" and \"Sài Gòn\" for \"Arrive at\".");
		ticketInfo.setDepartStation("Nha Trang");
		ticketInfo.setArriveStation("Sài Gòn");
		
		System.out.println("6. Select \"Soft seat with air conditioner\" for \"Seat type\"");
		ticketInfo.setSeatType(SeatType.SSC);
		
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
		Assert.assertEquals(actualMsg, expectedMsg, "Successful Booking Message is not displayed as expected");
		
		String expectedDepartDate = ticketInfo.getDepartDate();
		String expectedDepartStation = ticketInfo.getDepartStation();
		String expectedArriveStation = ticketInfo.getArriveStattion();
		String expectedSeatType = ticketInfo.getSeatType();
		String expectedTicketAmount = ticketInfo.getTicketAmount();
		
		bookTicketPage.checkInformationOfCreatedTicket(expectedDepartDate, expectedDepartStation, expectedArriveStation, expectedSeatType, expectedTicketAmount);
	}
	
	@Test
	public void TC14() {
		System.out.println("User can check price of ticket from Timetable");
		
		System.out.println("Pre-condition: an actived account is existing");
		UserInfo userInfo = createAndActiveAccount();
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Login with a valid account");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, LoginPage.class);
		homePage = loginPage.login(
				userInfo.getUserEmail(),
				userInfo.getUserPassword());
		
		System.out.println("3. Click on \"Timetable\" tab");
		TimeTablePage timeTablePage = homePage.goToPage(MenuPage.TIMETABLE, TimeTablePage.class);
		
		System.out.println("4. Click on \"check price\" link of the route from \"Đà Nẵng\" to \"Sài Gòn\"");
		TicketPricePage ticketPricePage = timeTablePage.checkPriceRoute("Đà Nẵng", "Sài Gòn");
		
		System.out.println("VP: \"Ticket Price\" page is loaded.\n"
				+ "VP: Ticket table shows \"Ticket price from Đà Nẵng to Sài Gòn\".\n"
				+ "VP: Price for each seat displays correctly\n"
				+ "HS = 310000, SS = 335000, SSC = 360000, HB = 410000, SB = 460000, SBC = 510000");
		String expected_HS_Price = "310000";
		String expected_SS_Price = "335000";
		String expected_SSC_Price = "360000";
		String expected_HB_Price = "410000";
		String expected_SB_Price = "460000";
		String expected_SBC_Price = "510000";
		
		ticketPricePage.checkPriceOfEachSeatType(expected_HS_Price, expected_SS_Price, expected_SSC_Price, expected_HB_Price, expected_SB_Price, expected_SBC_Price);
	}
	
	@Test
	public void TC15() {
		TicketInfo ticketInfo = new TicketInfo(
				Constant.DEPARTDATE, 
				Constant.DEPARTSTATION, 
				Constant.ARRIVESTATION, 
				Constant.SEATTYPE, 
				Constant.TICKETAMOUNT);
		
		String expectedMsg = "Ticket booked successfully!";
		
		System.out.println("User can book ticket from Timetable");
		
		System.out.println("Pre-condition: an actived account is existing");
		UserInfo userInfo = createAndActiveAccount();
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Login with a valid account");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, LoginPage.class);
		homePage = loginPage.login(
				userInfo.getUserEmail(),
				userInfo.getUserPassword());
		
		System.out.println("3. Click on \"Timetable\" tab");
		TimeTablePage timeTablePage = homePage.goToPage(MenuPage.TIMETABLE, TimeTablePage.class);
		
		System.out.println("4. Click on book ticket of route \"Quảng Ngãi\" to \"Huế\"");
		ticketInfo.setDepartStation("Quảng Ngãi");
		ticketInfo.setArriveStation("Huế");
		BookTicketPage bookTicketPage = timeTablePage.bookTicketWithRoute(ticketInfo.getDepartStation(), ticketInfo.getArriveStattion());
		
		System.out.println("5. Select Depart date = tomorrow");
		String tomorrowDate = getDatePlusDays(1);
		ticketInfo.setDepartDate(tomorrowDate);

		System.out.println("6. Select Ticket amount = 5");
		ticketInfo.setTicketAmount("5");
		
		System.out.println("7. Click on \"Book ticket\" button");
		bookTicketPage.bookNewTicketWithCurrentRoute(
				ticketInfo.getDepartDate(),
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
		
		bookTicketPage.checkInformationOfCreatedTicket(expectedDepartDate, expectedDepartStation, expectedArriveStation, expectedSeatType, expectedTicketAmount);
	}
}
