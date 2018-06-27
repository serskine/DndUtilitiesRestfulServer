package com.soupthatisthick.dnd.utilities.server.client.model.lookup;

import com.soupthatisthick.dnd.utilities.server.client.model.DaoModel;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Owner on 5/5/2017.
 * Copyright of Stuart Marr Erskine, all rights reserved.
 */
@Entity
@Table(name = "CONTAINERS")
public class Container extends DaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sg")
    @Column(name = "id", updatable = false, nullable = false)
    @PodamExclude
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="capacity")
    private String capacity;

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

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
