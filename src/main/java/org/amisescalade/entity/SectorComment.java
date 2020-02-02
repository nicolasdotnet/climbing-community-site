package org.amisescalade.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("CSE")

public class SectorComment extends Comment{
	
	@ManyToOne
//	@JoinColumn(nullable=false)
	private Sector sector;

	public SectorComment() {
		super();
	}

	public SectorComment(Date commentDate, String commentBody, Boolean commentStatus, User commentAuthor,
			Sector sector) {
		super(commentDate, commentBody, commentStatus, commentAuthor);
		this.sector = sector;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	@Override
	public String toString() {
		return "SectorComment [sector=" + sector + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
