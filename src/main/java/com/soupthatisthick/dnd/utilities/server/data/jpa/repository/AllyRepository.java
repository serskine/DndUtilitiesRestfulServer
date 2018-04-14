package com.soupthatisthick.dnd.utilities.server.data.jpa.repository;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.builder.AllyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface AllyRepository extends JpaRepository<AllyEntity, Long> {

	Page<AllyEntity> findAllyEntitiesByEncounterEntityId(@NotNull Long encounterId, Pageable pageable);
	void deleteAllByEncounterEntityId(@NotNull Long encounterId);
}
