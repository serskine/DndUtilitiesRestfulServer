package com.soupthatisthick.dnd.utilities.server.service.encounterbuilder.model;

import com.soupthatisthick.dnd.utilities.server.service.common.base.BaseModel;

import javax.validation.constraints.NotNull;

public class EncounterRequest extends BaseModel {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@NotNull
	private Long id;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
