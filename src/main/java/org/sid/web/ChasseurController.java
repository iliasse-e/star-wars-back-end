package org.sid.web;

import java.util.List;

import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.EtatChasseur;
import org.sid.services.ChasseurService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping()
    public void registerNewChasseur(@RequestBody Chasseur chasseur) {
	chasseurService.addNewChasseur(chasseur);
    }

    @DeleteMapping(path = "{chasseurId}")
    public void deleteChasseur(@PathVariable("chasseurId") Long chasseurId) {
	chasseurService.deleteChasseur(chasseurId);
    }

    @PutMapping(path = "{chasseurId}")
    public void updateChasseur(@PathVariable("chasseurId") Long chasseurId, @RequestParam(required = false) String name,
	    @RequestParam(required = false) EtatChasseur etatChasseur, @RequestParam(required = false) Pilote pilote) {
	chasseurService.updateChasseur(chasseurId, etatChasseur, pilote);
    }
}
