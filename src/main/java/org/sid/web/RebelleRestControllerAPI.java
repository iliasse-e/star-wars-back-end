package org.sid.web;

import org.sid.entities.Rebelle;
import org.sid.exceptions.RebelleNotFoundException;
import org.sid.services.RebelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rebelles")
public class RebelleRestControllerAPI {
    @Autowired
    private RebelleService rebelleService;

    public RebelleService getRebelleService() {
        return rebelleService;
    }

    public void setRebelleService(RebelleService rebelleService) {
        this.rebelleService = rebelleService;
    }

    @PostMapping
    public Rebelle create(@RequestBody Rebelle rebelle) {
        return rebelleService.saveRebelle(rebelle);
    }

    @GetMapping
    public Iterable<Rebelle> rebeles() {
        return rebelleService.listRebelle();
    }

    @GetMapping("/rebelles/{id}")
    public Rebelle get(@PathVariable("id") Long rebelleId) throws RebelleNotFoundException {
        return rebelleService.getRebelle(rebelleId);
    }
}
