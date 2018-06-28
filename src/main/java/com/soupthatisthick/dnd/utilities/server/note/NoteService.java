package com.soupthatisthick.dnd.utilities.server.note;

import com.soupthatisthick.dnd.utilities.server.client.model.lookup.Note;
import com.soupthatisthick.dnd.utilities.server.common.model.messages.SearchTermRequest;
import com.soupthatisthick.dnd.utilities.server.note.model.AddNoteRequest;
import com.soupthatisthick.dnd.utilities.server.note.model.DeleteNoteRequest;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@Transactional(readOnly = true)
public class NoteService {

//	// Constants ---------------------------------------------------------------------------------------------- Constants
//
//	private static transient final Logger LOG = LoggerFactory.getLogger(NoteService.class);
//
//	// Instance Variables ---------------------------------------------------------------------------- Instance Variables
//
//	@Autowired
//	private NoteRepository noteRepository;
//
//	// Constructors ---------------------------------------------------------------------------------------- Constructors
//
//	// Public Methods ------------------------------------------------------------------------------------ Public Methods
//
//	@ApiOperation(value = "Adds a new note to the repository")
//	@RequestMapping(value="/add", method = RequestMethod.POST)
//	public Note add(@NotNull AddNoteRequest request) {
//		Note note = new Note();
//		return noteRepository.save(note);
//	}
//
//	@ApiOperation(value = "Deletes a note from the repository")
//	@RequestMapping(value="/clear-units", method = RequestMethod.POST)
//	public void delete(@NotNull DeleteNoteRequest request) {
//		noteRepository.delete(request.getId());
//	}
//
//	@ApiOperation(value = "Searches for text using a database query")
//	@RequestMapping(value="/search", method = RequestMethod.POST)
//	public Page<NoteEntity> search(@NotNull SearchTermRequest request) {
//		return noteRepository.search(request.getSearchTerms(), request.asPageable());
//	}

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
