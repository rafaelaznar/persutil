package net.ausiasmarch.persutil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.persutil.entity.FernandezIdeaEntity;

public interface FernandezIdeaRepository extends JpaRepository<FernandezIdeaEntity, Long> {
	org.springframework.data.domain.Page<FernandezIdeaEntity> findByPublico(boolean publico, org.springframework.data.domain.Pageable pageable);

	long countByPublico(boolean publico);
}
