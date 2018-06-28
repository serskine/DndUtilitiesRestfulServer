package com.soupthatisthick.dnd.utilities.server.encounter.repo;

import com.soupthatisthick.dnd.utilities.server.client.model.lookup.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
//	@Query("select e from LEVEL_DETAILS e where e.level=:level")
//	Level findByLevel(@NotNull @Param("level") Integer level);
}
