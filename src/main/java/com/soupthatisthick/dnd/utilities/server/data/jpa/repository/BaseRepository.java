package com.soupthatisthick.dnd.utilities.server.data.jpa.repository;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.BaseHibernateEntity;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BaseRepository<EntityType extends BaseHibernateEntity> extends JpaRepository<EntityType, Long> {
	EntityType findByUid(@NotEmpty String uid);
}
