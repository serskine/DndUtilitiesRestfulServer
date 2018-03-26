package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.lookup;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;

import javax.persistence.Column;
import java.util.Set;

public class BackgroundEntity extends DisplayableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Column(name="skills")
    private Set<String> skills;

    @Column(name="tools")
    private Set<String> tools;

    @Column(name="languages")
    private Set<String> language;

    @Column(name="equipment")
    private String equipment;

    @Column(name="description", nullable=false)
    private String description;

    @Column(name="features")
    private String features;

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Set<String> getTools() {
        return tools;
    }

    public void setTools(Set<String> tools) {
        this.tools = tools;
    }

    public Set<String> getLanguage() {
        return language;
    }

    public void setLanguage(Set<String> language) {
        this.language = language;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }
} // End of class
