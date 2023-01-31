package org.sid.services;

import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.EtatChasseur;

import java.util.List;

public interface ChasseurService {
    List<Chasseur> getChasseurs();
    List<Chasseur> getChasseursDispo();
    List<Chasseur> getChasseursAvecPilotes();

    List<Chasseur> getChasseursPretPourMission();

    void addNewChasseur(Chasseur chasseur);

    void deleteChasseur(Long chasseurId);

    void updateChasseur(Long chasseurId, EtatChasseur etatChasseur, Pilote pilote);
}
