package com.soupthatisthick.dnd.utilities.server.data.jpa.repository;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.BaseHibernateEntity;
import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.topic.SubscriptionEntity;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends BaseRepository<SubscriptionEntity> {
	List<SubscriptionEntity> findByTopicUid(@NotEmpty String topicUid);
}
