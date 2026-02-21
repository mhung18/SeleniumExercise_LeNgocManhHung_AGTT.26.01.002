# SeleniumExercise_LeNgocManhHungSele_AGTT.26.01.002

A Selenium WebDriver automation testing project for the Railway booking website, built with Java, Selenium, TestNG, and Maven.

---

## Environment Setup

### 1. Install Java JDK (Recommended version: JDK 25)
- Download from: [Download Java JDK](https://www.oracle.com/java/technologies/downloads/)
- Set environment variable `JAVA_HOME` pointing to your JDK installation folder
- Add `%JAVA_HOME%\bin` to your `PATH`
- Verify: `java -version`

### 2. Config file pom.xml
- Navigate to: [Maven Repository](https://mvnrepository.com/)
- Search for: **Selenium Java** and **TestNG**
- Choose the latest version
- Copy the maven dependencies
- Paste to pom.xml

### 3. Install TestNG Plugin in Eclipse
1. Open Eclipse → **Help** → **Eclipse Marketplace**
2. Search for **TestNG**
3. Click **Install** on *TestNG for Eclipse*
4. Restart Eclipse when prompted

---

## Installation

### 1. Clone the repository
```bash
git clone https://github.com/mhung18/SeleniumExercise_LeNgocManhHung_AGTT.26.01.002.git
cd SeleniumExercise_LeNgocManhHungSele_AGTT.26.01.002
```

### 2. Import project into Eclipse
1. Open Eclipse → **File** → **Import**
2. Select **Maven** → **Existing Maven Projects**
3. Browse to the project folder → Click **Finish**
4. Wait for Maven to download all dependencies automatically

---

## Running Tests

### Run a Single Test Case

1. In **Package Explorer**, navigate to the test class (e.g., `Railway/BookTicketTest.java`)
2. Locate the test method (e.g., TC10)
3. Right-click on the method name (e.g., TC10)
4. Right-click the specific test method → **Run As** → **TestNG Test**

### Run a Test Class (Many TCs)

1. Right-click the test class file → **Run As** → **TestNG Test**
2. All test cases within the class will be executed

### Run a Test Suite (testng.xml)

1. In **Package Explorer**, find `testng.xml` in the project root
2. Right-click `testng.xml` → **Run As** → **TestNG Suite**

---

## Project Structure

```
LeNgocManhHung-AGTT.26.01.002/
│
├── Common/
│   └── Common/
│       ├── Utilities.java              # Common helper methods
│       └── WaitUtils.java              # WebDriverWait utility methods
│
├── Common/
│   └── Constant/
│       ├── City.java                   # City enum/constants
│       ├── Constant.java               # Global constants (URL, Default Value, Date Format, etc.)
│       ├── MenuPage.java               # Menu page enum/constants
│       ├── PageIdentifier.java         # Page identifier enum/constants
│       └── SeatType.java               # Seat type enum/constants
│
├── PageObjects/
│   ├── Guerrillamail/
│   │   └── MainPage.java               # Guerrilla Mail page object
│   └── Railway/
│       ├── BookTicketPage.java         # Book Ticket page object
│       ├── FAQPage.java                # FAQ page object
│       ├── ForgotPasswordPage.java     # Forgot Password page object
│       ├── GeneralPage.java            # Base page class (shared methods)
│       ├── HomePage.java               # Home page object
│       ├── LoginPage.java              # Login page object
│       ├── MyTicketPage.java           # My Ticket page object
│       ├── RegisterPage.java           # Register page object
│       ├── TicketPricePage.java        # Ticket Price page object
│       └── TimeTablePage.java          # Timetable page object
│
├── DataObjects/
│   └── Railway/
│       ├── TicketInfo.java             # Ticket data object
│       └── UserInfo.java               # User data object
│
├── TestCases/
│   └── Railway/
│       ├── BaseTest.java               # Base test class (setup/teardown)
│       ├── BookTicketTest.java         # Test cases for booking tickets
│       ├── CancelBookingTest.java      # Test cases for cancelling bookings
│       ├── CreateAccountTest.java      # Test cases for account creation
│       ├── LoginTest.java              # Test cases for login
│       ├── LogoutTest.java             # Test cases for logout
│       └── ResetPasswordTest.java      # Test cases for reset password
│
├── testng.xml                          # Test suite configuration
└── pom.xml                             # Maven dependencies
```

---

## Viewing Test Reports

After running tests, TestNG generates reports automatically:

- Navigate to `test-output/` folder in your project root
- Find and right-click `index.html` 
- Right-click **Open With** → **Web Browser** to view the full report in browser
- Or open `emailable-report.html` for a summary report

---

## Configuration

Key settings can be found in `Constant.java`:

```java
public class Constant {
	public static WebDriver WEBDRIVER;
	// URL
	public static final String RAILWAY_URL = "http://saferailway.somee.com/Page/HomePage.cshtml";
	public static final String GURERRILLAMAIL_URL = "https://www.guerrillamail.com/inbox";
    ...
}
```