package Railway;

import org.testng.annotations.Test;

public class CancelBookingTest {
	@Test
	public void TC16() {
		System.out.println("User can cancel a ticket");
		
		System.out.println("Pre-condition: an actived account is existing");
		
		System.out.println("1. Navigate to QA Railway Website");
		
		System.out.println("2. Login with a valid account");
		
		System.out.println("3. Book a ticket");
		
		System.out.println("4. Click on \"My ticket\" tab");
		
		System.out.println("5. Click on \"Cancel\" button of ticket which user want to cancel.");
		
		System.out.println("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"");
		
		System.out.println("VP: The canceled ticket is disappeared.");
	}
}
