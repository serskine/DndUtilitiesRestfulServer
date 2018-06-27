package com.soupthatisthick.dnd.utilities.server.topic.model;

import com.soupthatisthick.dnd.utilities.server.topic.TopicEntity;
import com.soupthatisthick.dnd.utilities.server.common.model.BaseModel;
import com.sun.istack.internal.NotNull;

public class Topic extends BaseModel {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	private String uid;
	private String name;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	private Topic() {}
	public Topic(@NotNull TopicEntity topicEntity) {
		this.name = topicEntity.getName();
		this.uid = topicEntity.getUid();
	}

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

} // end of class
