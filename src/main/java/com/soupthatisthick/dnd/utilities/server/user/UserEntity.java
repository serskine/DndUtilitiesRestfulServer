package com.soupthatisthick.dnd.utilities.server.user;

import com.soupthatisthick.dnd.utilities.server.common.entity.BaseAuditHibernateEntity;
import com.soupthatisthick.dnd.utilities.server.common.entity.DisplayableEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@SequenceGenerator(name = "sg", sequenceName = "user_sg")
public class UserEntity extends BaseAuditHibernateEntity {

	// Constants ----------------------------------------------------------------- Constants //

	// Instance Variables ----------------------------------------------- Instance Variables //

	@Column(name="name", nullable=false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
} // End of class
