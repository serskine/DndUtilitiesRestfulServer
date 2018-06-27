package com.soupthatisthick.dnd.utilities.server.common.repo;

import com.soupthatisthick.dnd.utilities.server.common.entity.BaseHibernateEntity;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<EntityType extends BaseHibernateEntity> extends JpaRepository<EntityType, Long> {
	EntityType findByUid(@NotEmpty String uid);
}
