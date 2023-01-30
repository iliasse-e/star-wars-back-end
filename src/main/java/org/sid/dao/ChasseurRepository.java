package org.sid.dao;

import org.sid.entities.Chasseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChasseurRepository extends JpaRepository<Chasseur, Long> {
	
}
