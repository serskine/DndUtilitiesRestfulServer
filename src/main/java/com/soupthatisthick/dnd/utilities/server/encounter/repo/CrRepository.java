package com.soupthatisthick.dnd.utilities.server.encounter.repo;

import com.soupthatisthick.dnd.utilities.server.client.model.lookup.ChallengeRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface CrRepository extends JpaRepository<ChallengeRating, Long> {
	@Query("select e from ChallengeRating e where e.value = :value")
	ChallengeRating findByValue(@NotNull @Param("value") float value);
}