package com.soupthatisthick.dnd.utilities.server.note;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
