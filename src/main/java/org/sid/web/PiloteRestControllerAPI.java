package org.sid.web;

import org.sid.entities.Pilote;
import org.sid.exceptions.PiloteNotFoundException;
import org.sid.services.PiloteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pilotes")
public class PiloteRestControllerAPI {
	@Autowired
	private PiloteService piloteService;

	public PiloteService getPiloteService() {
		return piloteService;
	}

	public void setPiloteService(PiloteService piloteService) {
		this.piloteService = piloteService;
	}

	@PostMapping
	public Pilote create(@RequestBody Pilote pilote) {
		return piloteService.savePilote(pilote);
	}

	@GetMapping
	public Iterable<Pilote> pilotes() {
		return piloteService.listPilote();
	}

	@GetMapping("/{id}")
	public Pilote get(@PathVariable("id") Long piloteId) throws PiloteNotFoundException {
		return piloteService.getPilote(piloteId);
	}

}
