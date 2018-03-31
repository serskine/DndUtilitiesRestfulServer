package com.soupthatisthick.dnd.utilities.server.service.note.model;

import com.soupthatisthick.dnd.utilities.server.api.common.BaseRequest;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;

public class AddNoteRequest extends BaseRequest {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables
	@NotEmpty
	private String title;

	@NotNull
	private String description;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
