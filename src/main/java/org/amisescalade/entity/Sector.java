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
 * Sector is the registration entity of a sector. 
 * A sector is part of a spot that groups together a set of places to climb.
 *
 */

@Entity
public class Sector implements Serializable{
	
	@Id @GeneratedValue
	private Long sectorId;
	@JoinColumn(nullable=false)
	private Date sectorDate;
	@Column(length = 20)
	@JoinColumn(nullable=false)
	private String sectorname;
	@Column(length = 20)
	@JoinColumn(nullable=false)
	private String sectorRate;
	@Column(length = 500)
	private String sectorDescription;
	@Column(length = 500)
	private String sectorAccessPath;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Spot spot;
	
	@OneToMany(mappedBy = "sector",fetch = FetchType.LAZY)
	private Collection<SectorComponent> component;
	
	@OneToMany(mappedBy = "sector",fetch = FetchType.LAZY)
	private Collection<SectorComment>sectorComment;
	
	public Sector() {
		super();
	}

	public Sector(Date sectorDate, String sectorname, String sectorRate, String sectorDescription,
			String sectorAccessPath, Collection<SectorComponent> component,
			Collection<SectorComment> sectorComment) {
		super();
		this.sectorDate = sectorDate;
		this.sectorname = sectorname;
		this.sectorRate = sectorRate;
		this.sectorDescription = sectorDescription;
		this.sectorAccessPath = sectorAccessPath;
		this.component = component;
		this.sectorComment = sectorComment;
	}

	public Long getSectorId() {
		return sectorId;
	}

	public void setSectorId(Long sectorId) {
		this.sectorId = sectorId;
	}

	public Date getSectorDate() {
		return sectorDate;
	}

	public void setSectorDate(Date sectorDate) {
		this.sectorDate = sectorDate;
	}

	public String getSectorname() {
		return sectorname;
	}

	public void setSectorname(String sectorname) {
		this.sectorname = sectorname;
	}

	public String getSectorRate() {
		return sectorRate;
	}

	public void setSectorRate(String sectorType) {
		this.sectorRate = sectorType;
	}

	public String getSectorDescription() {
		return sectorDescription;
	}

	public void setSectorDescription(String sectorDescription) {
		this.sectorDescription = sectorDescription;
	}

	public String getSectorAccessPath() {
		return sectorAccessPath;
	}

	public void setSectorAccessPath(String sectorAccessPath) {
		this.sectorAccessPath = sectorAccessPath;
	}

	public Collection<SectorComponent> getComponent() {
		return component;
	}

	public void setComponent(Collection<SectorComponent> component) {
		this.component = component;
	}

	public Collection<SectorComment> getSectorComment() {
		return sectorComment;
	}

	public void setSectorComment(Collection<SectorComment> sectorComment) {
		this.sectorComment = sectorComment;
	}

	@Override
	public String toString() {
		return "Sector [sectorname=" + sectorname + "]";
	}
	
	
	
	
	
}