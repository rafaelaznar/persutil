package net.ausiasmarch.persutil.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.persutil.entity.CastanyeraEntity;

public interface CastanyeraRepository extends JpaRepository<CastanyeraEntity, Long> {

	// Devuelve solo las entidades marcadas como públicas
	Page<CastanyeraEntity> findByPublicoTrue(Pageable pageable);

	// Contador de entidades públicas
	long countByPublicoTrue();

	Page<CastanyeraEntity> findByPublicadoTrue(Pageable oPageable);

    Page<CastanyeraEntity> findByPublicadoFalse(Pageable oPageable);

    CastanyeraEntity findByIdAndPublicadoTrue(Long id);

}
