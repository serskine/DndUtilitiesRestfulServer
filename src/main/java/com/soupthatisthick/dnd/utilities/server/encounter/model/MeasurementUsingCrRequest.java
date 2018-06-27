package com.soupthatisthick.dnd.utilities.server.encounter.model;

import com.soupthatisthick.dnd.utilities.server.common.model.messages.BaseRequest;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class MeasurementUsingCrRequest extends BaseRequest {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@NotEmpty
	private List<Integer> allyLevels = new ArrayList<>();

	@NotNull
	private List<Float> enemyCrs = new ArrayList<>();

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

	public List<Float> getEnemyCrs() {
		return enemyCrs;
	}

	public void setEnemyCrs(List<Float> enemyCrs) {
		this.enemyCrs = enemyCrs;
	}
} // end of class
