package com.deloitte;


public class Movie {

	private int id;
	private String name; 
	private String showdate; 
	private double showtime; 
	private boolean status;
	public Movie(int id, String name, String showdate, double showtime, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.showdate = showdate;
		this.showtime = showtime;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShowdate() {
		return showdate;
	}
	public void setShowdate(String showdate) {
		this.showdate = showdate;
	}
	public double getShowtime() {
		return showtime;
	}
	public void setShowtime(double showtime) {
		this.showtime = showtime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", showdate=" + showdate + ", showtime=" + showtime + ", status="
				+ status + "]";
	} 
	
	
	
	
	
	

}
