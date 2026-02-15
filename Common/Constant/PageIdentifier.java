package Constant;

public enum PageIdentifier {
	HOME("Safe Railway"),
	REGISTER("Safe Railway - Register an Account"),
	LOGIN("Safe Railway - Login"),
	BOOKTICKET("Safe Railway - Book Ticket"),
	TIMETABLE("Safe Railway - Train Timetable"),
	FAQ("Safe Railway - FAQ"),
	CONTACT("Safe Railway"),
	TICKETPRICE("Safe Railway - Train ticket price list"),
	MYTICKET("Safe Railway - My Ticket");
	
	private String title;
	
	PageIdentifier(String title) {
		this.title = title;
	}
	
	public String getPageIdentifier () {
		return this.title;
	}
}
