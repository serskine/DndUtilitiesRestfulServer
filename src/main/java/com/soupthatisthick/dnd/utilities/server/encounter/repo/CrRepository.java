package com.soupthatisthick.dnd.utilities.server.encounter.repo;

import com.soupthatisthick.dnd.utilities.server.encounter.entity.CrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface CrRepository extends JpaRepository<CrEntity, Long> {
	CrEntity findByCr(@NotNull Float cr);
}