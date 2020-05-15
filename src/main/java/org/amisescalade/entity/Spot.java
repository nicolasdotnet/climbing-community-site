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
 * Spot is the registration entity of a Spot. A spot is a place where you can
 * climb.
 *
 */
@Entity
public class Spot implements Serializable {

    @Id
    @GeneratedValue
    private Long spotId;
    @Column(nullable = false)
    private Date spotDate;
    @Column(length = 150, nullable = false)
    private String spotName;
    @Column(length = 3)
    private String spotRate;
    @Column (length = 380)
    private String spotDescription;
    @Column (length = 170)
    private String spotAccessPath;
    @Column(length = 100, nullable = false)
    private String location;
    @Column(length = 100, nullable = false)
    private String country;
    private boolean official;

    @OneToMany(mappedBy = "spot", fetch = FetchType.LAZY)
    private Collection<Comment> Comment;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User spotAuthor;

    @OneToMany(mappedBy = "spot", fetch = FetchType.LAZY)
    private Collection<Sector> sector;

    private String sectorCount;

    private String componentCount;

    public Spot() {
    }

    public Long getSpotId() {
        return spotId;
    }

    public void setSpotId(Long spotId) {
        this.spotId = spotId;
    }

    public Date getSpotDate() {
        return spotDate;
    }

    public void setSpotDate(Date spotDate) {
        this.spotDate = spotDate;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getSpotRate() {
        return spotRate;
    }

    public void setSpotRate(String spotRate) {
        this.spotRate = spotRate;
    }

    public String getSpotDescription() {
        return spotDescription;
    }

    public void setSpotDescription(String spotDescription) {
        this.spotDescription = spotDescription;
    }

    public String getSpotAccessPath() {
        return spotAccessPath;
    }

    public void setSpotAccessPath(String spotAccessPath) {
        this.spotAccessPath = spotAccessPath;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public Collection<Comment> getComment() {
        return Comment;
    }

    public void setComment(Collection<Comment> Comment) {
        this.Comment = Comment;
    }

    public User getSpotAuthor() {
        return spotAuthor;
    }

    public void setSpotAuthor(User spotAuthor) {
        this.spotAuthor = spotAuthor;
    }

    public Collection<Sector> getSector() {
        return sector;
    }

    public void setSector(Collection<Sector> sector) {
        this.sector = sector;
    }

    public String getSectorCount() {
        return sectorCount;
    }

    public void setSectorCount(String sectorCount) {
        this.sectorCount = sectorCount;
    }

    public String getComponentCount() {
        return componentCount;
    }

    public void setComponentCount(String componentCount) {
        this.componentCount = componentCount;
    }
    
    
}
