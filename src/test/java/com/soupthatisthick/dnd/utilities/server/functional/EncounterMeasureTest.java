package com.soupthatisthick.dnd.utilities.server.functional;

import com.soupthatisthick.dnd.utilities.server.service.common.base.ServiceException;
import com.soupthatisthick.dnd.utilities.server.service.encountermeasure.EncounterMeasureService;
import com.soupthatisthick.dnd.utilities.server.service.encountermeasure.model.EncounterMeasurementRequest;
import com.soupthatisthick.dnd.utilities.server.service.encountermeasure.model.EncounterMeasurementResponse;
import com.soupthatisthick.dnd.utilities.server.util.BaseSpringBootTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class EncounterMeasureTest extends BaseSpringBootTest {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	private static transient final Logger LOG = LoggerFactory.getLogger(EncounterMeasureTest.class);

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Autowired
	private EncounterMeasureService encounterMeasureService;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	@Test
	public void dndMeasureEncounter() throws ServiceException {
		testingService.initDatabase();

		EncounterMeasurementRequest request = new EncounterMeasurementRequest();
		List<Integer> allies = Arrays.asList(1,2,3,4,5);
		List<Integer> enemyXp = Arrays.asList(25, 25, 25, 25, 25);
		request.setAllyLevels(allies);
		request.setEnemyXps(enemyXp);

		titleLog("request", request);

		EncounterMeasurementResponse response = encounterMeasureService.dmgMeasurement(request);

		titleLog("response", response);
	}

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
