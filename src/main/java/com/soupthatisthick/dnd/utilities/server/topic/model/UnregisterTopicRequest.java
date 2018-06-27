package com.soupthatisthick.dnd.utilities.server.topic.model;

import com.soupthatisthick.dnd.utilities.server.common.model.BaseModel;

public class UnregisterTopicRequest extends BaseModel {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	private String clientUid;
	private String topicUid;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

	public String getClientUid() {
		return clientUid;
	}

	public void setClientUid(String clientUid) {
		this.clientUid = clientUid;
	}

	public String getTopicUid() {
		return topicUid;
	}

	public void setTopicUid(String topicUid) {
		this.topicUid = topicUid;
	}

} // end of class
