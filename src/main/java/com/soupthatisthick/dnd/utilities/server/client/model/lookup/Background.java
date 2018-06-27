package com.soupthatisthick.dnd.utilities.server.client.model.lookup;

import com.soupthatisthick.dnd.utilities.server.client.model.DaoModel;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Owner on 5/5/2017.
 * Copyright of Stuart Marr Erskine, all rights reserved.
 */
@Entity
@Table(name = "BACKGROUND")
public class Background extends DaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sg")
    @Column(name = "id", updatable = false, nullable = false)
    @PodamExclude
    private Long id;
    
    @Column(name="name")
    private String name;

    @Column(name="skills")
    private String skills;

    @Column(name="tools")
    private String tools;

    @Column(name="languages")
    private String languages;

    @Column(name="equipment")
    private String equipment;

    @Column(name="description")
    private String description;

    @Column(name="features")
    private String features;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
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
}
