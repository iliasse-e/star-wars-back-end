package org.sid.services;

import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.EtatChasseur;
import org.sid.exceptions.ChasseurNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ChasseurService {

    List<Chasseur> listChasseurs();
    List<Chasseur> getChasseursDispo();
    List<Chasseur> getChasseursAvecPilotes();
    List<Chasseur> getChasseursPretPourMission();
    Chasseur createChasseur(Chasseur chasseur);
    boolean deleteChasseur(Long chasseurId) throws ChasseurNotFoundException;
    Chasseur updateChasseur(Long chasseurId, EtatChasseur etatChasseur, Pilote pilote) throws ChasseurNotFoundException;

}
