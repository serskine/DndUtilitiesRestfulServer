package com.soupthatisthick.dnd.utilities.server.data.jpa.repository;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.AllyEntity;
import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.EnemyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotNull;

public interface EnemyRepository extends JpaRepository<EnemyEntity, Long> {

	Page<EnemyEntity> findEnemyEntitiesByEncounterEntityId(@NotNull Long encounterId, Pageable pageable);
	void deleteAllByEncounterEntityId(@NotNull Long encounterId);
}
