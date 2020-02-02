package org.amisescalade.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("CSP")

public class SpotComment extends Comment {
	
	@ManyToOne
//	@JoinColumn(nullable=false)
	private Spot spot;

	public SpotComment() {
		super();
	}

	public SpotComment(Date commentDate, String commentBody, Boolean commentStatus, User commentAuthor, Spot spot) {
		super(commentDate, commentBody, commentStatus, commentAuthor);
		this.spot = spot;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}
	
	

}
