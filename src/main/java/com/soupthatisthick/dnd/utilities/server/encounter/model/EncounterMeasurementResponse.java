package com.soupthatisthick.dnd.utilities.server.encounter.model;

import com.soupthatisthick.dnd.utilities.server.common.model.BaseModel;

import javax.validation.constraints.NotNull;

public class EncounterMeasurementResponse extends BaseModel {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@NotNull
	private ThreatValue threatValue;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	private EncounterMeasurementResponse() {}
	public EncounterMeasurementResponse(@NotNull ThreatValue threatValue) {
		this.threatValue = threatValue;
	}

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

	public ThreatValue getThreatValue() {
		return threatValue;
	}

	public void setThreatValue(ThreatValue threatValue) {
		this.threatValue = threatValue;
	}

} // end of class
