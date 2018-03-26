package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.lookup;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Currency;
import com.soupthatisthick.dnd.utilities.server.service.common.model.Measure;

import javax.persistence.Column;

public class RollEntryEntity extends DisplayableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Column(name="parent_table", nullable=false)
    private RollTableEntity parentTable;

    @Column(name="min_roll", nullable=false)
    private Integer minRoll;

    @Column(name="max_roll", nullable=false)
    private Integer maxRoll;

    @Column(name="result", nullable=false)
    private String result;

    @Column(name="unit", nullable=false)
    private String unit;

    @Column(name="reroll_table")
    private RollTableEntity rerollTable;

    @Column(name="qty_die_num", nullable=false)
    private Integer dieQty;

    @Column(name="qty_die_size", nullable=false)
    private Integer dieSize;

    @Column(name="qty_roll_multiplier", nullable=false)
    private Integer rollMultiplier;

    @Column(name="qty_average", nullable=false)
    private Integer rollAverage;

    @Column(name="value")
    private Measure<Currency> value;

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

    public RollTableEntity getParentTable() {
        return parentTable;
    }

    public void setParentTable(RollTableEntity parentTable) {
        this.parentTable = parentTable;
    }

    public Integer getMinRoll() {
        return minRoll;
    }

    public void setMinRoll(Integer minRoll) {
        this.minRoll = minRoll;
    }

    public Integer getMaxRoll() {
        return maxRoll;
    }

    public void setMaxRoll(Integer maxRoll) {
        this.maxRoll = maxRoll;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public RollTableEntity getRerollTable() {
        return rerollTable;
    }

    public void setRerollTable(RollTableEntity rerollTable) {
        this.rerollTable = rerollTable;
    }

    public Integer getDieQty() {
        return dieQty;
    }

    public void setDieQty(Integer dieQty) {
        this.dieQty = dieQty;
    }

    public Integer getDieSize() {
        return dieSize;
    }

    public void setDieSize(Integer dieSize) {
        this.dieSize = dieSize;
    }

    public Integer getRollMultiplier() {
        return rollMultiplier;
    }

    public void setRollMultiplier(Integer rollMultiplier) {
        this.rollMultiplier = rollMultiplier;
    }

    public Integer getRollAverage() {
        return rollAverage;
    }

    public void setRollAverage(Integer rollAverage) {
        this.rollAverage = rollAverage;
    }

    public Measure<Currency> getValue() {
        return value;
    }

    public void setValue(Measure<Currency> value) {
        this.value = value;
    }

} // End of class
