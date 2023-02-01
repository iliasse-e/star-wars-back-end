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
    public List<Chasseur> getChasseurs() {
        return null;
    }

    @Override
    public List<Chasseur> getChasseursDispo() {
        return (List<Chasseur>) chasseurRepository.findAll().stream().filter(chasseur -> chasseur.getDispo()).collect(Collectors.toList());
    }

    @Override
    public List<Chasseur> getChasseursAvecPilotes() {
        return (List<Chasseur>) chasseurRepository.findAll().stream().filter(chasseur -> chasseur.getPilote() != null).collect(Collectors.toList());
    }

    public List<Chasseur> getChasseursPretPourMission() {
        List<Chasseur> chasseursDispos = chasseurRepository.findAll().stream().filter(chasseur -> chasseur.getDispo()).collect(Collectors.toList());
        return chasseursDispos.stream().filter(chasseur -> chasseur.getPilote() != null).collect(Collectors.toList());
    }

    @Override
    public void saveChasseur(@NotNull Chasseur chasseur) {
        Optional<Chasseur> chasseurOptional = chasseurRepository.findChasseurByName(chasseur.getName());
        if (chasseurOptional.isPresent()) {
            throw new IllegalStateException("Ship is already in the database");
        }
        chasseurRepository.save(chasseur);
    }

    @Override
    public void deleteChasseur(Long chasseurId) throws ChasseurNotFoundException {
        if (chasseurRepository.findById(chasseurId).isEmpty()) {
            throw new ChasseurNotFoundException("No ship with this id found");
        }
        chasseurRepository.deleteById(chasseurId);
    }

    @Override
    @Transactional
    public void updateChasseur(Long chasseurId, EtatChasseur etatChasseur, Pilote pilote) throws ChasseurNotFoundException {
        Chasseur chasseur = chasseurRepository.findById(chasseurId)
                .orElseThrow(() -> new ChasseurNotFoundException("No ship with this id found"));

        if (etatChasseur != null && chasseur.getEtatChasseur() != etatChasseur) {
            chasseur.setEtatChasseur(etatChasseur);
        }
        if (pilote != null && !Objects.equals(chasseur.getPilote().getId(), pilote.getId())) {
            chasseur.setPilote(pilote);
        }

    }

   /* @Override
    public void addNewChasseur(Chasseur chasseur) {

    } */
}
