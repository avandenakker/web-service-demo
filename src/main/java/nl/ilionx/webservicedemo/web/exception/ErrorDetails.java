package nl.ilionx.webservicedemo.web.exception;

import java.util.Date;

public class ErrorDetails {
	
	private Date timestamp;
	private String message;
	private String details;
	
	public ErrorDetails(Date timestamp, String message, String detials) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = detials;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetials() {
		return details;
	}
	public void setDetials(String detials) {
		this.details = detials;
	}
	
	

}
