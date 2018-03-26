package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.BaseHibernateEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.jemos.podam.common.PodamExclude;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EnemyEntity extends BaseHibernateEntity {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Column(name = "cr", nullable = false)
	private float cr;

	@JoinColumn(name = "encounter")
	@ManyToOne(fetch = FetchType.LAZY)
	@PodamExclude
	@Nullable
	private EncounterEntity encounterEntity;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	public float getCr() {
		return cr;
	}

	public void setCr(float cr) {
		this.cr = cr;
	}

	@Nullable
	public EncounterEntity getEncounterEntity() {
		return encounterEntity;
	}

	public void setEncounterEntity(@Nullable EncounterEntity encounterEntity) {
		this.encounterEntity = encounterEntity;
	}

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
