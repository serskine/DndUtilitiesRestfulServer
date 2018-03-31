package com.soupthatisthick.dnd.utilities.server.api.common;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
