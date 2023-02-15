package org.sid.web;

import org.sid.entities.Pilote;
import org.sid.enums.Sante;
import org.sid.exceptions.ChasseurNotFoundException;
import org.sid.exceptions.PiloteNotFoundException;
import org.sid.exceptions.RebelleNotFoundException;
import org.sid.services.PiloteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilotes")
@CrossOrigin(origins = "*")
public class PiloteRestControllerAPI {
    @Autowired
    private PiloteService piloteService;

    @PostMapping
    public Pilote create(@RequestBody Pilote pilote) {
        return piloteService.createPilote(pilote);
    }

    @GetMapping
    public Iterable<Pilote> getPilotes() {
        return piloteService.listPilote();
    }

    @DeleteMapping("/delete/{piloteId}")
    public boolean deletePilote(@PathVariable("piloteId") Long piloteId) throws PiloteNotFoundException {
        piloteService.deletePilote(piloteId);
        return true;
    }

    @GetMapping("/en-formation")
    public List<Pilote> getPilotesEnFormation() {
        return piloteService.getPilotesEnFormation();
    }

    @GetMapping("/available")
    public List<Pilote> getAllPilotesDispos() {
        return piloteService.getPilotesDispo();
    }

    @GetMapping("/mission-ready")
    public List<Pilote> getAllPilotesMissionReady() {
        return piloteService.getPilotesMissionReady();
    }

    @GetMapping("/has-chasseur")
    public List<Pilote> getAllPilotesHasChasseur() {
        return piloteService.getPilotesHasChasseur();
    }

    @GetMapping("/search/{piloteId}")
    public Pilote getPilote(@PathVariable("piloteId") Long piloteId) throws PiloteNotFoundException {
        return piloteService.getPilote(piloteId);
    }

    @PostMapping("end-formation/{piloteId}")
    public boolean endFormation(@PathVariable("piloteId") Long piloteId) throws PiloteNotFoundException {
        return piloteService.endFormation(piloteId);
    }

    @PutMapping("/affect-chasseur/{piloteId}")
    public Pilote affecterChasseur(@PathVariable("piloteId") Long piloteId, @RequestParam Long chasseurId) throws PiloteNotFoundException, ChasseurNotFoundException {
        return piloteService.affecterChasseur(piloteId, chasseurId);
    }

    @PutMapping("/desaffect-chasseur/{piloteId}")
    public Pilote desaffecterChasseur(@PathVariable("piloteId") Long piloteId) throws PiloteNotFoundException {
        return piloteService.desaffecterChasseur(piloteId);
    }

    @PutMapping("/update/{piloteId}")
    public Pilote updatePilote(@PathVariable("piloteId") Long piloteId, @RequestParam double heures, @RequestParam Sante sante) throws PiloteNotFoundException {
        return piloteService.updatePilote(piloteId, heures, sante);
    }
}
