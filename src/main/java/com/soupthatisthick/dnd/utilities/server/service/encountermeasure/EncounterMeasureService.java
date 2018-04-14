package com.soupthatisthick.dnd.utilities.server.service.encountermeasure;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.CrEntity;
import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.measure.XpThresholdEntity;
import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.CrRepository;
import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.XpThresholdRepository;
import com.soupthatisthick.dnd.utilities.server.service.common.base.ErrorCode;
import com.soupthatisthick.dnd.utilities.server.service.common.base.ServiceException;
import com.soupthatisthick.dnd.utilities.server.service.encounterbuilder.EncounterBuilderService;
import com.soupthatisthick.dnd.utilities.server.service.encountermeasure.model.*;
import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@Transactional(readOnly = true)
public class EncounterMeasureService {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	private static transient final Logger LOG = LoggerFactory.getLogger(EncounterBuilderService.class);

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Autowired
	private XpThresholdRepository xpThresholdRepository;

	@Autowired
	private CrRepository crRepository;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	/**
	 * Returns the average party level of a party
	 * @param request contains the information about the party
	 * @return the average party level
	 * @throws ServiceException if we did not specify any allies
	 */
	public Integer getAveragePartyLevel(@NotNull PartyInfoRequest request) throws ServiceException {
		float sum = 0;
		if (request.getAllies().size()<1) {
			throw new ServiceException(ErrorCode.UNKNOWN_ERROR, "There must be at least one ally to measure with.");
		}

		for(Integer level : request.getAllies()) {
			sum += level;
		}

		return Math.round(sum / request.getAllies().size());
	}

	/**
	 * Converts it into a measurement using enemy xp and then returns the result.
	 * @param request the enemies are listed by their cr value
	 * @return a {@link EncounterMeasurementResponse}
	 * @throws ServiceException if an exception occurs.
	 */
	public EncounterMeasurementResponse dmgMeasurement(@NotNull MeasurementUsingCrRequest request) throws ServiceException {
		List<Integer> enemyXpValues = new ArrayList<>();
		for(Float cr : request.getEnemyCrs()) {
			CrEntity crEntity = crRepository.findByCr(cr);
			if (crEntity==null) {
				throw new ServiceException(ErrorCode.UNKNOWN_ERROR, "There is no known challenge rating value " + cr + ".");
			}
			enemyXpValues.add(crEntity.getXp());
		}

		MeasurementUsingXpRequest newRequest = new MeasurementUsingXpRequest();
		newRequest.setAllyLevels(request.getAllyLevels());
		newRequest.setEnemyXps(enemyXpValues);
		return dmgMeasurement(newRequest);
	}

	/**
	 * This method will measure an encounter difficulty using the methods provided in the Dungeon Master Guide
	 * @param request provided details for the encounter
	 */
	public EncounterMeasurementResponse dmgMeasurement(@NotNull MeasurementUsingXpRequest request) throws ServiceException {
		int numAllies = request.getAllyLevels().size();

		LOG.debug("\n___ DMG Measurement ___\n{}", JsonUtil.toJson(request, true));

		if (numAllies<1) {
			throw new ServiceException(ErrorCode.UNKNOWN_ERROR, "There must be at least one ally.");
		}

		// Determine the party thresholds
		int partyEasy = 0;
		int partyModerate = 0;
		int partyHard = 0;
		int partyDeadly = 0;

		for(Integer allyLevel : request.getAllyLevels()) {
			XpThresholdEntity xpThresholdEntity = xpThresholdRepository.findByLevel(allyLevel);
			if (xpThresholdEntity==null) {
				throw new ServiceException(ErrorCode.UNKNOWN_ERROR, "No thresholds defined for ally level " + allyLevel + ".");
			}
			partyEasy += xpThresholdEntity.getEasy();
			partyModerate += xpThresholdEntity.getModerate();
			partyHard += xpThresholdEntity.getHard();
			partyDeadly += xpThresholdEntity.getDeadly();
		}

		int sumEnemyXp = 0;
		int numWorthyEnemies = request.getEnemyXps().size();

		for(Integer enemyXp : request.getEnemyXps()) {
			sumEnemyXp += enemyXp;
		}

		float enemyXpThreshold = getMultiplier(numWorthyEnemies, numAllies) * sumEnemyXp;

		ThreatValue threatValue = getClosestThreatValue(partyEasy, partyModerate, partyHard, partyDeadly, enemyXpThreshold);

		return new EncounterMeasurementResponse(threatValue);
	}


	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	private static ThreatValue getClosestThreatValue(
		int partyEasy, int partyModerate, int partyHard, int partyDeadly,
		float adjustedMonsterXp
	) {
		ThreatValue threatValue = ThreatValue.TRIVIAL;
		if (partyEasy <= adjustedMonsterXp) {
			threatValue = ThreatValue.EASY;
		}
		if (partyModerate <= adjustedMonsterXp) {
			threatValue = ThreatValue.MODERATE;
		}
		if (partyHard <= adjustedMonsterXp) {
			threatValue = ThreatValue.HARD;
		}
		if (partyDeadly <= adjustedMonsterXp) {
			threatValue = ThreatValue.DEADLY;
		}
		return threatValue;
	}

	private static float getMultiplier(int numEnemies, int numAllies) {

		if (numEnemies<1)   { return 0F;      }

		int idx;

		if (numEnemies==1) {
			idx = 1;
		} else if (numEnemies==2) {
			idx = 2;
		} else if (numEnemies<=6) {
			idx = 3;
		} else if (numEnemies<=10) {
			idx = 4;
		} else if (numEnemies<=14) {
			idx = 5;
		} else {
			idx = 6;
		}

		if (numAllies<3) {
			idx++;
		}
		if (numAllies>=6) {
			idx--;
		}

		// This is the list of all possible multipliers
		final float multipliers[] = new float[] {
				0.5F, 1F, 1.5F, 2F, 2.5F, 3F, 4F
		};

		idx = Math.max(0, Math.min(multipliers.length-1, idx));
		return multipliers[idx];
	}

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
