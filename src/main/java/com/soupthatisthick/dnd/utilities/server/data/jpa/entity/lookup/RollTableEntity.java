package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.lookup;

import javax.persistence.Column;

public class RollTableEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Column(name="die_qty", nullable=false)
    private Integer dieQty;

    @Column(name="die_size", nullable=false)
    private Integer dieSize;

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

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

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
