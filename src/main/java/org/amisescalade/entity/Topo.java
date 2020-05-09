package org.amisescalade.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author nicolasdotnet
 *
 *
 * Topo (small manual recording the information of climbing sites for a region)
 * is the entity that registers a manual that a user has. A topo can be lent to
 * another user from community.
 *
 */
@Entity
public class Topo implements Serializable {

    @Id
    @GeneratedValue
    private Long topoId;
    @Column(nullable = false)
    private Date topoDate;
    @Column(length = 200, nullable = false)
    private String topoArea;
    @Column(length = 200, nullable = false)
    private String topoTitle;
    private String topoDescription;
    @Column(nullable = false)
    private Boolean topoStatus;
    @Column(nullable = false)
    private Date releaseDate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User topoOwner;

    @OneToOne(mappedBy = "bookingTopo", fetch = FetchType.LAZY)
    private Booking booking;

    public Topo() {
    }

    public Long getTopoId() {
        return topoId;
    }

    public void setTopoId(Long topoId) {
        this.topoId = topoId;
    }

    public Date getTopoDate() {
        return topoDate;
    }

    public void setTopoDate(Date topoDate) {
        this.topoDate = topoDate;
    }

    public String getTopoArea() {
        return topoArea;
    }

    public void setTopoArea(String topoArea) {
        this.topoArea = topoArea;
    }

    public String getTopoTitle() {
        return topoTitle;
    }

    public void setTopoTitle(String topoTitle) {
        this.topoTitle = topoTitle;
    }

    public String getTopoDescription() {
        return topoDescription;
    }

    public void setTopoDescription(String topoDescription) {
        this.topoDescription = topoDescription;
    }

    public Boolean getTopoStatus() {
        return topoStatus;
    }

    public void setTopoStatus(Boolean topoStatus) {
        this.topoStatus = topoStatus;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public User getTopoOwner() {
        return topoOwner;
    }

    public void setTopoOwner(User topoOwner) {
        this.topoOwner = topoOwner;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    
    
}
