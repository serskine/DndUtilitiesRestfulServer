package com.soupthatisthick.dnd.utilities.server.data.jpa.repository;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.CrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;

public interface CrRepository extends JpaRepository<CrEntity, Long> {
	CrEntity findByCr(@NotNull Float cr);
}