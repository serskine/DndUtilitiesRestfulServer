package com.soupthatisthick.dnd.utilities.server.service.topic;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.body.RawBody;
import com.soupthatisthick.dnd.utilities.server.api.common.PagedApiResponse;
import com.soupthatisthick.dnd.utilities.server.api.common.PagingStats;
import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.lookup.NoteEntity;
import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.topic.SubscriptionEntity;
import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.topic.TopicEntity;
import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.SubscriptionRepository;
import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.TopicRepository;
import com.soupthatisthick.dnd.utilities.server.service.common.base.ErrorCode;
import com.soupthatisthick.dnd.utilities.server.service.common.base.ServiceException;
import com.soupthatisthick.dnd.utilities.server.service.topic.model.*;
import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;
import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@Transactional(readOnly = true)
public class TopicService {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	private static transient final Logger LOG = LoggerFactory.getLogger(TopicService.class);

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	private Map<String, Set<String>> subscribers = new HashMap<>();

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	/**
	 * Will register a new topic
	 * @param request will indicate the name of the new topic and provide the owner information
	 * @return the topic entity
	 */
	public TopicEntity register(@NotNull RegisterTopicRequest request) {
		TopicEntity topicEntity = new TopicEntity();
		topicEntity.setName(request.getName());
		topicEntity.setClientUid(request.getClientUid());
		return topicRepository.save(topicEntity);
	}

	/**
	 * This will unregisted a topic. Only the client who created it can do this.
	 * @param request will identify the topic we wish to unregisted and provide the client
	 *                uid.
	 * @throws ServiceException if the topic does not exist.
	 */
	public void unregister(@NotNull UnregisterTopicRequest request) throws ServiceException {
		TopicEntity entity = topicRepository.findByUidAndClientUid(
				request.getClientUid(),
				request.getTopicUid()
		);
		if (entity==null) {
			throw new ServiceException(ErrorCode.UNKNOWN_ERROR, "Topic not found.");
		}
		topicRepository.delete(entity.getId());
	}

	/**
	 * This will allow a client to subscribe to a topic and receive notifications
	 * @param request will contain the topic information we wish to subscribe to.
	 * @return the topic information
	 * @throws ServiceException if the topic does not exist
	 */
	public Topic subscribe(@NotNull SubscribeTopicRequest request) throws ServiceException {
		TopicEntity topicEntity = topicRepository.findByUid(request.getTopicUid());
		if (topicEntity==null) {
			throw new ServiceException(ErrorCode.UNKNOWN_ERROR, "Topic not found.");
		}
		return new Topic(topicEntity);
	}

	/**
	 * This will be used to unsubscribe from the given topic
	 * @param request will contain the information about the request.
	 * @throws ServiceException if the subscription does not exist.
	 */
	public void unSubscribe(@NotNull UnSubscribeTopicRequest request) throws ServiceException {
		SubscriptionEntity subscriptionEntity = subscriptionRepository.findByUid(request.getUid());
		if (subscriptionEntity==null) {
			throw new ServiceException(ErrorCode.UNKNOWN_ERROR, "Subscription is not found.");
		}
		subscriptionRepository.delete(subscriptionEntity.getId());
	}

	/**
	 * Returns a list of all the topics the client owns. Only the owner will know
	 * his uid.
	 * @param request will contain the client uid requesting the information
	 * @return the topics for the client
	 */
	public Page<TopicEntity> listClientTopics(@NotNull ListClientTopicsRequest request) {
		return topicRepository.findByClientUid(request.getClientUid(), request.asPageable());
	}

	/**
	 * @param request will indicate what topics we want to list
	 * @return a list of all the topics with the specified name
	 */
	public Page<TopicEntity> listTopics(@NotNull ListTopicsRequest request) {
		return topicRepository.findByName(request.getName(), request.asPageable());
	}

	/**
	 * This will publish the topic to everybody else
	 * @param request contains the data we wish to send to everybody else.
	 */
	public void publish(@NotNull PublishTopicRequest request) {
		List<SubscriptionEntity> subscribers = subscriptionRepository.findByTopicUid(request.getTopicUid());
		for(SubscriptionEntity subscriptionEntity: subscribers) {
			sendTopicToEntity(request, subscriptionEntity);
		}
	}


	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	/**
	 * This will forward the topic information to the other subscrubers
	 * @param request
	 * @param subscriptionEntity
	 */
	private void sendTopicToEntity(
			@NotNull PublishTopicRequest request,
			@NotNull SubscriptionEntity subscriptionEntity
	) {
		final RawBody body = Unirest.post(subscriptionEntity.getUrl())
				.header("topicUid", request.getTopicUid())
				.body(request.getData());
	}

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class


