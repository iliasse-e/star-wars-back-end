package org.sid.services;

import org.jetbrains.annotations.NotNull;
import org.sid.dao.ChasseurRepository;
import org.sid.dao.PiloteRepository;
import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.Sante;
import org.sid.exceptions.ChasseurNotFoundException;
import org.sid.exceptions.MissionNotFoundException;
import org.sid.exceptions.PiloteNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PiloteServiceImpl implements PiloteService {

	private final PiloteRepository piloteRepository;
	private final ChasseurRepository chasseurRepository;

	private final MissionService missionService;

	public PiloteServiceImpl(PiloteRepository piloteRepository, ChasseurRepository chasseurRepository, MissionService missionService) {
		this.piloteRepository = piloteRepository;
		this.chasseurRepository = chasseurRepository;
		this.missionService = missionService;
	}

	@Override
	public Pilote createPilote(Pilote pilote) {
		return piloteRepository.save(pilote);

	}
	@Override
	public List<Pilote> listPilote() {
		return piloteRepository.findByEnFormationFalse();
	}

	@Override
	public Pilote getPilote(Long piloteId) throws PiloteNotFoundException {
		Pilote currentPilote = piloteRepository.findById(piloteId)
				.orElseThrow(()-> new PiloteNotFoundException("Pilote inconnue"));
		return currentPilote;
	}

	@Override
	public List<Pilote> getPilotesByIds(List<Long> piloteIds) {
		return piloteRepository.findAllById(piloteIds);
	}

	public Pilote goMission(@NotNull Pilote pilote, String missionName) throws MissionNotFoundException {
		pilote.setMissionActuelle(missionService.getMission(missionName));
		return piloteRepository.save(pilote);
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
	public List<Pilote> getPilotesEnFormation() {
		return piloteRepository.findByEnFormationTrue();
	}

	@Override
	public List<Pilote> getPilotesDispo() {
		return piloteRepository.findByChasseurNull();
	}

	@Override
	public List<Pilote> getPilotesMissionReady() {
		return piloteRepository.findBySanteAndEnFormationFalseAndMissionActuelleIsNullAndChasseurIsNotNull(Sante.FORME);
	}

	@Override
	public List<Pilote> getPilotesHasChasseur() {
		return piloteRepository.findByChasseurNotNull();
	}

	@Override
	public boolean endFormation(Long piloteId) throws PiloteNotFoundException {
		Pilote pilote = piloteRepository.findById(piloteId)
				.orElseThrow(() -> new PiloteNotFoundException("No pilots with this id found"));
		pilote.setEnFormation(false);
		return true;
	}

	@Override
	public Pilote affecterChasseur(Long piloteId, Long chasseurId) throws PiloteNotFoundException, ChasseurNotFoundException {
		Pilote pilote = piloteRepository.findById(piloteId)
				.orElseThrow(() -> new PiloteNotFoundException("No pilots with this id found"));
		Chasseur chasseur = chasseurRepository.findById(chasseurId)
				.orElseThrow(() -> new ChasseurNotFoundException("No ship with this id found"));
		pilote.setChasseur(chasseur);
		chasseur.setPiloteId(pilote.getId());
		return pilote;
	}

	@Override
	@Transactional
	public Pilote desaffecterChasseur(Long piloteId) throws PiloteNotFoundException, ChasseurNotFoundException {
		Pilote pilote = piloteRepository.findById(piloteId)
				.orElseThrow(() -> new PiloteNotFoundException("No pilots with this id found"));
		Chasseur chasseur = chasseurRepository.findById(pilote.getChasseur().getPiloteId())
				.orElseThrow(() -> new ChasseurNotFoundException("No chasseur with this id found"));
		pilote.setChasseur(null);
		chasseur.setPiloteId(null);
		return pilote;
	}

	@Override
	public Pilote updatePilote(Long piloteId, double heures, Sante sante) throws PiloteNotFoundException {
		Pilote pilote = piloteRepository.findById(piloteId)
				.orElseThrow(() -> new PiloteNotFoundException("No pilots with this id found"));
		pilote.setSante(sante);
		pilote.setNbMission(pilote.getNbMission() + 1);
		pilote.setMissionActuelle(null);
		pilote.setHeureDeVol(pilote.getHeureDeVol() + heures);
		return pilote;
	}

	@Override
	public Pilote endMission(Long id, double heures) {
		Pilote currentPilote = piloteRepository.findById(id).get();
		currentPilote.setHeureDeVol(currentPilote.getHeureDeVol() + heures);
		currentPilote.setNbMission(currentPilote.getNbMission() + 1);
		currentPilote.setMissionActuelle(null);
		piloteRepository.save(currentPilote);
		return currentPilote;
	}
}
