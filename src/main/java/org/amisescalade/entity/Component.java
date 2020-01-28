package org.amisescalade.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author nicolasdotnet
 * 
 * Component is the registration entity of a component of a sector or a spot. 
 * It is typed (route, block ..) with the entity ComponentCategory.
 *
 */


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="TYPE_COMPONENT",discriminatorType = DiscriminatorType.STRING,length = 3 )

public abstract class Component implements Serializable{
	
	@Id @GeneratedValue
	private Long componentId;
	@Column(nullable=false)
	private Date componentDate;
	@Column(nullable=false)
	private String componentCode;
	@Column(length = 40, nullable=false)
	private String componentName;
	@Column(nullable=false)
	private String componentRate;
	private String componentDescription;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private ComponentCategory componentCategory;
	@OneToMany(mappedBy = "component",fetch = FetchType.LAZY)
	private Collection<ComponentComment>componentComment;
	
	public Component() {
		super();
	}
	public Component(Date componentDate, String componentCode, String componentName, String componentRate,
			String componentDescription, ComponentCategory componentCategory,
			Collection<ComponentComment> componentComment) {
		super();
		this.componentDate = componentDate;
		this.componentCode = componentCode;
		this.componentName = componentName;
		this.componentRate = componentRate;
		this.componentDescription = componentDescription;
		this.componentCategory = componentCategory;
		this.componentComment = componentComment;
	}
	public Long getComponentId() {
		return componentId;
	}
	public void setComponentId(Long componentId) {
		this.componentId = componentId;
	}
	public Date getComponentDate() {
		return componentDate;
	}
	public void setComponentDate(Date componentDate) {
		this.componentDate = componentDate;
	}
	public String getComponentCode() {
		return componentCode;
	}
	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getComponentRate() {
		return componentRate;
	}
	public void setComponentRate(String componentRate) {
		this.componentRate = componentRate;
	}
	public String getComponentDescription() {
		return componentDescription;
	}
	public void setComponentDescription(String componentDescription) {
		this.componentDescription = componentDescription;
	}
	public ComponentCategory getComponentCategory() {
		return componentCategory;
	}
	public void setComponentCategory(ComponentCategory componentCategory) {
		this.componentCategory = componentCategory;
	}
	public Collection<ComponentComment> getComponentComment() {
		return componentComment;
	}
	public void setComponentComment(Collection<ComponentComment> componentComment) {
		this.componentComment = componentComment;
	}
	@Override
	public String toString() {
		return "Component [componentName=" + componentName + ", componentCategory=" + componentCategory + "]";
	}
	
	
	
	

}
