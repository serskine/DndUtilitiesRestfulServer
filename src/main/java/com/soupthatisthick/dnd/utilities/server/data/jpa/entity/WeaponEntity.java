package com.soupthatisthick.dnd.utilities.server.data.jpa.entity;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;
import com.soupthatisthick.dnd.utilities.server.service.common.model.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Set;

public class WeaponEntity extends DisplayableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Column(name="cost", nullable=false)
    private Measure<Currency> cost;

    @Column(name="damage", nullable=false)
    private Roll damage;

    @Column(name="weight", nullable=false)
    private Measure<Weight> weight;

    @Column(name="properties", nullable=false)
    private Set<String> properties;

    @Enumerated(EnumType.STRING)
    private WeaponType type;

    @Column(name="description", nullable=false)
    private String description;

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

    public Roll getDamage() {
        return damage;
    }

    public void setDamage(Roll damage) {
        this.damage = damage;
    }

    public Measure<Weight> getWeight() {
        return weight;
    }

    public void setWeight(Measure<Weight> weight) {
        this.weight = weight;
    }

    public Set<String> getProperties() {
        return properties;
    }

    public void setProperties(Set<String> properties) {
        this.properties = properties;
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


} // End of class
