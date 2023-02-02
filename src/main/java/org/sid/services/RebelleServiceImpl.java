package org.sid.services;

import org.sid.dao.PiloteRepository;
import org.sid.dao.RebelleRepository;
import org.sid.entities.Pilote;
import org.sid.entities.Rebelle;
import org.sid.enums.Sante;
import org.sid.exceptions.RebelleNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RebelleServiceImpl implements RebelleService {
    private final RebelleRepository rebelleRepository;
    private  PiloteRepository piloteRepository;
    public RebelleServiceImpl(RebelleRepository rebelleRepository) {
        this.rebelleRepository = rebelleRepository;
    }

    @Override
    public Rebelle saveRebelle(Rebelle rebelle) {
        return rebelleRepository.save(rebelle);
    }

    @Override
    public List<Rebelle> listRebelle() {
        return (List<Rebelle>)  rebelleRepository.findAll().stream().filter((rebelle -> rebelle.isEnFormation())).collect(Collectors.toList());
    }

    @Override
    public Rebelle getRebelle(Long rebelleId) throws RebelleNotFoundException {
        Rebelle currentRebelle = rebelleRepository.findById(rebelleId)
                .orElseThrow(() -> new RebelleNotFoundException("Rebelle inconnue"));
        return currentRebelle;
    }

    @Override
    public boolean deleteRebelle(long rebelleId) throws RebelleNotFoundException {
        if (rebelleRepository.findById(rebelleId).isEmpty()) {
            throw new RebelleNotFoundException("No rebelle with this id found");
        }
         rebelleRepository.deleteById(rebelleId);
        return true;
    }

    @Override
    @Transactional
    public Rebelle stopRebelleFormation(Long rebelleId)  throws RebelleNotFoundException {
        Rebelle rebelle = rebelleRepository.findById(rebelleId).orElseThrow(() -> new RebelleNotFoundException("No Rebelle with this id found"));
        // rebelle.setEnFormation(false);
        Pilote pilote = (Pilote) rebelle;
        pilote.setHeureDeVol(0);
        pilote.setNbMission(0);
        pilote.setSante(Sante.FORME);
        piloteRepository.save(pilote);
        // rebelleRepository.deleteById(rebelleId);
        return rebelle;
    }
    }
