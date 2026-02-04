package Railway;

public class TicketInfo {
	private String _departStation;
	private String _departDate;
	private String _arriveStation;
	private String _seatType;
	private String _ticketAmount;
	
	public TicketInfo(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
		this._departDate = departDate;
		this._departStation = departStation;
		this._arriveStation = arriveStation;
		this._seatType = seatType;
		this._ticketAmount = ticketAmount;
	}
	
	public String getDepartDate() {
		return this._departDate;
	}
	
	public String getDepartStation() {
		return this._departStation;
	}
	
	public String getArriveStattion() {
		return this._arriveStation;
	}
	
	public String getSeatType() {
		return this._seatType;
	}
	
	public String getTicketAmount() {
		return this._ticketAmount;
	}
}
