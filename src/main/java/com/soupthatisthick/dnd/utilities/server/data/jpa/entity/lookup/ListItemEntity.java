package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.lookup;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.BaseAuditHibernateEntity;

import javax.persistence.Column;

public class ListItemEntity extends BaseAuditHibernateEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Column(name="list_id", nullable=false)
    private ListEntity listEntity;

    @Column(name="metadata")
    private String metadata;

    @Column(name="table_name", nullable=false)
    private String table;

    @Column(name="primary_key", nullable=false)
    private String primaryKey;

    @Column(name="key_id", nullable=false)
    private Long keyId;

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
