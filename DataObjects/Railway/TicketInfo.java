package Railway;

import Constant.City;
import Constant.SeatType;

public class TicketInfo {
	private String _departStation;
	private String _departDate;
	private String _arriveStation;
	private String _seatType;
	private String _ticketAmount;
	
	public TicketInfo(String departDate, City departStation, City arriveStation, SeatType seatType, String ticketAmount) {
		this._departDate = departDate;
		this._departStation = departStation.getCityName();
		this._arriveStation = arriveStation.getCityName();
		this._seatType = seatType.getSeatType();
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

	
	public void setDepartStation(String _departStation) {
		this._departStation = _departStation;
	}
	public void setDepartDate(String _departDate) {
		this._departDate = _departDate;
	}
	public void setArriveStation(String _arriveStation) {
		this._arriveStation = _arriveStation;
	}
	public void setSeatType(SeatType seatType) {
		this._seatType = seatType.getSeatType();
	}
	public void setTicketAmount(String _ticketAmount) {
		this._ticketAmount = _ticketAmount;
	}
}
