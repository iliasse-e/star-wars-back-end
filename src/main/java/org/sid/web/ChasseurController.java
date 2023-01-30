package org.sid.web;

import java.util.List;

import org.sid.entities.Chasseur;
import org.sid.services.ChasseurService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/chasseur")
public class ChasseurController {

    private final ChasseurService chasseurService;

    public ChasseurController(ChasseurService chasseurService) {
	this.chasseurService = chasseurService;
    }

    @GetMapping()
    public List<Chasseur> getAllChasseurs() {
	return chasseurService.getChasseurs();
    }
}
