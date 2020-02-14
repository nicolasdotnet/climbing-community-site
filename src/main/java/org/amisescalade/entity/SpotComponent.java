package org.amisescalade.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("CSP")

public class SpotComponent extends Component{
	
	@ManyToOne
	//@JoinColumn(nullable=false)
	private Spot spot;

	public SpotComponent() {
		super();
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	@Override
	public String toString() {
		return "SpotComponent [spot=" + spot + ", toString()=" + super.toString() + "]";
	}
	
	

}
