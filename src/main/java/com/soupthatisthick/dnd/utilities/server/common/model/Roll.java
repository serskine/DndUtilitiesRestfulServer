package com.soupthatisthick.dnd.utilities.server.common.model;

import com.soupthatisthick.dnd.utilities.server.util.podam.RandomUtil;

public class Roll {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    private Integer qty;
    private Integer size;
    private Integer multiplier;
    private Integer modifier;
    private String qualifier;

    private Roll next;

    // Constructors ----------------------------------------------------------- Constructors //

    public Roll() {
        this(1,20,1,0);
    }

    public Roll(int qty, int size, int multiplier, int modifier) {
        this.qty = qty;
        this.size = size;
        this.multiplier = multiplier;
        this.modifier = modifier;
    }

    public Roll(String text) {
        String[] tokens = text.split("\\+dDxD");
        qty = Integer.parseInt(tokens[0]);
        size = Integer.parseInt(tokens[1]);
        if (text.matches(".*[xX].*")) {
            multiplier = Integer.parseInt(tokens[2]);
            if (tokens.length>3) {
                modifier = Integer.parseInt(tokens[3]);
            } else {
                modifier = 0;
            }
        } else {
            multiplier = 1;
            modifier = Integer.parseInt(tokens[3]);
        }
    }

    // Public Methods ------------------------------------------------------- Public Methods //

    public int nextValue() {
        int sum = 0;
        for(int i=0; i<qty; i++) {
            sum += RandomUtil.randInt(1, size);
        }
        sum *= multiplier;
        sum += modifier;
        return sum;
    }

    public int min() {
        return getQty() * getMultiplier() + getModifier();
    }

    public int max() {
        return getQty() * getSize() * getMultiplier() + getModifier();
    }

    public int avg() {
        return (max() + min()) / 2;
    }

    @Override
    public String toString() {
        String base = String.format("%dd%d", getQty(), getSize());
        String multiplier = (getMultiplier()==0) ? "" : String.format(" x %d", getMultiplier());
        String modifier = (getModifier()==0) ? "" : (getModifier() > 0) ? " + " + getModifier() : "" + getModifier();

        return base + multiplier + modifier;
    }

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public Roll getNext() {
        return next;
    }

    public void setNext(Roll next) {
        this.next = next;
    }


    public Integer getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Integer multiplier) {
        this.multiplier = multiplier;
    }
} // End of class
