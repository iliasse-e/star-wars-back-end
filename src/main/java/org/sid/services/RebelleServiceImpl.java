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
}
