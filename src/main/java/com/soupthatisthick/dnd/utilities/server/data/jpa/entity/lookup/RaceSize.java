package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.lookup;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Length;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Measure;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Weight;

import javax.persistence.Column;

public class RaceSize extends DisplayableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Column(name="race", nullable=false)
    private String race;

    @Column(name="height_base", nullable=false)
    private Measure<Length> baseHeight;

    @Column(name="height_mod", nullable=false)
    private Measure<Length> heightModifier;

    @Column(name="weight_base", nullable=false)
    private Measure<Weight> baseWeight;

    @Column(name="weight_mod", nullable=false)
    private Measure<Weight> weightModifier;

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
