package com.soupthatisthick.dnd.utilities.server.data.jpa.repository;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.measure.XpThresholdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface XpThresholdRepository extends JpaRepository<XpThresholdEntity, Long> {
	XpThresholdEntity findByLevel(@NotNull Integer level);
}
