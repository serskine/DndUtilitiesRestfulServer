package com.soupthatisthick.dnd.utilities.server.data.jpa.repository;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.base.DisplayableEntity;
import edu.umd.cs.findbugs.annotations.OverrideMustInvoke;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.annotation.Nullable;

@NoRepositoryBean
public interface SearchableRepository<EntityType extends DisplayableEntity> extends JpaRepository<EntityType, Long> {
	Page<EntityType> search(@NotEmpty String searchTerms, @Nullable Pageable pageable);
}
