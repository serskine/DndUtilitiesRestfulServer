package com.soupthatisthick.dnd.utilities.server.service.note;

import com.soupthatisthick.dnd.utilities.server.api.common.SearchTermRequest;
import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.lookup.NoteEntity;
import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.NoteRepository;
import com.soupthatisthick.dnd.utilities.server.service.note.model.AddNoteRequest;
import com.soupthatisthick.dnd.utilities.server.service.note.model.DeleteNoteRequest;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.NotNull;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@Transactional(readOnly = true)
public class NoteService {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	private static transient final Logger LOG = LoggerFactory.getLogger(NoteService.class);

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

//	@Autowired
//	private NoteRepository noteRepository;
//
//	// Constructors ---------------------------------------------------------------------------------------- Constructors
//
//	// Public Methods ------------------------------------------------------------------------------------ Public Methods
//
//	@ApiOperation(value = "Adds a new note to the repository")
//	@RequestMapping(value="/add", method = RequestMethod.POST)
//	public NoteEntity add(@NotNull AddNoteRequest request) {
//		NoteEntity noteEntity = new NoteEntity(request.getTitle(), request.getDescription());
//		return noteRepository.save(noteEntity);
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
//
//	// Protected Methods ------------------------------------------------------------------------------ Protected Methods
//
//	// Private Methods ---------------------------------------------------------------------------------- Private Methods
//
//	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
