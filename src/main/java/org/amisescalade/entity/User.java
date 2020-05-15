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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author nicolasdotnet
 *
 * User is the registration entity of a community user.
 *
 */
@Entity
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long userId;
    @JoinColumn(nullable = false)
    private Date userDate;

    @Column(length = 100, nullable = false)
    private String firstname;

    @Column(length = 100, nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean enabled;

    private boolean tokenExpired;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "topoOwner", fetch = FetchType.LAZY)
    private Collection<Topo> topos;

    @OneToMany(mappedBy = "bookingUser", fetch = FetchType.LAZY)
    private Collection<Booking> booking;

    @OneToMany(mappedBy = "commentAuthor", fetch = FetchType.LAZY)
    private Collection<Comment> comments;

    @OneToMany(mappedBy = "spotAuthor", fetch = FetchType.LAZY)
    private Collection<Spot> spots;

    @OneToMany(mappedBy = "sectorAuthor", fetch = FetchType.LAZY)
    private Collection<Sector> sectors;

    @OneToMany(mappedBy = "componentAuthor", fetch = FetchType.LAZY)
    private Collection<Component> components;

    @OneToMany(mappedBy = "pitchAuthor", fetch = FetchType.LAZY)
    private Collection<Pitch> pitchs;

    @Lob
    private byte[] profile;

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Collection<Topo> getTopos() {
        return topos;
    }

    public void setTopos(Collection<Topo> topos) {
        this.topos = topos;
    }

    public Collection<Booking> getBooking() {
        return booking;
    }

    public void setBooking(Collection<Booking> booking) {
        this.booking = booking;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Collection<Spot> getSpots() {
        return spots;
    }

    public void setSpots(Collection<Spot> spots) {
        this.spots = spots;
    }

    public Collection<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(Collection<Sector> sectors) {
        this.sectors = sectors;
    }

    public Collection<Component> getComponents() {
        return components;
    }

    public void setComponents(Collection<Component> components) {
        this.components = components;
    }

    public Collection<Pitch> getPitchs() {
        return pitchs;
    }

    public void setPitchs(Collection<Pitch> pitchs) {
        this.pitchs = pitchs;
    }

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }
    
    
}
