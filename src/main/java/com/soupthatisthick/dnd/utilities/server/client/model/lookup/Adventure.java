package com.soupthatisthick.dnd.utilities.server.client.model.lookup;

import com.soupthatisthick.dnd.utilities.server.client.model.DaoModel;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ADVENTURE")
public class Adventure extends DaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sg")
    @Column(name = "id", updatable = false, nullable = false)
    @PodamExclude
    private Long id;

    @Column(name="code")
    private String code;

    @Column(name="levelBand")
    private String levelBand;

    @Column(name="runtimeHours")
    private String runtimeHours;

    @Column(name="title")
    private String title;

    @Column(name="notes")
    private String notes;

    @Column(name="seasonId")
    private Long seasonId;

    @Column(name="description")
    private String description;

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevelBand() {
        return levelBand;
    }

    public void setLevelBand(String levelBand) {
        this.levelBand = levelBand;
    }

    public String getRuntimeHours() {
        return runtimeHours;
    }

    public void setRuntimeHours(String runtimeHours) {
        this.runtimeHours = runtimeHours;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
