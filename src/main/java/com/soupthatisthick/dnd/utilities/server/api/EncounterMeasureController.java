package com.soupthatisthick.dnd.utilities.server.api;

import com.soupthatisthick.dnd.utilities.server.api.common.ApiResponse;
import com.soupthatisthick.dnd.utilities.server.service.common.base.ServiceException;
import com.soupthatisthick.dnd.utilities.server.service.encountermeasure.EncounterMeasureService;
import com.soupthatisthick.dnd.utilities.server.service.encountermeasure.model.EncounterMeasurementRequest;
import com.soupthatisthick.dnd.utilities.server.service.encountermeasure.model.EncounterMeasurementResponse;
import com.soupthatisthick.dnd.utilities.server.service.encountermeasure.model.PartyInfoRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Api(description = "Encounter Measurement Endpoint")
@RestController
@RequestMapping(value = "/encounter-measure", produces = MediaType.APPLICATION_JSON_VALUE)
public class EncounterMeasureController {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	// Constants ---------------------------------------------------------------------------------------------- Constants

	private static transient final Logger LOG = LoggerFactory.getLogger(EncounterBuilderController.class);

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Autowired
	private EncounterMeasureService encounterMeasureService;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	@ApiOperation(value = "Determines the average party level")
	@RequestMapping(value="/apl", method = RequestMethod.POST)
	public ApiResponse<Integer> averagePartyLevel(@RequestBody @Valid PartyInfoRequest request) throws ServiceException {
		return new ApiResponse<>(encounterMeasureService.getAveragePartyLevel(request));
	}

	@ApiOperation(value = "Measures encounter measure threat level using the method provided in the Dungeon Master Guide.")
	@RequestMapping(value="/measure-dmg", method = RequestMethod.POST)
	public ApiResponse<EncounterMeasurementResponse> dmgMeasurement(@RequestBody @Valid EncounterMeasurementRequest request) throws ServiceException {
		return new ApiResponse<>(encounterMeasureService.dmgMeasurement(request));
	}

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
