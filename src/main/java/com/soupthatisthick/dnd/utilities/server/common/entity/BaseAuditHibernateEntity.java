package com.soupthatisthick.dnd.utilities.server.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseAuditHibernateEntity extends BaseHibernateEntity {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Access(AccessType.PROPERTY)
    @Column(name = "last_updated", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", locale = "en_CA", timezone = "AST")
    private LocalDateTime lastUpdated;

    @Column(name = "created", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", locale = "en_CA", timezone = "AST")
    private LocalDateTime created;

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    @PrePersist
    public void onPrePersistAudit() {
        super.onPrePersistAudit();
        created = LocalDateTime.now();
        onPreUpdateAudit();
    }

    @PreUpdate
    public void onPreUpdateAudit() {
        lastUpdated = LocalDateTime.now();
    }

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //


    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }


} // End of class
