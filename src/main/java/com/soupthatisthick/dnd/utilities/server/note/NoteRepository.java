package com.soupthatisthick.dnd.utilities.server.note;

//import com.soupthatisthick.dnd.utilities.server.lookup.NoteEntity;
//import org.hibernate.validator.constraints.NotEmpty;
//import org.springframework.data.domain.Page;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.Nullable;
//import java.awt.print.Pageable;
//@Repository
//public interface NoteRepository extends SearchableRepository<NoteEntity> {
//
//	// Constants ---------------------------------------------------------------------------------------------- Constants
//
//	// Instance Variables ---------------------------------------------------------------------------- Instance Variables
//
//	// Constructors ---------------------------------------------------------------------------------------- Constructors
//
//	// Public Methods ------------------------------------------------------------------------------------ Public Methods
//
//	@Query("select e from NoteEntity e where e.title like '%:searchTerm%' order by e.title")
//	Page<NoteEntity> search(@NotEmpty @Param("searchTerm") String searchTerm, @Nullable Pageable pageable);
//
//	// Protected Methods ------------------------------------------------------------------------------ Protected Methods
//
//	// Private Methods ---------------------------------------------------------------------------------- Private Methods
//
//	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters
//
//} // end of class
