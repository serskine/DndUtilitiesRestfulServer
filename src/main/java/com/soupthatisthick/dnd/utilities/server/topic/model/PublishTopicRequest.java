package com.soupthatisthick.dnd.utilities.server.topic.model;

import com.soupthatisthick.dnd.utilities.server.common.model.messages.BaseRequest;

public class PublishTopicRequest extends BaseRequest {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	private String topicUid;
	private String clientUid;
	private byte[] data;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

	public String getTopicUid() {
		return topicUid;
	}

	public void setTopicUid(String topicUid) {
		this.topicUid = topicUid;
	}

	public String getClientUid() {
		return clientUid;
	}

	public void setClientUid(String clientUid) {
		this.clientUid = clientUid;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

} // end of class
