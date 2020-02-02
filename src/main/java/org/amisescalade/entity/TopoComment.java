package org.amisescalade.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("CTO")

public class TopoComment extends Comment {
	
	@ManyToOne
//	@JoinColumn(nullable=false)
	private Topo topo;

	public TopoComment() {
		super();
	}

	public TopoComment(Date commentDate, String commentBody, Boolean commentStatus, User commentAuthor, Topo topo) {
		super(commentDate, commentBody, commentStatus, commentAuthor);
		this.topo = topo;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	@Override
	public String toString() {
		return "TopoComment [topo=" + topo + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
