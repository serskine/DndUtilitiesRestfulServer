package com.soupthatisthick.dnd.utilities.server.encounter.repo;

import com.soupthatisthick.dnd.utilities.server.encounter.entity.EnemyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface EnemyRepository extends JpaRepository<EnemyEntity, Long> {

	Page<EnemyEntity> findEnemyEntitiesByEncounterEntityId(@NotNull Long encounterId, Pageable pageable);
	void deleteAllByEncounterEntityId(@NotNull Long encounterId);
}
