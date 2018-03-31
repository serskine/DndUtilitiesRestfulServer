package com.soupthatisthick.dnd.utilities.server.functional;

import com.soupthatisthick.dnd.utilities.server.api.common.SearchTermRequest;
import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.lookup.NoteEntity;
import com.soupthatisthick.dnd.utilities.server.service.note.NoteService;
import com.soupthatisthick.dnd.utilities.server.service.note.model.AddNoteRequest;
import com.soupthatisthick.dnd.utilities.server.service.note.model.DeleteNoteRequest;
import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;
import com.soupthatisthick.dnd.utilities.server.util.podam.PodamUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteServiceTest {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	private static transient final Logger LOG = LoggerFactory.getLogger(NoteServiceTest.class);

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Autowired
	private NoteService noteService;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	@Test
	public void testCrud() {
		AddNoteRequest addNoteRequest = PodamUtil.manufacture(AddNoteRequest.class);
		SearchTermRequest searchTermRequest = new SearchTermRequest(addNoteRequest.getTitle());

		NoteEntity entity = noteService.add(addNoteRequest);
		LOG.debug("{}", JsonUtil.toJson(entity, true));

	}

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
