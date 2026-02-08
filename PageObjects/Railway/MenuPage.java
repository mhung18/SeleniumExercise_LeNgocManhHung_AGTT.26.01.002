package Railway;

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

	
    private final String _pageName;

    
    MenuPage(String pageName) {
        this._pageName = pageName;
    }

    
    public String getPageName() {
        return _pageName;
    }
}

