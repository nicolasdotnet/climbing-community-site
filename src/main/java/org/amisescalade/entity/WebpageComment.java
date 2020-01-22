package org.amisescalade.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("WPC")

public class WebpageComment extends Comment {
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Webpage webpage;

	public WebpageComment() {
		super();
	}

	public WebpageComment(Date commentDate, String commentBody, Boolean commentStatus, User commentAuthor,
			Webpage webpage) {
		super(commentDate, commentBody, commentStatus, commentAuthor);
		this.webpage = webpage;
	}

	public Webpage getWebpage() {
		return webpage;
	}

	public void setWebpage(Webpage webpage) {
		this.webpage = webpage;
	}
	
	

}
