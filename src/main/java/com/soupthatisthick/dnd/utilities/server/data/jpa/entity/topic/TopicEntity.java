package com.soupthatisthick.dnd.utilities.server.data.jpa.entity.topic;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.BaseAuditHibernateEntity;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "topic")
@SequenceGenerator(name = "sg", sequenceName = "topic_sg")
public class TopicEntity extends BaseAuditHibernateEntity {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Column(name = "name", updatable = false, nullable = false)
	private String name;

	@Column(name = "clientUid", updatable = false, nullable = false)
	private String clientUid;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	public TopicEntity() {}

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
