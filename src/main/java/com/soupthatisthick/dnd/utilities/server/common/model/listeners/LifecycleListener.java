package com.soupthatisthick.dnd.utilities.server.common.model.listeners;

import com.soupthatisthick.dnd.utilities.server.util.announcer.Announcer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.EventListener;

/**
 * A default listener for all entity classes.
 */
public class LifecycleListener {

	private static transient final Logger LOG = LoggerFactory.getLogger(LifecycleListener.class);

	public interface Listener extends EventListener {
		void onEvent(EventType eventType, Object object);
	}

	private transient final Announcer<Listener> listeners = Announcer.to(LifecycleListener.Listener.class);

	/**
	 * Defines which event happened on the entity
	 */
	public enum EventType {
		PRE_PERSIST,
		PRE_UPDATE,
		PRE_REMOVE,
		POST_PERSIST,
		POST_UPDATE,
		POST_REMOVE,
		POST_LOAD
	};

	@PrePersist
	void prePersist(Object object) {
		onEvent(EventType.PRE_PERSIST, object);
	}

	@PostPersist
	void postPersist(Object object) {
		onEvent(EventType.POST_PERSIST, object);
	}

	@PreUpdate
	void preUpdate(Object object) {
		onEvent(EventType.PRE_UPDATE, object);
	}

	@PostUpdate
	void postUpdate(Object object) {
		onEvent(EventType.POST_UPDATE, object);
	}

	@PreRemove
	void preRemove(Object object) {
		onEvent(EventType.PRE_REMOVE, object);
	}

	@PostRemove
	void postRemove(Object object) {
		onEvent(EventType.POST_REMOVE, object);
	}

	@PostLoad
	void postLoad(Object object) {
		onEvent(EventType.POST_LOAD, object);
	}

	/**
	 * This method is called to announce the events to all of the listeners
	 * @param eventType indicates which lifecycle event actually occurred
	 * @param object is the object it occurred on
	 */
	private void onEvent(EventType eventType, Object object) {
		LOG.info("" + eventType + " (" + object.getClass().getSimpleName() + ")");
		listeners.announce().onEvent(eventType, object);
	}

} // end of class
