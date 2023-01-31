package org.sid.web;

import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.EtatChasseur;
import org.sid.exceptions.ChasseurNotFoundException;
import org.sid.services.ChasseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chasseurs")
public class ChasseurRestControllerAPI {
    @Autowired
    private ChasseurService chasseurService;

    public ChasseurRestControllerAPI(ChasseurService chasseurService) {
        this.chasseurService = chasseurService;
    }

    @GetMapping()
    public List<Chasseur> getAllChasseurs() {
        return chasseurService.listChasseurs();
    }

    @PostMapping()
    public void registerNewChasseur(@RequestBody Chasseur chasseur) {
        chasseurService.saveChasseur(chasseur);
    }

    @DeleteMapping(path = "/chasseurs/{chasseurId}")
    public void deleteChasseur(@PathVariable("chasseurId") Long chasseurId) throws ChasseurNotFoundException {
        chasseurService.deleteChasseur(chasseurId);
    }

    @PutMapping(path = "/chasseurs/{chasseurId}")
    public void updateChasseur(@PathVariable("chasseurId") Long chasseurId, @RequestParam(required = false) String name,
                               @RequestParam(required = false) EtatChasseur etatChasseur, @RequestParam(required = false) Pilote pilote) throws ChasseurNotFoundException {
        chasseurService.updateChasseur(chasseurId, etatChasseur, pilote);
    }
}
