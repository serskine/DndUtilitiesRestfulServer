package com.soupthatisthick.dnd.utilities.server.topic;

import com.soupthatisthick.dnd.utilities.server.common.entity.BaseAuditHibernateEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "subscription")
@SequenceGenerator(name = "sg", sequenceName = "subscription_sg")

public class SubscriptionEntity extends BaseAuditHibernateEntity {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Column(name = "clientUrl", updatable = false, nullable = false)
	private String clientUrl;

	@Column(name = "topicUid", updatable = false, nullable = false)
	private String topicUid;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

	public String getUrl() {
		return clientUrl;
	}

	public void setUrl(String clientUrl) {
		this.clientUrl = clientUrl;
	}

	public String getTopicUid() {
		return topicUid;
	}

	public void setTopicUid(String topicUid) {
		this.topicUid = topicUid;
	}

}
