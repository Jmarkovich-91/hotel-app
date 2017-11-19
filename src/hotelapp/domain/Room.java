package hotelapp.domain;

import java.io.Serializable;

public class Room implements Serializable {
	
	private String roomNumber;
	private String type;
	private Double price;
	private boolean booked;
	
	public String getRoomNumber () {
		return roomNumber;
	}
	
	public void setRoomNumber (String rn) {
		this.roomNumber = rn;
	}
	
	public String getType () {
		return type;
	}
	
	public void setType (String type) {
		this.type = type;
	}
	
	public Double getPrice () {
		return price;
	}
	
	public void setPrice (Double price) {
		this.price = price;
	}
	
	public boolean getBooked () {
		return booked;
	}
	
	public void setBooked (boolean booked) {
		this.booked = booked;
	}
	
	public String toString () {
		StringBuffer buffer = new StringBuffer ();
		buffer.append("Room Number: " + roomNumber + ";");
		buffer.append("Room Type: " + type + ";");
		buffer.append("Price: " + price + ";");
		buffer.append("Available: " + booked);
		return buffer.toString();
	}

}
