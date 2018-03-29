package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.BaseHibernateEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cr")
@SequenceGenerator(name = "sg", sequenceName = "cr_sg")
public class CrEntity extends BaseHibernateEntity {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Column(name = "cr", nullable = false)
	private Float cr;

	@Column(name = "xp", nullable = false)
	private Integer xp;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	private CrEntity() {}
	public CrEntity(float cr, int xp) {
		this.cr = cr;
		this.xp = xp;
	}

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

	public Float getCr() {
		return cr;
	}

	public void setCr(Float cr) {
		this.cr = cr;
	}

	public Integer getXp() {
		return xp;
	}

	public void setXp(Integer xp) {
		this.xp = xp;
	}

} // end of class
