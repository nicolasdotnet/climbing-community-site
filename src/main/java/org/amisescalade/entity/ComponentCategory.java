package org.amisescalade.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author nicolasdotnet
 * 
 * ComponentCategory a is the category entity to which Compoment can belong :
 * Block, Route ...
 *
 */


@Entity
public class ComponentCategory implements Serializable {
	
	@Id @GeneratedValue
	private Long idComponentCategory;
	@Column(nullable=false)
	private Date dateComponentCategory;
	@Column(nullable=false)
	private String labelComponentCategory;
	
	@OneToMany(mappedBy="componentCategory",fetch=FetchType.LAZY)
	private Collection<Component> component;
	
	public ComponentCategory() {
		super();
	}

	public ComponentCategory(Date dateComponentCategory, String labelComponentCategory,
			Collection<Component> component) {
		super();
		this.dateComponentCategory = dateComponentCategory;
		this.labelComponentCategory = labelComponentCategory;
		this.component = component;
	}

	public ComponentCategory(Date dateComponentCategory, String labelComponentCategory) {
		super();
		this.dateComponentCategory = dateComponentCategory;
		this.labelComponentCategory = labelComponentCategory;
	}

	public Long getIdComponentCategory() {
		return idComponentCategory;
	}

	public void setIdComponentCategory(Long idComponentCategory) {
		this.idComponentCategory = idComponentCategory;
	}

	public Date getDateComponentCategory() {
		return dateComponentCategory;
	}

	public void setDateComponentCategory(Date dateComponentCategory) {
		this.dateComponentCategory = dateComponentCategory;
	}

	public String getLabelComponentCategory() {
		return labelComponentCategory;
	}

	public void setLabelComponentCategory(String labelComponentCategory) {
		this.labelComponentCategory = labelComponentCategory;
	}

	public Collection<Component> getComponent() {
		return component;
	}

	public void setComponent(Collection<Component> component) {
		this.component = component;
	}

	@Override
	public String toString() {
		return "ComponentCategory [labelComponentCategory=" + labelComponentCategory + "]";
	}
	
	
	
	

}
