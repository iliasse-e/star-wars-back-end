package org.sid.dao;

import org.sid.entities.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    public Mission findByNom(String name);

    public List<Mission> findByEstComplete(boolean state);
}
