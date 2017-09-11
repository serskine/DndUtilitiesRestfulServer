package com.soupthatisthick.dnd.utilities.server.data.jpa.entity;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Measure;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Weight;

import javax.persistence.Column;

public class ContainerEntity extends DisplayableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Column(name = "capacity", nullable = false)
    private Measure<Weight> capacity;

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //


    public Measure<Weight> getCapacity() {
        return capacity;
    }

    public void setCapacity(Measure<Weight> capacity) {
        this.capacity = capacity;
    }

} // End of class
