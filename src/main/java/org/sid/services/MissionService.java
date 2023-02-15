package org.sid.services;

import java.util.List;

import org.sid.entities.Mission;
import org.sid.entities.Pilote;
import org.sid.exceptions.MissionNotFoundException;
import org.sid.exceptions.PiloteNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public interface MissionService {
	Mission createMission(String name, List<Long> pilotesId);
	List<Mission> listMission();
	Mission getMission(Long missionId) throws MissionNotFoundException;

	Mission getMission(String missionName) throws MissionNotFoundException;

	boolean deleteMission(Long missionId) throws MissionNotFoundException;
	Mission endMission(Long missionId, double nbHeure) throws MissionNotFoundException;
}
