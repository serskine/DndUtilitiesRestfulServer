package com.soupthatisthick.dnd.utilities.server.service.encounterbuilder;

import com.soupthatisthick.dnd.utilities.server.api.common.BasePageRequest;
import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.builder.AllyEntity;
import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.builder.EncounterEntity;
import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.builder.EnemyEntity;
import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.AllyRepository;
import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.EncounterRepository;
import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.EnemyRepository;
import com.soupthatisthick.dnd.utilities.server.service.encounterbuilder.model.EncounterListRequest;
import com.soupthatisthick.dnd.utilities.server.service.encounterbuilder.model.EncounterRequest;
import com.soupthatisthick.dnd.utilities.server.service.encounterbuilder.model.NewEncounterRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@Transactional(readOnly = true)
public class EncounterBuilderService {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	private static transient final Logger LOG = LoggerFactory.getLogger(EncounterBuilderService.class);

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	@Autowired
	private EncounterRepository encounterRepository;

	@Autowired
	private AllyRepository allyRepository;

	@Autowired
	private EnemyRepository enemyRepository;

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	@Transactional
	public EncounterEntity newEncounter(@NotNull NewEncounterRequest request) {
		EncounterEntity encounterEntity = new EncounterEntity(request.getName());
		return encounterRepository.save(encounterEntity);
	}

	@Transactional
	public void deleteEncounter(@NotNull Long encounterId) {
		encounterRepository.delete(encounterId);
	}

	public Page<EncounterEntity> listEncounters(@NotNull BasePageRequest request) {
		return encounterRepository.findAll(request.asPageable());
	}

	public Page<AllyEntity> getAllies(@NotNull EncounterListRequest request) {
		return allyRepository.findAllyEntitiesByEncounterEntityId(request.getEncounterId(), request.asPageable());
	}

	public Page<EnemyEntity> getEnemies(@NotNull EncounterListRequest request) {
		return enemyRepository.findEnemyEntitiesByEncounterEntityId(request.getEncounterId(), request.asPageable());
	}

	public void clearAllies(@NotNull EncounterRequest request) {
		allyRepository.deleteAllByEncounterEntityId(request.getId());
	}

	public void clearEnemies(@NotNull EncounterRequest request) {
		enemyRepository.deleteAllByEncounterEntityId(request.getId());
	}

	public void clearUnits(@NotNull EncounterRequest request) {
		clearAllies(request);
		clearEnemies(request);
	}


	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
