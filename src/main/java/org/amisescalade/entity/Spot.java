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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author nicolasdotnet
 * 
 * Spot is the registration entity of a Spot.
 * A spot is a place where you can climb.
 *
 */

@Entity
public class Spot implements Serializable{
	
	@Id @GeneratedValue
	private Long spotId;
	@JoinColumn(nullable=false)
	private Date spotdate;
	@JoinColumn(nullable=false)
	private String spotname;
	@Column(length = 20)
	private String spotRate;
	@Column(length = 200)
	private String spotDescription;
	@Column(length = 500)
	private String spotAccessPath;
	@JoinColumn(nullable=false)
	private String departement;
	@JoinColumn(nullable=false)
	private String country;
	
	@OneToMany(mappedBy = "spot",fetch = FetchType.LAZY)
	private Collection<SpotComment> spotComment;
	
	@OneToMany(mappedBy = "spot",fetch = FetchType.LAZY)
	private Collection<Sector> sector;
	
	@OneToMany(mappedBy = "spot",fetch = FetchType.LAZY)
	private Collection<SpotComponent> component;
	
	public Spot() {
		super();
	}

	public Spot(Date spotdate, String spotname, String spotRate, String spotDescription, String spotAccessPath,
			String departement, String country,
			Collection<SpotComment> spotComment, Collection<Sector> sector, Collection<SpotComponent> component) {
		super();
		this.spotdate = spotdate;
		this.spotname = spotname;
		this.spotRate = spotRate;
		this.spotDescription = spotDescription;
		this.spotAccessPath = spotAccessPath;
		this.departement = departement;
		this.country = country;
		this.spotComment = spotComment;
		this.sector = sector;
		this.component = component;
	}

	public Long getSpotId() {
		return spotId;
	}

	public void setSpotId(Long spotId) {
		this.spotId = spotId;
	}

	public Date getSpotdate() {
		return spotdate;
	}

	public void setSpotdate(Date spotdate) {
		this.spotdate = spotdate;
	}

	public String getSpotname() {
		return spotname;
	}

	public void setSpotname(String spotname) {
		this.spotname = spotname;
	}

	public String getSpotRate() {
		return spotRate;
	}

	public void setSpotType(String spotType) {
		this.spotRate = spotType;
	}

	public String getSpotDescription() {
		return spotDescription;
	}

	public void setSpotDescription(String spotDescription) {
		this.spotDescription = spotDescription;
	}

	public String getSpotAccessPath() {
		return spotAccessPath;
	}

	public void setSpotAccessPath(String spotAccessPath) {
		this.spotAccessPath = spotAccessPath;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Collection<SpotComment> getSpotComment() {
		return spotComment;
	}

	public void setSpotComment(Collection<SpotComment> spotComment) {
		this.spotComment = spotComment;
	}

	public Collection<Sector> getSector() {
		return sector;
	}

	public void setSector(Collection<Sector> sector) {
		this.sector = sector;
	}

	public Collection<SpotComponent> getComponent() {
		return component;
	}

	public void setComponent(Collection<SpotComponent> component) {
		this.component = component;
	}

	@Override
	public String toString() {
		return "Spot [spotname=" + spotname + "]";
	}
	
	
	
	
	
}
	
