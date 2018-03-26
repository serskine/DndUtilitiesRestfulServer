package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.lookup;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;
import com.soupthatisthick.dnd.utilities.server.service.common.model.SpellSchool;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class SpellEntity extends DisplayableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "level", nullable = false)
    @Enumerated(EnumType.STRING)
    private SpellSchool school;

    @Column(name = "level", nullable = false)
    private String castingTime;

    @Column(name = "level", nullable = false)
    private String range;

    @Column(name = "level", nullable = false)
    private String components;

    @Column(name = "level", nullable = false)
    private String duration;

    @Column(name = "level", nullable = false)
    private String description;

    @Column(name = "level", nullable = false)
    private String classes;

    @Column(name = "level")
    private String materials;

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public SpellSchool getSchool() {
        return school;
    }

    public void setSchool(SpellSchool school) {
        this.school = school;
    }

    public String getCastingTime() {
        return castingTime;
    }

    public void setCastingTime(String castingTime) {
        this.castingTime = castingTime;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }
} // End of class
