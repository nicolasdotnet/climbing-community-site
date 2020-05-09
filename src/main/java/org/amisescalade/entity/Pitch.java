/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.amisescalade.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author nicolasdotnet
 */

@Entity
public class Pitch {

    @Id
    @GeneratedValue
    private Long pitchId;
    @Column(nullable = false)
    private Date pitchDate;
    private String pitchCode;
    private String pitchRate;
    private String pitchHeight;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User pitchAuthor;

    @ManyToOne
    private Component component;

    public Pitch() {
    }

    public Long getPitchId() {
        return pitchId;
    }

    public void setPitchId(Long pitchId) {
        this.pitchId = pitchId;
    }

    public Date getPitchDate() {
        return pitchDate;
    }

    public void setPitchDate(Date pitchDate) {
        this.pitchDate = pitchDate;
    }

    public String getPitchCode() {
        return pitchCode;
    }

    public void setPitchCode(String pitchCode) {
        this.pitchCode = pitchCode;
    }

    public String getPitchRate() {
        return pitchRate;
    }

    public void setPitchRate(String pitchRate) {
        this.pitchRate = pitchRate;
    }

    public String getPitchHeight() {
        return pitchHeight;
    }

    public void setPitchHeight(String pitchHeight) {
        this.pitchHeight = pitchHeight;
    }

    public User getPitchAuthor() {
        return pitchAuthor;
    }

    public void setPitchAuthor(User pitchAuthor) {
        this.pitchAuthor = pitchAuthor;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    

}
