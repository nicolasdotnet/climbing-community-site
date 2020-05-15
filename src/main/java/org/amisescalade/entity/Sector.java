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
 * Sector is the registration entity of a sector. A sector is part of a spot
 * that groups together a set of places to climb.
 *
 */
@Entity
public class Sector implements Serializable {

    @Id
    @GeneratedValue
    private Long sectorId;
    @Column(nullable = false)
    private Date sectorDate;
    @Column(length = 150, nullable = false)
    private String sectorName;
    @Column(length = 3,nullable = false)
    private String sectorRate;
    @Column (length = 380)
    private String sectorDescription;
    @Column (length = 170)
    private String sectorAccessPath;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User sectorAuthor;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Spot spot;

    @OneToMany(mappedBy = "sector", fetch = FetchType.LAZY)
    private Collection<Component> component;

    public Sector() {
    }

    public Long getSectorId() {
        return sectorId;
    }

    public void setSectorId(Long sectorId) {
        this.sectorId = sectorId;
    }

    public Date getSectorDate() {
        return sectorDate;
    }

    public void setSectorDate(Date sectorDate) {
        this.sectorDate = sectorDate;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getSectorRate() {
        return sectorRate;
    }

    public void setSectorRate(String sectorRate) {
        this.sectorRate = sectorRate;
    }

    public String getSectorDescription() {
        return sectorDescription;
    }

    public void setSectorDescription(String sectorDescription) {
        this.sectorDescription = sectorDescription;
    }

    public String getSectorAccessPath() {
        return sectorAccessPath;
    }

    public void setSectorAccessPath(String sectorAccessPath) {
        this.sectorAccessPath = sectorAccessPath;
    }

    public User getSectorAuthor() {
        return sectorAuthor;
    }

    public void setSectorAuthor(User sectorAuthor) {
        this.sectorAuthor = sectorAuthor;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Collection<Component> getComponent() {
        return component;
    }

    public void setComponent(Collection<Component> component) {
        this.component = component;
    }
    
}
