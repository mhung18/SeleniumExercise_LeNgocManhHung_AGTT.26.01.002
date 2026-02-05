package Railway;

public class UserInfo {
	private String _email;
	private String _password;
	private String _passportId;
	
	public UserInfo(String email, String password, String passportId) {
		this._email = email;
		this._password = password;
		this._passportId = passportId;
	}	

	public String getUserEmail() {
		return this._email;
	}
	
	public String getUserPassword() {
		return this._password;
	}
	
	public String getUserPassportId() {
		return this._passportId;
	}
}
