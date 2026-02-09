package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.City;
import Constant.Constant;
import Constant.MenuPage;
import Constant.SeatType;

public class BookTicketTest extends BaseTest{
	@Test
	public void TC12() {
		String theNext2Days = getDatePlusDays(2);
		
		TicketInfo ticketInfo = new TicketInfo(
				theNext2Days, 
				City.NHATRANG.getCityName(), 
				City.HUE.getCityName(), 
				SeatType.SBC.getSeatType(), 
				"1");

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
		System.out.println("5. Select Depart from \"Nha Trang\" and Arrive at \"Huế\"");
		System.out.println("6. Select \"Soft bed with air conditioner\" for \"Seat type\"");
		System.out.println("7. Select \"1\" for \"Ticket amount\"");
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
		bookTicketPage.checkInformationOfCreatedTicket(ticketInfo);
	}
	
	@Test
	public void TC13() {
		String theNext25Days = getDatePlusDays(25);
		TicketInfo ticketInfo = new TicketInfo(
				theNext25Days, 
				City.NHATRANG.getCityName(), 
				City.SAIGON.getCityName(), 
				SeatType.SSC.getSeatType(), 
				"5");
		
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
		System.out.println("5. Select \"Nha Trang\" for \"Depart from\" and \"Sài Gòn\" for \"Arrive at\".");
		System.out.println("6. Select \"Soft seat with air conditioner\" for \"Seat type\"");
		System.out.println("7. Select \"5\" for \"Ticket amount\"");
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
		bookTicketPage.checkInformationOfCreatedTicket(ticketInfo);
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
		// parameters: HS price / SS price / SSC price / HB price / SB price / SBC price
		ticketPricePage.checkPriceOfEachSeatType("310000", "335000", "360000", "410000", "460000", "510000");
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
		BookTicketPage bookTicketPage = timeTablePage.bookTicketWithRoute(
				ticketInfo.getDepartStation(), 
				ticketInfo.getArriveStattion());
		
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
		bookTicketPage.checkInformationOfCreatedTicket(ticketInfo);
	}
}
