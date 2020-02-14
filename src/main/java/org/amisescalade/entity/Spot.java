package org.amisescalade.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author nicolasdotnet
 * 
 * Spot is the registration entity of a Spot.
 * A spot is a place where you can climb.
 *
 */

@Entity
public class Spot implements Serializable{
	
	// register a spot : manque Author et prévoir  table département & pays ?
	
	@Id @GeneratedValue
	private Long spotId;
	@Column(nullable=false)
	private Date spotDate;
	@Column(nullable=false)
	private String spotName;
	@Column(length = 20)
	private String spotRate;
	private String spotDescription;
	private String spotAccessPath;
	@Column(length = 100, nullable=false)
	private String departement;
	@Column(length = 100, nullable=false)
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
	
	

	public Spot(Date spotDate, String spotName, String spotRate, String spotDescription, String spotAccessPath,
			String departement, String country) {
		super();
		this.spotDate = spotDate;
		this.spotName = spotName;
		this.spotRate = spotRate;
		this.spotDescription = spotDescription;
		this.spotAccessPath = spotAccessPath;
		this.departement = departement;
		this.country = country;
	}



	public Spot(Date spotdate, String spotname, String spotRate, String spotDescription, String spotAccessPath,
			String departement, String country,
			Collection<SpotComment> spotComment, Collection<Sector> sector, Collection<SpotComponent> component) {
		super();
		this.spotDate = spotdate;
		this.spotName = spotname;
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

	public Date getSpotDate() {
		return spotDate;
	}

	public void setSpotDate(Date spotDate) {
		this.spotDate = spotDate;
	}

	public String getSpotName() {
		return spotName;
	}

	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}

	public String getSpotRate() {
		return spotRate;
	}
	
	public void setSpotRate(String spotRate) {
		this.spotRate = spotRate;
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
		return "Spot [spotname=" + spotName + "]";
	}
	
	
	
	
	
}
	
