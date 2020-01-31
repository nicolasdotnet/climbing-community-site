package org.amisescalade.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Column(length = 50)
	private String topoTag;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private User topoOwner;
	
	@OneToOne
	private Booking booking;
	
	@OneToMany(mappedBy = "topo",fetch = FetchType.LAZY)
	private Collection<TopoComment>topoComments;
	
	public Topo() {
		super();
	}

	public Topo(Date topoDate, String topoArea, String topoTitle, String topoDescription,
			User topoOwner, Booking booking, Collection<TopoComment> topoComments) {
		super();
		this.topoDate = topoDate;
		this.topoArea = topoArea;
		this.topoTitle = topoTitle;
		this.topoDescription = topoDescription;
		this.topoOwner = topoOwner;
		this.booking = booking;
		this.topoComments = topoComments;
	}

	public Topo(Date topoDate, String topoArea, String topoTitle, String topoDescription, User topoOwner) {
		super();
		this.topoDate = topoDate;
		this.topoArea = topoArea;
		this.topoTitle = topoTitle;
		this.topoDescription = topoDescription;
		this.topoOwner = topoOwner;
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

	public Collection<TopoComment> getTopoComment() {
		return topoComments;
	}

	public void setTopoComment(Collection<TopoComment> topoComments) {
		this.topoComments = topoComments;
	}

	@Override
	public String toString() {
		return "Topo [topoTitle=" + topoTitle + ", topoOwner=" + topoOwner + "]";
	}
	
	
	
	

}
