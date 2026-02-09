package Constant;

public enum SeatType {
	HS("Hard seat"),
	SS("Soft seat"),
	SSC("Soft seat with air conditioner"),
	HB("Hard bed"),
	SB("Soft bed"),
	SBC("Soft bed with air conditioner");
	
	private final String _seatType;
	
	SeatType(String seatType) {
		this._seatType = seatType;
	}
	
	public String getSeatType() {
		return this._seatType;
	}
}
