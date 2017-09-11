package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base;

import org.hibernate.validator.constraints.NotEmpty;

public class DisplayableEntity extends BaseAuditHibernateEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @NotEmpty
    private String title;

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

} // End of class
