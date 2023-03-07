package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.dao.MissionRepository;
import org.sid.dao.PiloteRepository;
import org.sid.entities.Mission;
import org.sid.entities.Pilote;
import org.sid.exceptions.MissionNotFoundException;
import org.sid.exceptions.PiloteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Transactional
public class MissionServiceImpl implements MissionService {
	@Autowired
	private MissionRepository missionRepository;
	@Autowired
	private PiloteService piloteService;


	@Override
	public Mission createMission(String name, List<Long> pilotesId) {
		List<Pilote> currentPilotes = piloteService.getPilotesByIds(pilotesId);
		Mission newMission = missionRepository.save(new Mission(name, currentPilotes));
		List<Pilote> pilotes = newMission.getPilotes();
		pilotes.forEach(pilote -> {
			try {
				piloteService.goMission(pilote, name);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
		return null;
	}

	@Override
	public List<Mission> listMission() {
		return missionRepository.findAll();
	}

	@Override
	public List<Mission> listMissionCompleted() throws MissionNotFoundException {
		return missionRepository.findByEstComplete(true);
	}

	@Override
	public List<Mission> listMissionInProgress() throws MissionNotFoundException {
		return missionRepository.findByEstComplete(false);
	}

	@Override
	public Mission getMission(Long missionId) throws MissionNotFoundException {
		Mission currentMission = missionRepository.findById(missionId)
				.orElseThrow(() -> new MissionNotFoundException("Mission inconnue"));
		return currentMission;
	}

	@Override
	public Mission getMission(String missionName) throws MissionNotFoundException {
		return missionRepository.findByNom(missionName);
	}

	@Override
	public boolean deleteMission(Long missionId) throws MissionNotFoundException {
		if (missionRepository.findById(missionId).isEmpty()) {
			throw new MissionNotFoundException("No mission with this id found");
		}
		missionRepository.deleteById(missionId);
		return true;
	}

	@Override
	@Transactional
	public Mission endMission(Long missionId, int nbHeure) throws MissionNotFoundException {
		Mission currentMission = missionRepository.findById(missionId)
				.orElseThrow(() -> new MissionNotFoundException("Mission inconnue"));
		currentMission.setNbHeureMission(nbHeure);
		currentMission.endMission();
		currentMission.getPilotes().forEach(pilote -> {
			piloteService.endMission(pilote.getId(), nbHeure);
		});
		missionRepository.save(currentMission);
		return currentMission;
	}
}
