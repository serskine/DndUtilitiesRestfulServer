package com.soupthatisthick.dnd.utilities.server.encounter.entity;

import com.soupthatisthick.dnd.utilities.server.common.entity.BaseHibernateEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "xp_threshold")
@SequenceGenerator(name = "sg", sequenceName = "xp_threshold_sg")
public class XpThresholdEntity extends BaseHibernateEntity {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Column(name = "level", nullable = false)
	private Integer level;

	@Column(name = "easy", nullable = false)
	private Integer easy;

	@Column(name = "moderate", nullable = false)
	private Integer moderate;

	@Column(name = "hard", nullable = false)
	private Integer hard;

	@Column(name = "deadly", nullable = false)
	private Integer deadly;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	public XpThresholdEntity() {}
	public XpThresholdEntity(int level, int easy, int moderate, int hard, int deadly) {
		setLevel(level);
		setEasy(easy);
		setModerate(moderate);
		setHard(hard);
		setDeadly(deadly);
	}
	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getEasy() {
		return easy;
	}

	public void setEasy(Integer easy) {
		this.easy = easy;
	}

	public Integer getModerate() {
		return moderate;
	}

	public void setModerate(Integer moderate) {
		this.moderate = moderate;
	}

	public Integer getHard() {
		return hard;
	}

	public void setHard(Integer hard) {
		this.hard = hard;
	}

	public Integer getDeadly() {
		return deadly;
	}

	public void setDeadly(Integer deadly) {
		this.deadly = deadly;
	}


} // end of class
