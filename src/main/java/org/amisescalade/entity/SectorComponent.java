package org.amisescalade.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("CSE")

public class SectorComponent extends Component {
	
	@ManyToOne
	//@JoinColumn(nullable=false)
	private Sector sector;

	public SectorComponent() {
		super();
	}

	public SectorComponent(Date componentDate, String componentCode, String componentName, String componentRate,
			String componentDescription, ComponentCategory componentCategory,
			Collection<ComponentComment> componentComment, Sector sector) {
		super(componentDate, componentCode, componentName, componentRate, componentDescription,
				componentCategory, componentComment);
		this.sector = sector;
	}
	
	

	public SectorComponent(Date componentDate, String componentCode, String componentName, String componentRate,
			String componentDescription, ComponentCategory componentCategory, Sector sector) {
		super(componentDate, componentCode, componentName, componentRate, componentDescription, componentCategory);
		this.sector = sector;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	

}
