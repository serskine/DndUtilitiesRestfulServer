package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.builder;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.BaseHibernateEntity;
import uk.co.jemos.podam.common.PodamExclude;

import javax.annotation.Nullable;
import javax.persistence.*;

@Entity
@Table(name = "enemy")
@SequenceGenerator(name = "sg", sequenceName = "enemy_sg")
public class EnemyEntity extends BaseHibernateEntity {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Column(name = "cr", nullable = false)
	private float cr;

	@JoinColumn(name = "encounter")
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
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
