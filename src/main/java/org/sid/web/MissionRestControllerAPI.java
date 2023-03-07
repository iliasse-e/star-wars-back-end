package org.sid.web;

import org.jetbrains.annotations.NotNull;
import org.sid.entities.Mission;
import org.sid.exceptions.MissionNotFoundException;
import org.sid.services.MissionService;
import org.sid.web.dto.MissionCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@CrossOrigin(origins = "http://localhost:4200")

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
	public Mission create(@RequestBody @NotNull MissionCreationRequest payload) {
		System.out.println(payload);
		return missionService.createMission(payload.getName(), payload.getPilotesId());
	}

	@GetMapping
	public Iterable<Mission> getMissions() {
		return missionService.listMission();
	}

	@GetMapping("/completed")
	public Iterable<Mission> getMissionsCompleted() throws MissionNotFoundException {
		return missionService.listMissionCompleted();
	}

	@GetMapping("/in-progress")
	public Iterable<Mission> getMissionsInProgress() throws MissionNotFoundException {
		return missionService.listMissionInProgress();
	}

	@GetMapping("/{id}")
	public Mission getMissionById(@PathVariable("id") Long missionId) throws MissionNotFoundException {
		return missionService.getMission(missionId);
	}

	@DeleteMapping(path = "/{missionId}")
	public boolean deleteMisson(@PathVariable("missionId") Long missionId) throws MissionNotFoundException {
		missionService.deleteMission(missionId);
		return true;
	}

	@PutMapping(path = "/end-mission/{missionId}/{nbHeure}")
	public Mission endMission(@PathVariable("missionId") Long missionId, @PathVariable("nbHeure") int nbHeure) throws MissionNotFoundException {
		return missionService.endMission(missionId, nbHeure);
	}

}

