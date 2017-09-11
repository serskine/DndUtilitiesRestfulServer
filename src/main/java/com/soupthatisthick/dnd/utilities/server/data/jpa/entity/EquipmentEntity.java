package com.soupthatisthick.dnd.utilities.server.data.jpa.entity;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Currency;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Measure;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Weight;

import javax.persistence.Column;

public class EquipmentEntity extends DisplayableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Column(name = "cost", nullable = false)
    private Measure<Currency> cost;

    @Column(name = "weight", nullable = false)
    private Measure<Weight> weight;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "type", nullable = false)
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
} // End of class
