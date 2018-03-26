package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.lookup;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;

import javax.persistence.Column;

public class LanguageEntity extends DisplayableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Column(name="speakers")
    private String speakers;

    @Column(name="script")
    private String script;

    @Column(name="type")
    private String type;

    @Column(name="description")
    private String description;

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
