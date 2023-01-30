package org.sid.web;

import java.util.List;

import org.sid.dao.MissionRepository;
import org.sid.entities.Mission;
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
	private final MissionRepository missionRepository;

	public MissionRestControllerAPI(MissionRepository missionRepository) {
		this.missionRepository = missionRepository;
	}
	
	@GetMapping
	public List<Mission> listeMission() {
		return missionRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Mission getOne(@PathVariable Long id) {
		return missionRepository.getById(id);
	}
	
	@PostMapping
	public Mission save(@RequestBody Mission mission) {
		return missionRepository.save(mission);
	}
	
}
