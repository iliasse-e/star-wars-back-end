package org.sid.web;

import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.EtatChasseur;
import org.sid.exceptions.ChasseurNotFoundException;
import org.sid.services.ChasseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.util.List;

@RestController
@RequestMapping("/chasseurs")
@CrossOrigin(origins = "http://localhost:4200")
public class ChasseurRestControllerAPI {
    @Autowired
    private ChasseurService chasseurService;

    @GetMapping()
    public List<Chasseur> getAllChasseurs() {
        return chasseurService.listChasseurs();
    }

    @GetMapping("/available")
    public List<Chasseur> getAllChasseursAvailable() {
        return chasseurService.getChasseursDispo();
    }

    @GetMapping("/affected")
    public List<Chasseur> getChasseursAffected() {
        return chasseurService.getChasseursAvecPilotes();
    }

    @GetMapping("/mission-ready")
    public List<Chasseur> getChasseursPretPourMission() {
        return chasseurService.getChasseursPretPourMission();
    }

    @PostMapping()
    public Chasseur registerNewChasseur(@RequestBody Chasseur chasseur) {
        chasseurService.createChasseur(chasseur);
        return chasseur;
    }

    @DeleteMapping(path = "/{chasseurId}")
    public boolean deleteChasseur(@PathVariable("chasseurId") Long chasseurId) throws ChasseurNotFoundException {
        chasseurService.deleteChasseur(chasseurId);
        return true;
    }

    @PutMapping(path = "/{chasseurId}")
    public Chasseur updateChasseur(@PathVariable("chasseurId") Long chasseurId, @RequestParam(required = false) String name,
                               @RequestParam(required = false) EtatChasseur etatChasseur, @RequestParam(required = false) Pilote pilote) throws ChasseurNotFoundException {
       return chasseurService.updateChasseur(chasseurId, etatChasseur, pilote);
    }
}
