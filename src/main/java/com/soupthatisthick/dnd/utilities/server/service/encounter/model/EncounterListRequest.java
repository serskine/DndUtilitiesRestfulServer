package com.soupthatisthick.dnd.utilities.server.service.encounter.model;

import com.soupthatisthick.dnd.utilities.server.api.common.BasePageRequest;

public class EncounterListRequest extends BasePageRequest {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	private Long encounterId;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

	public Long getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}
} // end of class
