package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.Utilities;
import Constant.City;
import Constant.Constant;
import Constant.MenuPage;
import Constant.PageIdentifier;
import Constant.SeatType;

public class BookTicketTest extends BaseTest{
	@Test
	public void TC12() {
		// Create Data Object
		TicketInfo ticketInfo = new TicketInfo(
				Constant.DEPARTDATE, 
				City.NHATRANG, 
				City.HUE, 
				SeatType.SBC, 
				"1");

		// Expected Messages
		String expectedMsg = "Ticket booked successfully!";
		
		// Main Test 
		System.out.println("TC12: User can book 1 ticket at a time");

		System.out.println("Pre-condition: an actived account is existing");
		UserInfo userInfo = createAndActiveAccount();

		System.out.println("1. Navigate to QA Railway Login page");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Login with a valid account ");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, PageIdentifier.LOGIN, LoginPage.class);
		homePage = loginPage.login(userInfo);
		
		System.out.println("3. Click on \"Book ticket\" tab");
		BookTicketPage bookTicketPage = homePage.goToPage(MenuPage.BOOKTICKET, PageIdentifier.BOOKTICKET, BookTicketPage.class);
		
		System.out.println("4. Select the next 2 days from \"Depart date\"");
		ticketInfo.setDepartDate(bookTicketPage.getDatePlusDays(2));
		System.out.println("5. Select Depart from \"Nha Trang\" and Arrive at \"Huế\"");
		System.out.println("6. Select \"Soft bed with air conditioner\" for \"Seat type\"");
		System.out.println("7. Select \"1\" for \"Ticket amount\"");
		System.out.println("8. Click on \"Book ticket\" button");
		bookTicketPage.bookNewTicket(ticketInfo);       
		
		System.out.println("VP: Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		String actualMsg = bookTicketPage.getLblSuccessfulBookingMsg();
		Assert.assertEquals(actualMsg, expectedMsg, "Successful Booking Message is not displayed as expected");
		
		String actualDepartDate = bookTicketPage.getDataOfTableColumn("Depart Date");
		Assert.assertEquals(actualDepartDate, ticketInfo.getDepartDate(), "Depart Date is not displayed as expected");
		
		String actualDepartStation = bookTicketPage.getDataOfTableColumn("Depart Station");
		Assert.assertEquals(actualDepartStation, ticketInfo.getDepartStation(), "Depart Station is not displayed as expected");
		
		String actualArriveStation = bookTicketPage.getDataOfTableColumn("Arrive Station");
		Assert.assertEquals(actualArriveStation, ticketInfo.getArriveStattion(), "Arrive Station is not displayed as expected");
		
		String actualSeatType = bookTicketPage.getDataOfTableColumn("Seat Type");
		Assert.assertEquals(actualSeatType, ticketInfo.getSeatType(), "Seat Type is not displayed as expected");
		
		String actualTicketAmount = bookTicketPage.getDataOfTableColumn("Amount");
		Assert.assertEquals(actualTicketAmount, ticketInfo.getTicketAmount(), "Ticket Amount is not displayed as expected");
	}
	
	@Test
	public void TC13() {
		// Create Data Object
		TicketInfo ticketInfo = new TicketInfo(
				Constant.DEPARTDATE, 
				City.NHATRANG, 
				City.SAIGON, 
				SeatType.SSC, 
				"5");
		
		// Expected Messages
		String expectedMsg = "Ticket booked successfully!";
				
		// Main Test 
		System.out.println("TC13: User can book many tickets at a time");

		System.out.println("Pre-condition: an actived account is existing");
		UserInfo userInfo = createAndActiveAccount();

		System.out.println("1. Navigate to QA Railway Login page");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Login with a valid account ");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, PageIdentifier.LOGIN, LoginPage.class);
		homePage = loginPage.login(userInfo);
		
		System.out.println("3. Click on \"Book ticket\" tab");
		BookTicketPage bookTicketPage = homePage.goToPage(MenuPage.BOOKTICKET, PageIdentifier.BOOKTICKET, BookTicketPage.class);
		
		System.out.println("4. Select the next 25 days from \"Depart date\"");
		ticketInfo.setDepartDate(bookTicketPage.getDatePlusDays(25));
		
		System.out.println("5. Select \"Nha Trang\" for \"Depart from\" and \"Sài Gòn\" for \"Arrive at\".");
		System.out.println("6. Select \"Soft seat with air conditioner\" for \"Seat type\"");
		System.out.println("7. Select \"5\" for \"Ticket amount\"");
		System.out.println("8. Click on \"Book ticket\" button");
		bookTicketPage.bookNewTicket(ticketInfo);
		
		System.out.println("VP: Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		String actualMsg = bookTicketPage.getLblSuccessfulBookingMsg();
		Assert.assertEquals(actualMsg, expectedMsg, "Successful Booking Message is not displayed as expected");
		
		String actualDepartDate = bookTicketPage.getDataOfTableColumn("Depart Date");
		Assert.assertEquals(actualDepartDate, ticketInfo.getDepartDate(), "Depart Date is not displayed as expected");
		
		String actualDepartStation = bookTicketPage.getDataOfTableColumn("Depart Station");
		Assert.assertEquals(actualDepartStation, ticketInfo.getDepartStation(), "Depart Station is not displayed as expected");

		String actualArriveStation = bookTicketPage.getDataOfTableColumn("Arrive Station");
		Assert.assertEquals(actualArriveStation, ticketInfo.getArriveStattion(), "Arrive Station is not displayed as expected");

		String actualSeatType = bookTicketPage.getDataOfTableColumn("Seat Type");
		Assert.assertEquals(actualSeatType, ticketInfo.getSeatType(), "Seat Type is not displayed as expected");

		String actualTicketAmount = bookTicketPage.getDataOfTableColumn("Amount");
		Assert.assertEquals(actualTicketAmount, ticketInfo.getTicketAmount(), "Ticket Amount is not displayed as expected");
	}
	
	@Test
	public void TC14() {
		// Expected Messages
		String expected_HS_Price = "310000";
		String expected_SS_Price = "335000";
		String expected_SSC_Price = "360000";
		String expected_HB_Price = "410000";
		String expected_SB_Price = "460000";
		String expected_SBC_Price = "510000";
		
		// Main Test 
		System.out.println("TC14: User can check price of ticket from Timetable");
		
		System.out.println("Pre-condition: an actived account is existing");
		UserInfo userInfo = createAndActiveAccount();
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Login with a valid account");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, PageIdentifier.LOGIN, LoginPage.class);
		homePage = loginPage.login(userInfo);
		
		System.out.println("3. Click on \"Timetable\" tab");
		TimeTablePage timeTablePage = homePage.goToPage(MenuPage.TIMETABLE, PageIdentifier.TIMETABLE, TimeTablePage.class);
		
		System.out.println("4. Click on \"check price\" link of the route from \"Đà Nẵng\" to \"Sài Gòn\"");
		TicketPricePage ticketPricePage = timeTablePage.checkPriceRoute("Đà Nẵng", "Sài Gòn");
		
		System.out.println("VP: \"Ticket Price\" page is loaded.\n"
				+ "VP: Ticket table shows \"Ticket price from Đà Nẵng to Sài Gòn\".\n"
				+ "VP: Price for each seat displays correctly\n"
				+ "HS = 310000, SS = 335000, SSC = 360000, HB = 410000, SB = 460000, SBC = 510000");
		// parameters: HS price / SS price / SSC price / HB price / SB price / SBC price		
		String actual_HS_Price = ticketPricePage.getPriceOfSeatType(SeatType.HS);
		Assert.assertEquals(actual_HS_Price, expected_HS_Price, "HS Price is not displayed as expected");

		String actual_SS_Price = ticketPricePage.getPriceOfSeatType(SeatType.SS);
		Assert.assertEquals(actual_SS_Price, expected_SS_Price, "SS Price is not displayed as expected");

		String actual_SSC_Price = ticketPricePage.getPriceOfSeatType(SeatType.SSC);
		Assert.assertEquals(actual_SSC_Price, expected_SSC_Price, "SSC Price is not displayed as expected");

		String actual_HB_Price = ticketPricePage.getPriceOfSeatType(SeatType.HB);
		Assert.assertEquals(actual_HB_Price, expected_HB_Price, "HB Price is not displayed as expected");

		String actual_SB_Price = ticketPricePage.getPriceOfSeatType(SeatType.SB);
		Assert.assertEquals(actual_SB_Price, expected_SB_Price, "SB Price is not displayed as expected");

		String actual_SBC_Price = ticketPricePage.getPriceOfSeatType(SeatType.SBC);
		Assert.assertEquals(actual_SBC_Price, expected_SBC_Price, "SBC Price is not displayed as expected");
	}
	
	@Test
	public void TC15() {
		// Create Data Object
		String tomorrowDate = Utilities.getDatePlusDays(1);
		TicketInfo ticketInfo = new TicketInfo(
				tomorrowDate,
				City.QUANGNGAI,
				City.HUE,
				Constant.SEATTYPE,
				"5");
		
		// Expected Messages
		String expectedMsg = "Ticket booked successfully!";
		String expectedDepartStation = "Quảng Ngãi";
		String expectedArriveStation = "Huế";
		
		// Main Test 
		System.out.println("TC15: User can book ticket from Timetable");
		
		System.out.println("Pre-condition: an actived account is existing");
		UserInfo userInfo = createAndActiveAccount();
		
		System.out.println("1. Navigate to QA Railway Website");
		HomePage homePage = new HomePage();
		homePage.open();
		
		System.out.println("2. Login with a valid account");
		LoginPage loginPage = homePage.goToPage(MenuPage.LOGIN, PageIdentifier.LOGIN, LoginPage.class);
		homePage = loginPage.login(userInfo);
		
		System.out.println("3. Click on \"Timetable\" tab");
		TimeTablePage timeTablePage = homePage.goToPage(MenuPage.TIMETABLE, PageIdentifier.TIMETABLE, TimeTablePage.class);
		
		System.out.println("4. Click on book ticket of route \"Quảng Ngãi\" to \"Huế\"");
		BookTicketPage bookTicketPage = timeTablePage.bookTicketWithRoute(
				ticketInfo.getDepartStation(), 
				ticketInfo.getArriveStattion());
		
		System.out.println("VP: Book ticket form is shown with the corrected \"depart from\" and \"Arrive at\"");
		String actualSelectedDepartStation = bookTicketPage.getSelectedDepartStation();
		Assert.assertEquals(actualSelectedDepartStation, expectedDepartStation, "Selected Depart Station is not displayed as expected");
		
		String actualSelectedArriveStation = bookTicketPage.getSelectedArriveStation();
		Assert.assertEquals(actualSelectedArriveStation, expectedArriveStation, "Selected Arrive Station is not displayed as expected");
		
		System.out.println("5. Select Depart date = tomorrow");
		System.out.println("6. Select Ticket amount = 5");
		System.out.println("7. Click on \"Book ticket\" button");
		bookTicketPage.bookNewTicketWithCurrentRoute(ticketInfo);
		
		System.out.println("VP: Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
		String actualMsg = bookTicketPage.getLblSuccessfulBookingMsg();
		Assert.assertEquals(actualMsg, expectedMsg, "Successful Booking Message is not displayed as expected");
		
		String actualDepartDate = bookTicketPage.getDataOfTableColumn("Depart Date");
		Assert.assertEquals(actualDepartDate, ticketInfo.getDepartDate(), "Depart Date is not displayed as expected");

		String actualDepartStation = bookTicketPage.getDataOfTableColumn("Depart Station");
		Assert.assertEquals(actualDepartStation, ticketInfo.getDepartStation(), "Depart Station is not displayed as expected");

		String actualArriveStation = bookTicketPage.getDataOfTableColumn("Arrive Station");
		Assert.assertEquals(actualArriveStation, ticketInfo.getArriveStattion(), "Arrive Station is not displayed as expected");

		String actualSeatType = bookTicketPage.getDataOfTableColumn("Seat Type");
		Assert.assertEquals(actualSeatType, ticketInfo.getSeatType(), "Seat Type is not displayed as expected");

		String actualTicketAmount = bookTicketPage.getDataOfTableColumn("Amount");
		Assert.assertEquals(actualTicketAmount, ticketInfo.getTicketAmount(), "Ticket Amount is not displayed as expected");
	}
}
