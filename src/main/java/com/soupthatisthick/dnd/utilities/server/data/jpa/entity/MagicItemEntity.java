package com.soupthatisthick.dnd.utilities.server.data.jpa.entity;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;
import com.soupthatisthick.dnd.utilities.server.service.common.model.MagicItemCategory;
import com.soupthatisthick.dnd.utilities.server.service.common.model.MagicItemRarity;

import javax.persistence.Column;

public class MagicItemEntity extends DisplayableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Column(name="category", nullable=false)
    private MagicItemCategory category;

    @Column(name="category_details", nullable=false)
    private String categoryDetails;

    @Column(name="rarity", nullable=false)
    private MagicItemRarity rarity;

    @Column(name="attunement", nullable=false)
    private String attunement;

    @Column(name="location", nullable=false)
    private String location;

    @Column(name="description", nullable=false)
    private String description;


    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

    public MagicItemCategory getCategory() {
        return category;
    }

    public void setCategory(MagicItemCategory category) {
        this.category = category;
    }


    public String getCategoryDetails() {
        return categoryDetails;
    }

    public void setCategoryDetails(String categoryDetails) {
        this.categoryDetails = categoryDetails;
    }

    public MagicItemRarity getRarity() {
        return rarity;
    }

    public void setRarity(MagicItemRarity rarity) {
        this.rarity = rarity;
    }

    public String getAttunement() {
        return attunement;
    }

    public void setAttunement(String attunement) {
        this.attunement = attunement;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
} // End of class
