package org.sid.services;

import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.Sante;
import org.sid.exceptions.PiloteNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PiloteService {
	Pilote savePilote(Pilote pilote);
	List<Pilote> listPilote();
	Pilote getPilote(Long piloteId) throws PiloteNotFoundException;

    boolean deletePilote(Long piloteId) throws PiloteNotFoundException;

    List<Pilote> getPiloteDispo();

    Pilote affecterChasseur(Long piloteId, Chasseur chasseur) throws PiloteNotFoundException;

    Pilote desaffecterChasseur(Long piloteId) throws PiloteNotFoundException;

    Pilote updatePilote(Long piloteId, double heures, Sante sante) throws PiloteNotFoundException;
}
