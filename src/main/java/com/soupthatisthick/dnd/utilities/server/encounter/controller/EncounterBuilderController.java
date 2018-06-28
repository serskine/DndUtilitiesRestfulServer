package com.soupthatisthick.dnd.utilities.server.encounter.controller;

import com.soupthatisthick.dnd.utilities.server.common.controller.BaseApiController;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Api(description = "Encounter builder endpoint")
@RestController
@RequestMapping(value = "/encounter-builder", produces = MediaType.APPLICATION_JSON_VALUE)
public class EncounterBuilderController extends BaseApiController {
//
//	// Constants ---------------------------------------------------------------------------------------------- Constants
//
//	private static transient final Logger LOG = LoggerFactory.getLogger(EncounterBuilderController.class);
//
//	// Instance Variables ---------------------------------------------------------------------------- Instance Variables
//
//	@Autowired
//	private EncounterBuilderService encounterBuilderService;
//
//	// Constructors ---------------------------------------------------------------------------------------- Constructors
//
//	// Public Methods ------------------------------------------------------------------------------------ Public Methods
//
//	@ApiOperation(value = "Clears all units from the specified encounter.")
//	@RequestMapping(value="/clear-units", method = RequestMethod.POST)
//	public ApiResponse deleteAll(@RequestBody @Valid EncounterRequest request) {
//		encounterBuilderService.clearUnits(request);
//		return new ApiResponse<>();
//	}
//
//	@ApiOperation(value = "Clears all allies from the specified encounter.")
//	@RequestMapping(value="/clear-allies", method = RequestMethod.POST)
//	public ApiResponse deleteAllies(@RequestBody @Valid EncounterRequest request) {
//		encounterBuilderService.clearAllies(request);
//		return new ApiResponse<>();
//	}
//
//	@ApiOperation(value = "Clears all enemies from the specified encounter.")
//	@RequestMapping(value="/clear-enemies", method = RequestMethod.POST)
//	public ApiResponse deleteEnemies(@RequestBody @Valid EncounterRequest request) {
//		encounterBuilderService.clearEnemies(request);
//		return new ApiResponse<>();
//	}
//
//	@ApiOperation(value = "Creates a new encounter")
//	@RequestMapping(value="/create", method = RequestMethod.POST)
//	public ApiResponse<EncounterEntity> createEncounter(@RequestBody @Valid NewEncounterRequest request) {
//		return new ApiResponse<>(encounterBuilderService.newEncounter(request));
//	}
//
//	@ApiOperation(value = "Lists the encounters")
//	@RequestMapping(value="/list", method = RequestMethod.POST)
//	public PagedApiResponse<EncounterEntity> listEncounters(@RequestBody @Valid BasePageRequest request) {
//		Page<EncounterEntity> page = encounterBuilderService.listEncounters(request);
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
