package org.sid.web;

import java.util.Iterator;
import java.util.List;

import org.sid.dao.MissionRepository;
import org.sid.entities.Mission;
import org.sid.exceptions.MissionNotFoundException;
import org.sid.services.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
