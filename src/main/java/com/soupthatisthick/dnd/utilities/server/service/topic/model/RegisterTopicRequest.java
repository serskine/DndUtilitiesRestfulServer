package com.soupthatisthick.dnd.utilities.server.service.topic.model;

import com.soupthatisthick.dnd.utilities.server.service.common.base.BaseModel;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterTopicRequest extends BaseModel {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@NotEmpty
	private String name;

	@NotEmpty
	private String clientUid;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClientUid() {
		return clientUid;
	}

	public void setClientUid(String clientUid) {
		this.clientUid = clientUid;
	}

} // end of class
