package org.amisescalade.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author nicolasdotnet
 * 
 * Booking is the booking entity for a loan from topo between two users.
 *
 */


@Entity

public class Booking implements Serializable{
	
	@Id @GeneratedValue
	private Long bookingId;
	@JoinColumn(nullable=false)
	private Date bookingDate;
	@JoinColumn(nullable=false)
	private Boolean bookingStatus;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private User bookingUser;
	
	@OneToOne
	@JoinColumn(nullable=false)
	private Topo bookingTopo;
	
	public Booking() {
		super();
	}

	public Booking(Date bookingDate, Boolean bookingStatus, User bookingUser, Topo bookingTopo) {
		super();
		this.bookingDate = bookingDate;
		this.bookingStatus = bookingStatus;
		this.bookingUser = bookingUser;
		this.bookingTopo = bookingTopo;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Boolean getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(Boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public User getBookingUser() {
		return bookingUser;
	}

	public void setBookingUser(User bookingUser) {
		this.bookingUser = bookingUser;
	}

	public Topo getBookingTopo() {
		return bookingTopo;
	}

	public void setBookingTopo(Topo bookingTopo) {
		this.bookingTopo = bookingTopo;
	}
	
	

}
