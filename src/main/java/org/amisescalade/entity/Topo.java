package org.amisescalade.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author nicolasdotnet
 * 
 * 
 * Topo (small manual recording the information of climbing sites for a region) 
 * is the entity that registers a manual that a user has. 
 * A topo can be lent to another user from community.
 *
 */
@Entity
public class Topo implements Serializable{
	
	@Id @GeneratedValue
	private Long topoId;
	@Column(nullable=false)
	private Date topoDate;
	@Column(length = 200, nullable=false)
	private String topoArea;
	@Column(length = 200, nullable=false)
	private String topoTitle;
	private String topoDescription;
	@Column(nullable=false)
	private Boolean topoStatus;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private User topoOwner;
	
	@OneToOne
	private Booking booking;
	
	public Topo() {
		super();
	}

	public Long getTopoId() {
		return topoId;
	}

	public void setTopoId(Long topoId) {
		this.topoId = topoId;
	}

	public Date getTopoDate() {
		return topoDate;
	}

	public void setTopoDate(Date topoDate) {
		this.topoDate = topoDate;
	}

	public String getTopoArea() {
		return topoArea;
	}

	public void setTopoArea(String topoArea) {
		this.topoArea = topoArea;
	}

	public String getTopoTitle() {
		return topoTitle;
	}

	public void setTopoTitle(String topoTitle) {
		this.topoTitle = topoTitle;
	}

	public String getTopoDescription() {
		return topoDescription;
	}

	public void setTopoDescription(String topoDescription) {
		this.topoDescription = topoDescription;
	}

	public User getTopotopoOwner() {
		return topoOwner;
	}

	public void setTopotopoOwner(User topoOwner) {
		this.topoOwner = topoOwner;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

    public Boolean getTopoStatus() {
        return topoStatus;
    }

    public void setTopoStatus(Boolean topoStatus) {
        this.topoStatus = topoStatus;
    }
	@Override
	public String toString() {
		return "Topo [topoTitle=" + topoTitle + ", topoOwner=" + topoOwner + "]";
	}
	
	
	
	

}
