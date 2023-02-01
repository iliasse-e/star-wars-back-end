package org.sid.services;

import org.sid.dao.RebelleRepository;
import org.sid.entities.Rebelle;
import org.sid.exceptions.RebelleNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RebelleServiceImpl implements RebelleService {
    private final RebelleRepository rebelleRepository;

    public RebelleServiceImpl(RebelleRepository rebelleRepository) {
        this.rebelleRepository = rebelleRepository;
    }

    @Override
    public Rebelle saveRebelle(Rebelle rebelle) {
        return rebelleRepository.save(rebelle);
    }

    @Override
    public List<Rebelle> listRebelle() {
        return rebelleRepository.findAll();
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

    /* @Override
    @Transactional
    public void updateRebelle(Long rebelleId, String nom, String prenom, Race race, int age)  throws RebelleNotFoundException {
        Rebelle rebelle = rebelleRepository.findById(rebelleId).orElseThrow(() -> new RebelleNotFoundException("No Rebelle with this id found"));

        if (nom != null && rebelle.getNom() != nom) {
            rebelle.set
        }
    } */
}
