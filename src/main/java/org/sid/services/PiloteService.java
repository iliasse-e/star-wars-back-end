package org.sid.services;

import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.Sante;
import org.sid.exceptions.ChasseurNotFoundException;
import org.sid.exceptions.MissionNotFoundException;
import org.sid.exceptions.PiloteNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PiloteService {
	Pilote createPilote(Pilote pilote);
	List<Pilote> listPilote();
	Pilote getPilote(Long piloteId) throws PiloteNotFoundException;
    List<Pilote> getPilotesByIds(List<Long> piloteIds);

    Pilote goMission(Pilote pilote, String missionName) throws PiloteNotFoundException, MissionNotFoundException;
    boolean deletePilote(Long piloteId) throws PiloteNotFoundException;
    List<Pilote> getPilotesEnFormation();
    List<Pilote> getPilotesDispo();
    List<Pilote> getPilotesMissionReady();
    List<Pilote> getPilotesHasChasseur();

    boolean endFormation(Long piloteId) throws PiloteNotFoundException;
    Pilote affecterChasseur(Long piloteId, Long chasseurId) throws PiloteNotFoundException, ChasseurNotFoundException;
    Pilote desaffecterChasseur(Long piloteId) throws PiloteNotFoundException, ChasseurNotFoundException;
    Pilote updatePilote(Long piloteId, double heures, Sante sante) throws PiloteNotFoundException;
    Pilote endMission(Long id, double heures);
}
