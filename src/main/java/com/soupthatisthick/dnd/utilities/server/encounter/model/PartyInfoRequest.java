package com.soupthatisthick.dnd.utilities.server.encounter.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PartyInfoRequest {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@NotEmpty
	private List<Integer> allies = new ArrayList<>();

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	public PartyInfoRequest() {}

	public PartyInfoRequest(@NotNull Integer... allies) {
		this.allies = Arrays.asList(allies);
	}

	public PartyInfoRequest(@NotNull Collection<Integer> allies) {
		this.allies.clear();
		this.allies.addAll(allies);
	}

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

	public List<Integer> getAllies() {
		return allies;
	}

	public void setAllies(List<Integer> allies) {
		this.allies = allies;
	}

} // end of class
