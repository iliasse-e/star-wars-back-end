package org.sid.services;

import java.util.List;

import org.sid.dao.MissionRepository;
import org.sid.dao.PiloteRepository;
import org.sid.entities.Mission;
import org.sid.entities.Pilote;
import org.sid.exceptions.MissionNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Transactional
public class MissionServiceImpl implements MissionService {

	private final MissionRepository missionRepository;
	private final PiloteRepository piloteRepository;

	public MissionServiceImpl(MissionRepository missionRepository, PiloteRepository piloteRepository) {
		this.missionRepository = missionRepository;
		this.piloteRepository = piloteRepository;
	}

	@Override
	public Mission saveMission(Mission mission) {
		// Mission currentMission = mission;
		return missionRepository.save(mission);
		// return currentMission;
	}

	@Override
	@GetMapping("/missions")
	public List<Mission> listMission() {
		return missionRepository.findAll();
	}

	@Override
	public Mission getMission(Long missionId) throws MissionNotFoundException {
		Mission currentMission = missionRepository.findById(missionId)
				.orElseThrow(() -> new MissionNotFoundException("Mission inconnue"));
		return currentMission;
	}

	@Override
	public Mission addPilotes(List<Pilote> listPilotes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mission endMission(Long missionId) throws MissionNotFoundException {
		Mission currentMission = missionRepository.findById(missionId)
				.orElseThrow(() -> new MissionNotFoundException("Mission inconnue"));
		currentMission.endMission();
		return currentMission;
	}

}
