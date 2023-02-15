package org.sid.services;

import org.jetbrains.annotations.NotNull;
import org.sid.dao.ChasseurRepository;
import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.EtatChasseur;
import org.sid.exceptions.ChasseurNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ChasseurServiceImpl implements ChasseurService {

    private final ChasseurRepository chasseurRepository;

    public ChasseurServiceImpl(ChasseurRepository chasseurRepository) {
        this.chasseurRepository = chasseurRepository;
    }

    @Override
    public List<Chasseur> listChasseurs() {
        return chasseurRepository.findAll();
    }

    @Override
    public List<Chasseur> getChasseursDispo() {
        return chasseurRepository.findAll().stream().filter(chasseur -> chasseur.isAvailable()).collect(Collectors.toList());
    }

    @Override
    public List<Chasseur> getChasseursAvecPilotes() {
        return chasseurRepository.findAll().stream().filter(chasseur -> chasseur.hasPilote()).collect(Collectors.toList());
    }

    public List<Chasseur> getChasseursPretPourMission() {
        return chasseurRepository.findAll().stream().filter(chasseur -> chasseur.isMissionReady()).collect(Collectors.toList());
    }

    @Override
    public Chasseur createChasseur(@NotNull Chasseur chasseur) {
        Optional<Chasseur> chasseurOptional = chasseurRepository.findChasseurByName(chasseur.getName());
        if (chasseurOptional.isPresent()) {
            throw new IllegalStateException("Ship is already in the database");
        }
        return chasseurRepository.save(chasseur);
    }

    @Override
    public boolean deleteChasseur(Long chasseurId) throws ChasseurNotFoundException {
        if (chasseurRepository.findById(chasseurId).isEmpty()) {
            throw new ChasseurNotFoundException("No ship with this id found");
        }
        chasseurRepository.deleteById(chasseurId);
        return true;
    }

    @Override
    public Chasseur updateChasseur(Long chasseurId, EtatChasseur etatChasseur, Pilote pilote) throws ChasseurNotFoundException {
        Chasseur chasseur = chasseurRepository.findById(chasseurId)
                .orElseThrow(() -> new ChasseurNotFoundException("No ship with this id found"));

        if (etatChasseur != null && chasseur.getEtatChasseur() != etatChasseur) {
            chasseur.setEtatChasseur(etatChasseur);
        }
        if (pilote != null && !Objects.equals(chasseur.getPiloteId(), pilote.getId())) {
            chasseur.setPiloteId(pilote.getId());
        }

        return chasseur;
    }
}
