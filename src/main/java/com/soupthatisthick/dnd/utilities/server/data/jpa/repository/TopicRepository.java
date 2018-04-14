package com.soupthatisthick.dnd.utilities.server.data.jpa.repository;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.topic.TopicEntity;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends BaseRepository<TopicEntity> {

	TopicEntity findByUidAndClientUid(
			@NotEmpty String topicUid,
			@NotEmpty String clientUid
	);

	Page<TopicEntity> findByClientUid(@NotEmpty String clientUid, Pageable pageable);
	Page<TopicEntity> findByName(@NotEmpty String name, Pageable pageable);
	Page<TopicEntity> findByClientUidAndName(
			@NotEmpty String clientUid,
			@NotEmpty String name,
			Pageable pageable
	);
}
