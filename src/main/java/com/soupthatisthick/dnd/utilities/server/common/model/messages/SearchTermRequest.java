package com.soupthatisthick.dnd.utilities.server.common.model.messages;

import org.hibernate.validator.constraints.NotEmpty;

public class SearchTermRequest extends BasePageRequest {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@NotEmpty
	private String searchTerms;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	private SearchTermRequest() {}
	public SearchTermRequest(@NotEmpty String searchTerms) {
		this.searchTerms = searchTerms;
	}
	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	public String getSearchTerms() {
		return searchTerms;
	}

	public void setSearchTerms(String searchTerms) {
		this.searchTerms = searchTerms;
	}


	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
