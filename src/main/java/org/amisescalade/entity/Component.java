package org.amisescalade.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author nicolasdotnet
 *
 * Component is the registration entity of a component of a sector or a spot. It
 * is typed (route, block ..) with the entity ComponentCategory.
 *
 */
@Entity
public class Component implements Serializable {

    @Id
    @GeneratedValue
    private Long componentId;
    @Column(nullable = false)
    private Date componentDate;
    @Column (length = 5)
    private String componentCode;
    @Column(length = 150, nullable = false)
    private String componentName;
    @Column(length = 3,nullable = false)
    private String componentRate;
    @Column (length = 3)
    private String componentHeight;
    private Boolean spits;
    @Column (length = 380)
    private String componentDescription;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User componentAuthor;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ComponentCategory componentCategory;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Sector sector;

    @OneToMany(mappedBy = "component", fetch = FetchType.LAZY)
    private Collection<Pitch> pitch;

    public Component() {
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

    public String getComponentHeight() {
        return componentHeight;
    }

    public void setComponentHeight(String componentHeight) {
        this.componentHeight = componentHeight;
    }

    public Boolean getSpits() {
        return spits;
    }

    public void setSpits(Boolean spits) {
        this.spits = spits;
    }

    public String getComponentDescription() {
        return componentDescription;
    }

    public void setComponentDescription(String componentDescription) {
        this.componentDescription = componentDescription;
    }

    public User getComponentAuthor() {
        return componentAuthor;
    }

    public void setComponentAuthor(User componentAuthor) {
        this.componentAuthor = componentAuthor;
    }

    public ComponentCategory getComponentCategory() {
        return componentCategory;
    }

    public void setComponentCategory(ComponentCategory componentCategory) {
        this.componentCategory = componentCategory;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Collection<Pitch> getPitch() {
        return pitch;
    }

    public void setPitch(Collection<Pitch> pitch) {
        this.pitch = pitch;
    }

}
