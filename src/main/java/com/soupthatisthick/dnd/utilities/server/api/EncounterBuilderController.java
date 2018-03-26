package com.soupthatisthick.dnd.utilities.server.api;

import com.soupthatisthick.dnd.utilities.server.api.common.ApiResponse;
import com.soupthatisthick.dnd.utilities.server.api.common.BasePageRequest;
import com.soupthatisthick.dnd.utilities.server.api.common.PagedApiResponse;
import com.soupthatisthick.dnd.utilities.server.api.common.PagingStats;
import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.EncounterEntity;
import com.soupthatisthick.dnd.utilities.server.service.encounter.EncounterBuilderService;
import com.soupthatisthick.dnd.utilities.server.service.encounter.model.EncounterRequest;
import com.soupthatisthick.dnd.utilities.server.service.encounter.model.NewEncounterRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Api(description = "Testing Management Endpoint")
@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class EncounterBuilderController extends BaseApiController {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	private static transient final Logger LOG = LoggerFactory.getLogger(EncounterBuilderController.class);

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Autowired
	private EncounterBuilderService encounterBuilderService;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	@ApiOperation(value = "Clears all units from the specified encounter.")
	@RequestMapping(value="/clear-units", method = RequestMethod.POST)
	public ApiResponse deleteAll(@RequestBody @Valid EncounterRequest request) {
		encounterBuilderService.clearUnits(request);
		return new ApiResponse<>();
	}

	@ApiOperation(value = "Clears all allies from the specified encounter.")
	@RequestMapping(value="/clear-allies", method = RequestMethod.POST)
	public ApiResponse deleteAllies(@RequestBody @Valid EncounterRequest request) {
		encounterBuilderService.clearAllies(request);
		return new ApiResponse<>();
	}

	@ApiOperation(value = "Clears all enemies from the specified encounter.")
	@RequestMapping(value="/clear-enemies", method = RequestMethod.POST)
	public ApiResponse deleteEnemies(@RequestBody @Valid EncounterRequest request) {
		encounterBuilderService.clearEnemies(request);
		return new ApiResponse<>();
	}

	@ApiOperation(value = "Creates a new encounter")
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public ApiResponse<EncounterEntity> createEncounter(@RequestBody @Valid NewEncounterRequest request) {
		return new ApiResponse<>(encounterBuilderService.newEncounter(request));
	}

	@ApiOperation(value = "Lists the encounters")
	@RequestMapping(value="/list", method = RequestMethod.POST)
	public PagedApiResponse<EncounterEntity> listEncounters(@RequestBody @Valid BasePageRequest request) {
		Page<EncounterEntity> page = encounterBuilderService.listEncounters(request);
		PagingStats pagingStats = new PagingStats(page);
		return new PagedApiResponse<>(page.getContent(), pagingStats);
	}

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
