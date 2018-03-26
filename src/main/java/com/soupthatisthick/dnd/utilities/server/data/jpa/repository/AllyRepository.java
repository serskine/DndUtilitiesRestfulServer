package com.soupthatisthick.dnd.utilities.server.data.jpa.repository;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.AllyEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotNull;

public interface AllyRepository extends JpaRepository<AllyEntity, Long> {

	Page<AllyEntity> findAllyEntitiesByEncounterEntityId(@NotNull Long encounterId, Pageable pageable);
	void deleteAllByEncounterEntityId(@NotNull Long encounterId);
}
