package org.sid.services;

import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.EtatChasseur;
import org.sid.exceptions.ChasseurNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ChasseurService {
    List<Chasseur> listChasseurs();

    void saveChasseur(Chasseur chasseur);

    void deleteChasseur(Long chasseurId) throws ChasseurNotFoundException;

    @Transactional
    void updateChasseur(Long chasseurId, EtatChasseur etatChasseur, Pilote pilote) throws ChasseurNotFoundException;
}
