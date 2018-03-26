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

public class AllyEntity extends BaseHibernateEntity {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Column(name = "level", nullable = false)
	private int level;

	@JoinColumn(name = "encounter")
	@ManyToOne(fetch = FetchType.LAZY)
	@PodamExclude
	@Nullable
	private EncounterEntity encounterEntity;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public EncounterEntity getEncounterEntity() {
		return encounterEntity;
	}

	public void setEncounterEntity(EncounterEntity encounterEntity) {
		this.encounterEntity = encounterEntity;
	}

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
