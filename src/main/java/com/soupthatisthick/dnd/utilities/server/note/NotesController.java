package com.soupthatisthick.dnd.utilities.server.note;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Api(description = "Encounter Measurement Endpoint")
@RestController
@RequestMapping(value = "/encounter-measure", produces = MediaType.APPLICATION_JSON_VALUE)
public class NotesController {
//
//	// Constants ---------------------------------------------------------------------------------------------- Constants
//
//	// Instance Variables ---------------------------------------------------------------------------- Instance Variables
//
//	@Autowired
//	private NoteService noteService;
//
//	// Constructors ---------------------------------------------------------------------------------------- Constructors
//
//	// Public Methods ------------------------------------------------------------------------------------ Public Methods
//
//
//	public ApiResponse<NoteEntity> add(AddNoteRequest request) {
//		return new ApiResponse<>(noteService.add(request));
//	}
//
//	public ApiResponse<NoteEntity> delete(DeleteNoteRequest request) {
//		noteService.delete(request);
//		return new ApiResponse<>();
//	}
//
//	public PagedApiResponse<NoteEntity> search(SearchTermRequest request) {
//		Page<NoteEntity> page = noteService.search(request);
//		PagingStats pagingStats = new PagingStats(page);
//		return new PagedApiResponse<>(page.getContent(), pagingStats);
//	}
//
//	// Protected Methods ------------------------------------------------------------------------------ Protected Methods
//
//	// Private Methods ---------------------------------------------------------------------------------- Private Methods
//
//	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
