package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.lookup;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class NoteEntity extends DisplayableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Column(name="description")
    private String description;

    // Constructors ----------------------------------------------------------- Constructors //

    private NoteEntity() {}
    public NoteEntity(@NotEmpty String title, @NotNull String description) {
        setTitle(title);
        setDescription(description);
    }

    // Public Methods ------------------------------------------------------- Public Methods //

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
