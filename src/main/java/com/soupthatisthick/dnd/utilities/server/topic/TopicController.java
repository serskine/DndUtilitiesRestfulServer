package com.soupthatisthick.dnd.utilities.server.topic;

import com.soupthatisthick.dnd.utilities.server.common.model.messages.ApiResponse;
import com.soupthatisthick.dnd.utilities.server.common.model.messages.PagedApiResponse;
import com.soupthatisthick.dnd.utilities.server.common.model.messages.PagingStats;
import com.soupthatisthick.dnd.utilities.server.common.model.ServiceException;
import com.soupthatisthick.dnd.utilities.server.topic.model.*;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@SuppressWarnings({"unchecked", "SpringJavaAutowiredFieldsWarningInspection"})
@Api(description = "Topic Management Endpoint")
@RestController
@RequestMapping(value = "/topic", produces = MediaType.APPLICATION_JSON_VALUE)
public class TopicController {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	private static transient final Logger LOG = LoggerFactory.getLogger(TopicController.class);

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Autowired
	private TopicService topicService;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	public ApiResponse<TopicEntity> register(@Valid RegisterTopicRequest request) throws ServiceException {
		return new ApiResponse(topicService.register(request));
	}

	public ApiResponse unregister(@Valid UnregisterTopicRequest request) throws ServiceException {
		topicService.unregister(request);
		return new ApiResponse(OK);
	}

	public PagedApiResponse<Topic> listClientTopics(@Valid ListClientTopicsRequest request) throws ServiceException {
		Page<TopicEntity> topicEntityPage = topicService.listClientTopics(request);
		PagingStats pagingStats = new PagingStats(topicEntityPage);
		List<Topic> topics = new ArrayList<>();
		for(TopicEntity topicEntity : topicEntityPage.getContent()) {
			topics.add(new Topic(topicEntity));
		}
		return new PagedApiResponse<>(topics, pagingStats);
	}

	public PagedApiResponse<Topic> listTopics(@Valid ListTopicsRequest request) throws ServiceException {
		Page<TopicEntity> topicEntityPage = topicService.listTopics(request);
		PagingStats pagingStats = new PagingStats(topicEntityPage);
		List<Topic> topics = new ArrayList<>();
		for(TopicEntity topicEntity : topicEntityPage.getContent()) {
			topics.add(new Topic(topicEntity));
		}
		return new PagedApiResponse<>(topics, pagingStats);
	}

	public ApiResponse<Topic> subscribe(@Valid SubscribeTopicRequest request) throws ServiceException {
		return new ApiResponse<>(topicService.subscribe(request));
	}

	public ApiResponse unSubscribe(@Valid UnSubscribeTopicRequest request) throws ServiceException {
		topicService.unSubscribe(request);
		return new ApiResponse(OK);
	}

	public ApiResponse publish(@Valid PublishTopicRequest request) {
		topicService.publish(request);
		return new ApiResponse(OK);
	}



	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
