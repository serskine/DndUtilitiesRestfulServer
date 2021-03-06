package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base;

import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;
import com.soupthatisthick.dnd.utilities.server.util.podam.PodamUtil;
import org.apache.commons.lang.builder.HashCodeBuilder;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseHibernateEntity implements Serializable {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sg")
    @Column(name = "id", updatable = false, nullable = false)
    @PodamExclude
    private Long id;

    @Column(name = "uid", updatable = false, nullable = false)
    @PodamExclude
    private String uid;


    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + JsonUtil.toJson(this, true);
    }

    @Override
    public int hashCode() {
        if (getId() != null) {
            return getId().hashCode();
        } else {
            return HashCodeBuilder.reflectionHashCode(this, false);
        }
    }

    @PrePersist
    public void onPrePersistAudit() {
        uid = PodamUtil.manufacture(String.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) {
            return true;
        }
        boolean isAssignable = false;
        if(this.getClass().isAssignableFrom(o.getClass())) {
            isAssignable = true;
        }
        if (o.getClass().isAssignableFrom(this.getClass())) {
            isAssignable = true;
        }
        if (!isAssignable) {
            return false;
        }

        BaseHibernateEntity that = (BaseHibernateEntity) o;

        return !(getId() != null ? !getId().equals(that.getId()) : that.getId() != null);
    }

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

} // End of class
