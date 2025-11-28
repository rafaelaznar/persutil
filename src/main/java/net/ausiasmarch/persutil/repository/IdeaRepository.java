package net.ausiasmarch.persutil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.persutil.entity.IdeaEntity;

public interface IdeaRepository extends JpaRepository<IdeaEntity, Long> {
	org.springframework.data.domain.Page<IdeaEntity> findByPublico(boolean publico, org.springframework.data.domain.Pageable pageable);

	long countByPublico(boolean publico);
}
