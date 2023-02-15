package org.sid.dao;

import java.util.Optional;

import org.sid.entities.Chasseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChasseurRepository extends JpaRepository<Chasseur, Long> {
    Optional<Chasseur> findChasseurByName(String name);
}
