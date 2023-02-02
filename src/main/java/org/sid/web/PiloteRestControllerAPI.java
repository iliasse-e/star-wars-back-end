package org.sid.web;

import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.Sante;
import org.sid.exceptions.ChasseurNotFoundException;
import org.sid.exceptions.PiloteNotFoundException;
import org.sid.exceptions.RebelleNotFoundException;
import org.sid.services.PiloteService;
import org.sid.services.RebelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilotes")
@CrossOrigin(origins = "http://localhost:4200")
public class PiloteRestControllerAPI {
    @Autowired
    private PiloteService piloteService;
    private RebelleService rebelleService;

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

    @DeleteMapping("/delete/{piloteId]")
    public boolean deletePilote(@PathVariable("piloteId") Long piloteId) throws PiloteNotFoundException, RebelleNotFoundException {
        rebelleService.deleteRebelle(piloteId);
        return true;
    }

    @GetMapping("/dispos")
    public List<Pilote> getAllPilotesDispos() {
        return piloteService.getPiloteDispo();
    }

    @GetMapping("/get/{piloteId}")
    public Pilote get(@PathVariable("piloteId") Long piloteId) throws PiloteNotFoundException {
        return piloteService.getPilote(piloteId);
    }

    @PutMapping("/affecter_chasseur/{piloteId}")
    public Pilote affecterChasseur(@PathVariable("piloteId") Long piloteId, Long chasseurId) throws PiloteNotFoundException, ChasseurNotFoundException {
        return piloteService.affecterChasseur(piloteId, chasseurId);
    }

    @PutMapping("/desaffecter_chasseur/{piloteId}")
    public Pilote desaffecterChasseur(@PathVariable("piloteId") Long piloteId) throws PiloteNotFoundException {
        return piloteService.desaffecterChasseur(piloteId);
    }

    @PutMapping("/update/{piloteId}")
    public Pilote updatePilote(@PathVariable("piloteId") Long piloteId, double heures, Sante sante) throws PiloteNotFoundException {
        return piloteService.updatePilote(piloteId, heures, sante);
    }
}
