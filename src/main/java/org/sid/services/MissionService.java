package org.sid.services;

import java.util.List;

import org.sid.entities.Mission;
import org.sid.entities.Pilote;
import org.sid.exceptions.MissionNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public interface MissionService {
	Mission saveMission(Mission mission);
	List<Mission> listMission();
	Mission getMission(Long missionId) throws MissionNotFoundException;
	void deleteMission(Long missionId) throws MissionNotFoundException;
	// Mission addPilotes(List<Pilote> listPilotes);
	Mission endMission(Long missionId) throws MissionNotFoundException;

	@Transactional
	void updateMission(Long missionId, String nom) throws MissionNotFoundException;
}
