package com.soupthatisthick.dnd.utilities.server.data.jpa.entity;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Currency;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Length;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Measure;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Weight;

import javax.persistence.Column;

public class MountEntity extends DisplayableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Column(name="cost", nullable=false)
    private Measure<Currency> cost;

    @Column(name="speed", nullable=false)
    private Measure<Length> speed;

    @Column(name="carry", nullable=false)
    private Measure<Weight> weight;

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

    public Measure<Length> getSpeed() {
        return speed;
    }

    public void setSpeed(Measure<Length> speed) {
        this.speed = speed;
    }

    public Measure<Weight> getWeight() {
        return weight;
    }

    public void setWeight(Measure<Weight> weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


} // End of class