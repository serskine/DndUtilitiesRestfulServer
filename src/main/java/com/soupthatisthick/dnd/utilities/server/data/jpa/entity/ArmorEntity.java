package com.soupthatisthick.dnd.utilities.server.data.jpa.entity;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;
import com.soupthatisthick.dnd.utilities.server.service.common.model.ArmorType;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Currency;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Measure;

import javax.persistence.Column;

public class ArmorEntity extends DisplayableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    @Column(name="cost", nullable=false)
    private Measure<Currency> cost;

    @Column(name="ac", nullable=false)
    private Integer ac;

    @Column(name="strength", nullable=false)
    private Integer reqStrength;

    @Column(name="stealth", nullable=false)
    private String stealth;

    @Column(name="weight", nullable=false)
    private Integer weight;

    @Column(name="acType", nullable=false)
    private ArmorType type;

    @Column(name="description", nullable=false)
    private String description;

    // Instance Variables ----------------------------------------------- Instance Variables //

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

    public Measure<Currency> getCost() {
        return cost;
    }

    public void setCost(Measure<Currency> cost) {
        this.cost = cost;
    }

    public Integer getAc() {
        return ac;
    }

    public void setAc(Integer ac) {
        this.ac = ac;
    }

    public Integer getReqStrength() {
        return reqStrength;
    }

    public void setReqStrength(Integer reqStrength) {
        this.reqStrength = reqStrength;
    }

    public String getStealth() {
        return stealth;
    }

    public void setStealth(String stealth) {
        this.stealth = stealth;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }


    public ArmorType getType() {
        return type;
    }

    public void setType(ArmorType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
} // End of class
