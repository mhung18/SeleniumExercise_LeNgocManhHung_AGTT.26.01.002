package Constant;

public enum City {
	SAIGON("Sài Gòn"),
	PHANTHIET("Phan Thiết"),
	NHATRANG("Nha Trang"),
	DANANG("Đà Nẵng"),
	HUE("Huế"),
	QUANGNGAI("Quảng Ngãi");
	
	private String _cityName;
	
	City(String cityName) {
        this._cityName = cityName;
    }
    
    public String getCityName() {
        return _cityName;
    }
}
