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

    @Id
    @GeneratedValue
    private Long componentCategoryId;
    @Column(nullable = false)
    private Date componentCategoryDate;
    @Column(nullable = false)
    private String componentCategoryLabel;

    @OneToMany(mappedBy = "componentCategory", fetch = FetchType.LAZY)
    private Collection<Component> component;
    

    public ComponentCategory() {
    }

    public Long getComponentCategoryId() {
        return componentCategoryId;
    }

    public void setComponentCategoryId(Long componentCategoryId) {
        this.componentCategoryId = componentCategoryId;
    }

    public Date getComponentCategoryDate() {
        return componentCategoryDate;
    }

    public void setComponentCategoryDate(Date componentCategoryDate) {
        this.componentCategoryDate = componentCategoryDate;
    }

    public String getComponentCategoryLabel() {
        return componentCategoryLabel;
    }

    public void setComponentCategoryLabel(String componentCategoryLabel) {
        this.componentCategoryLabel = componentCategoryLabel;
    }

    public Collection<Component> getComponent() {
        return component;
    }

    public void setComponent(Collection<Component> component) {
        this.component = component;
    }
    
    

}
