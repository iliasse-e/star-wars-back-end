package org.sid.services;

import org.sid.entities.Pilote;
import org.sid.exceptions.PiloteNotFoundException;

import java.util.List;

public interface PiloteService {
	Pilote savePilote(Pilote pilote);
	List<Pilote> listPilote();
	Pilote getPilote(Long piloteId) throws PiloteNotFoundException;

    boolean deletePilote(Long piloteId) throws PiloteNotFoundException;

    List<Pilote> getPiloteDispo();
}
