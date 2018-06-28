package com.soupthatisthick.dnd.utilities.server.encounter.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@Transactional(readOnly = true)
public class EncounterBuilderService {
//
//	// Constants ---------------------------------------------------------------------------------------------- Constants
//
//	private static transient final Logger LOG = LoggerFactory.getLogger(EncounterBuilderService.class);
//
//	// Instance Variables ---------------------------------------------------------------------------- Instance Variables
//
//	@Autowired
//	private EncounterRepository encounterRepository;
//
//	@Autowired
//	private AllyRepository allyRepository;
//
//	@Autowired
//	private EnemyRepository enemyRepository;
//
//	// Constructors ---------------------------------------------------------------------------------------- Constructors
//
//	// Public Methods ------------------------------------------------------------------------------------ Public Methods
//
//	@Transactional
//	public EncounterEntity newEncounter(@NotNull NewEncounterRequest request) {
//		EncounterEntity encounterEntity = new EncounterEntity(request.getName());
//		return encounterRepository.save(encounterEntity);
//	}
//
//	@Transactional
//	public void deleteEncounter(@NotNull Long encounterId) {
//		encounterRepository.delete(encounterId);
//	}
//
//	public Page<EncounterEntity> listEncounters(@NotNull BasePageRequest request) {
//		return encounterRepository.findAll(request.asPageable());
//	}
//
//	public Page<AllyEntity> getAllies(@NotNull EncounterListRequest request) {
//		return allyRepository.findAllyEntitiesByEncounterEntityId(request.getEncounterId(), request.asPageable());
//	}
//
//	public Page<EnemyEntity> getEnemies(@NotNull EncounterListRequest request) {
//		return enemyRepository.findEnemyEntitiesByEncounterEntityId(request.getEncounterId(), request.asPageable());
//	}
//
//	public void clearAllies(@NotNull EncounterRequest request) {
//		allyRepository.deleteAllByEncounterEntityId(request.getId());
//	}
//
//	public void clearEnemies(@NotNull EncounterRequest request) {
//		enemyRepository.deleteAllByEncounterEntityId(request.getId());
//	}
//
//	public void clearUnits(@NotNull EncounterRequest request) {
//		clearAllies(request);
//		clearEnemies(request);
//	}
//
//
//	// Protected Methods ------------------------------------------------------------------------------ Protected Methods
//
//	// Private Methods ---------------------------------------------------------------------------------- Private Methods
//
//	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
