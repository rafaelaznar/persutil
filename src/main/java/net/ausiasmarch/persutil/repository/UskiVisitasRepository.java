package net.ausiasmarch.persutil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.persutil.entity.UskiVisitasEntity;

public interface UskiVisitasRepository extends JpaRepository<UskiVisitasEntity, Long> {
    Page<UskiVisitasEntity> findByEstaPublicadoTrue(Pageable pageable);
}
