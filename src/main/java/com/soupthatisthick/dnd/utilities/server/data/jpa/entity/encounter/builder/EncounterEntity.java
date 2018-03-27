package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.builder;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.BaseHibernateEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class EncounterEntity extends BaseHibernateEntity {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "allyEntity", fetch = FetchType.LAZY)
	@Cascade(value = CascadeType.DELETE)
	@PodamExclude
	private List<AllyEntity> allies = new ArrayList<>();

	@OneToMany(mappedBy = "enemyEntity", fetch = FetchType.LAZY)
	@Cascade(value = CascadeType.DELETE)
	@PodamExclude
	private List<EnemyEntity> enemies = new ArrayList<>();

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	private EncounterEntity() {}
	public EncounterEntity(@NotEmpty String name) {
		this.name = name;
	}

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AllyEntity> getAllies() {
		return allies;
	}

	public void setAllies(List<AllyEntity> allies) {
		this.allies = allies;
	}

	public List<EnemyEntity> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<EnemyEntity> enemies) {
		this.enemies = enemies;
	}

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
