package org.sid.services;

import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.EtatChasseur;

import java.util.List;

public interface ChasseurService {
    List<Chasseur> getChasseurs();

    void addNewChasseur(Chasseur chasseur);

    void deleteChasseur(Long chasseurId);

    void updateChasseur(Long chasseurId, EtatChasseur etatChasseur, Pilote pilote);
}
