package com.soupthatisthick.dnd.utilities.server.encounter.repo;

import com.soupthatisthick.dnd.utilities.server.encounter.entity.XpThresholdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface XpThresholdRepository extends JpaRepository<XpThresholdEntity, Long> {
	XpThresholdEntity findByLevel(@NotNull Integer level);
}
