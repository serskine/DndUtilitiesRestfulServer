package com.soupthatisthick.dnd.utilities.server.data.jpa.entity;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Currency;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Measure;

import javax.persistence.Column;

public class LifestyleEntity extends DisplayableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Column(name="daily_cost", nullable=false)
    private Measure<Currency> dailyCost;

    @Column(name="description")
    private String description;

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

    public Measure<Currency> getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(Measure<Currency> dailyCost) {
        this.dailyCost = dailyCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
} // End of class
