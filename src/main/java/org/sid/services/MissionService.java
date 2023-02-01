package org.sid.services;

import java.util.List;

import org.sid.entities.Mission;
import org.sid.exceptions.MissionNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public interface MissionService {
	Mission saveMission(Mission mission);
	List<Mission> listMission();
	Mission getMission(Long missionId) throws MissionNotFoundException;
	boolean deleteMission(Long missionId) throws MissionNotFoundException;
	// Mission addPilotes(List<Pilote> listPilotes);
	Mission endMission(Long missionId) throws MissionNotFoundException;

	@Transactional
	Mission updateMission(Long missionId, String nom) throws MissionNotFoundException;
}
