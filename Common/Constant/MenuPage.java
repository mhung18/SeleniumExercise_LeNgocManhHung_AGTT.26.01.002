package Constant;

public enum MenuPage {
    HOME("Home"),
    FAQ("FAQ"),
    CONTACT("Contact"),
    TIMETABLE("Timetable"),
	TICKETPRICE("Ticket price"),
	BOOKTICKET("Book ticket"),
	REGISTER("Register"),
	LOGIN("Login"),
	LOGOUT("Log out"),
	MYTICKET("My ticket"),
	CHANGEPASSWORD("Change password");

    private final String pageName;

    MenuPage(String pageName) {
        this.pageName = pageName;
    }

    public String getPageName() {
        return pageName;
    }
}

