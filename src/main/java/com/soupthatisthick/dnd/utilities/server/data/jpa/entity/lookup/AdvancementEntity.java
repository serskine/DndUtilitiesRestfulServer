package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.lookup;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;

import javax.persistence.Column;

public class AdvancementEntity extends DisplayableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    @Column(name = "xp", nullable = false)
    private Integer xp;

    @Column(name = "level", nullable = false)
    private Integer level;

    @Column(name = "proficiency", nullable = false)
    private Integer proficiency;

    @Column(name = "tier", nullable = false)
    private Integer tier;

    // Instance Variables ----------------------------------------------- Instance Variables //

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //


    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getProficiency() {
        return proficiency;
    }

    public void setProficiency(Integer proficiency) {
        this.proficiency = proficiency;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }
} // End of class
