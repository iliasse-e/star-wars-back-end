package org.sid.dao;

import org.sid.entities.Pilote;
import org.sid.enums.Sante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PiloteRepository extends JpaRepository<Pilote, Long> {
    List<Pilote> findByEnFormationTrue();
    List<Pilote> findByEnFormationFalse();
    List<Pilote> findByChasseurNull();
    List<Pilote> findByChasseurNotNull();
    List<Pilote> findBySanteAndEnFormationFalseAndMissionActuelleIsNullAndChasseurIsNotNull(Sante sante);
}
