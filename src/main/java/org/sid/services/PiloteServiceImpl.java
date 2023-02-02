package org.sid.services;

import org.sid.dao.ChasseurRepository;
import org.sid.dao.PiloteRepository;
import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.Sante;
import org.sid.exceptions.ChasseurNotFoundException;
import org.sid.exceptions.PiloteNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class PiloteServiceImpl implements PiloteService {

	private final PiloteRepository piloteRepository;
	private final ChasseurRepository chasseurRepository;

	public PiloteServiceImpl(PiloteRepository piloteRepository, ChasseurRepository chasseurRepository) {
		this.piloteRepository = piloteRepository;
		this.chasseurRepository = chasseurRepository;
	}

	@Override
	public Pilote savePilote(Pilote pilote) {
		return piloteRepository.save(pilote);

	}
	@Override
	public List<Pilote> listPilote() {
		return (List<Pilote>) piloteRepository.findAll().stream().filter(pilote -> pilote.isEnFormation() == false).collect(Collectors.toList());
	}

	@Override
	public Pilote getPilote(Long piloteId) throws PiloteNotFoundException {
		Pilote currentPilote = piloteRepository.findById(piloteId)
				.orElseThrow(()-> new PiloteNotFoundException("Pilote inconnue"));
		return currentPilote;
	}
	@Override
	public boolean deletePilote(Long piloteId) throws PiloteNotFoundException {
		if (piloteRepository.findById(piloteId).isEmpty()) {
			throw new PiloteNotFoundException("No pilots with this id found");
		}
		piloteRepository.deleteById(piloteId);
		return true;
	}

	@Override
	public List<Pilote> getPiloteDispo() {
		return (List<Pilote>) piloteRepository.findAll().stream().filter(pilote -> pilote.getDispo()).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public Pilote affecterChasseur(Long piloteId, Long chasseurId) throws PiloteNotFoundException, ChasseurNotFoundException {
		Pilote pilote = piloteRepository.findById(piloteId)
				.orElseThrow(() -> new PiloteNotFoundException("No pilots with this id found"));
		Chasseur chasseur = chasseurRepository.findById(chasseurId)
				.orElseThrow(() -> new ChasseurNotFoundException("No ship with this id found"));
		pilote.setChasseur(chasseur);
		chasseur.setPilote(pilote);
		return pilote;
	}

	@Override
	@Transactional
	public Pilote desaffecterChasseur(Long piloteId) throws PiloteNotFoundException {
		Pilote pilote = piloteRepository.findById(piloteId)
				.orElseThrow(() -> new PiloteNotFoundException("No pilots with this id found"));
		pilote.getChasseur().setPilote(null);
		pilote.setChasseur();

		return pilote;
	}

	@Override
	@Transactional
	public Pilote updatePilote(Long piloteId, double heures, Sante sante) throws PiloteNotFoundException {
		Pilote pilote = piloteRepository.findById(piloteId)
				.orElseThrow(() -> new PiloteNotFoundException("No pilots with this id found"));
		pilote.setSante(sante);
		pilote.setNbMission(pilote.getNbMission() + 1);
		pilote.setMissionActuelle(null);
		pilote.setHeureDeVol(pilote.getHeureDeVol() + heures);
		return pilote;
	}
}
