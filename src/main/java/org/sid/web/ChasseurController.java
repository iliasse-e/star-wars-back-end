/*package org.sid.web;

import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.EtatChasseur;
import org.sid.exceptions.ChasseurNotFoundException;
import org.sid.services.ChasseurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chasseurs")
public class ChasseurController {

    private final ChasseurService chasseurService;

    public ChasseurController(ChasseurService chasseurService) {
	this.chasseurService = chasseurService;
    }

    @GetMapping()
    public List<Chasseur> getAllChasseurs() {
	return chasseurService.getChasseurs();
    }

    @GetMapping("/dispos")
    public List<Chasseur> getAllChasseursDispos() {
        return chasseurService.getChasseursDispo();
    }

    @GetMapping("/pilotes")
    public List<Chasseur> getChasseursAvecPilotes() {
        return chasseurService.getChasseursAvecPilotes();
    }

    @GetMapping("/missions")
    public List<Chasseur> getChasseursPretPourMission() {
        return chasseurService.getChasseursPretPourMission();
    }

    @PostMapping()
    public void registerNewChasseur(@RequestBody Chasseur chasseur) {
	chasseurService.addNewChasseur(chasseur);
    }

    @DeleteMapping(path = "{chasseurId}")
    public void deleteChasseur(@PathVariable("chasseurId") Long chasseurId) throws ChasseurNotFoundException {
	chasseurService.deleteChasseur(chasseurId);
    }

    @PutMapping(path = "{chasseurId}")
    public void updateChasseur(@PathVariable("chasseurId") Long chasseurId, @RequestParam(required = false) String name,
	    @RequestParam(required = false) EtatChasseur etatChasseur, @RequestParam(required = false) Pilote pilote) throws ChasseurNotFoundException {
	chasseurService.updateChasseur(chasseurId, etatChasseur, pilote);
    }
} */
