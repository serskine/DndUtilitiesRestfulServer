package com.soupthatisthick.dnd.utilities.server.encounter.model;

import com.soupthatisthick.dnd.utilities.server.common.model.BaseModel;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class MeasurementUsingXpRequest extends BaseModel {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@NotNull
	private List<Integer> allyLevels = new ArrayList<>();

	@NotNull
	private List<Integer> enemyXps = new ArrayList<>();

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

	public List<Integer> getAllyLevels() {
		return allyLevels;
	}

	public void setAllyLevels(List<Integer> allyLevels) {
		this.allyLevels = allyLevels;
	}

	public List<Integer> getEnemyXps() {
		return enemyXps;
	}

	public void setEnemyXps(List<Integer> enemyXps) {
		this.enemyXps = enemyXps;
	}

} // end of class
