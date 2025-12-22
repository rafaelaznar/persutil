package net.ausiasmarch.persutil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.persutil.entity.AlfonsoRespuestaEntity;

public interface AlfonsoRespuestaRepository extends JpaRepository<AlfonsoRespuestaEntity, Long> {

    Page<AlfonsoRespuestaEntity> findByPublicadoTrue(Pageable oPageable);

    Page<AlfonsoRespuestaEntity> findByPublicadoFalse(Pageable oPageable);

    AlfonsoRespuestaEntity findByIdAndPublicadoTrue(Long id);
}
