package org.sid.web;

import java.util.Iterator;
import java.util.List;

import org.sid.dao.MissionRepository;
import org.sid.entities.Mission;
import org.sid.exceptions.ChasseurNotFoundException;
import org.sid.exceptions.MissionNotFoundException;
import org.sid.services.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@RestController
@RequestMapping("/missions")

public class MissionRestControllerAPI {
	@Autowired
	private MissionService missionService;

	public MissionService getMissionService() {
		return missionService;
	}

	public void setMissionService(MissionService missionService) {
		this.missionService = missionService;
	}

	@PostMapping
	public Mission create(@RequestBody Mission mission) {
		return missionService.saveMission(mission);
	}

	@GetMapping
	public Iterable<Mission> missions() {
		return missionService.listMission();
	}

	@GetMapping("/missions/{id}")
	public Mission get(@PathVariable("id") Long missionId) throws MissionNotFoundException {
		return missionService.getMission(missionId);
	}

	@DeleteMapping(path = "/missions/{missionId}")
	public void deleteMisson(@PathVariable("missionId") Long missionId) throws MissionNotFoundException {
		missionService.deleteMission(missionId);
	}

}
