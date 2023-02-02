package org.sid.services;

import java.util.List;

import org.sid.entities.Mission;
import org.sid.entities.Pilote;
import org.sid.exceptions.MissionNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public interface MissionService {


	Mission saveMission(Mission mission, List<Pilote> pilotes);

	List<Mission> listMission();
	Mission getMission(Long missionId) throws MissionNotFoundException;
	boolean deleteMission(Long missionId) throws MissionNotFoundException;

	@Transactional
	Mission updateMission(Long missionId) throws MissionNotFoundException;

	// Mission addPilotes(List<Pilote> listPilotes);

	@Transactional
	Mission updateMission(Long missionId, String nom) throws MissionNotFoundException;

	@Transactional
	Mission endMission(Long missionId, int nbHeure) throws MissionNotFoundException;
}
