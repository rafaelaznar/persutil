package net.ausiasmarch.persutil.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.persutil.entity.CastanyeraEntity;

public interface CastanyeraRepository extends JpaRepository<CastanyeraEntity, Long> {


	Page<CastanyeraEntity> findByPublicadoTrue(Pageable oPageable);

    Page<CastanyeraEntity> findByPublicadoFalse(Pageable oPageable);

    CastanyeraEntity findByIdAndPublicadoTrue(Long id);

}
