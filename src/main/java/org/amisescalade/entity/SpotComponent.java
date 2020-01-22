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
	private Spot spot;

	public SpotComponent() {
		super();
	}

	public SpotComponent(Date componentDate, String componentCode, String componentName, String componentRate,
			String componentDescription, ComponentCategory componentCategory,
			Collection<ComponentComment> componentComment, Spot spot) {
		super(componentDate, componentCode, componentName, componentRate, componentDescription,
				componentCategory, componentComment);
		this.spot = spot;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}
	
	

}
