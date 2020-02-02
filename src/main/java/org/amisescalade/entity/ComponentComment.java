package org.amisescalade.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("C")

public class ComponentComment extends Comment {
	
	@ManyToOne
//	@JoinColumn(nullable=false)
	private Component component;

	public ComponentComment() {
		super();
	}

	public ComponentComment(Date commentDate, String commentBody, Boolean commentStatus, User commentAuthor,
			Component component) {
		super(commentDate, commentBody, commentStatus, commentAuthor);
		this.component = component;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}
	
	
	
	

}
