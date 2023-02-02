package org.sid.services;

import org.sid.dao.PiloteRepository;
import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.exceptions.PiloteNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class PiloteServiceImpl implements PiloteService {

	private final PiloteRepository piloteRepository;

	public PiloteServiceImpl(PiloteRepository piloteRepository) {
		this.piloteRepository = piloteRepository;
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
	public Pilote affecterChasseur(Long piloteId, Chasseur chasseur) throws PiloteNotFoundException {
		Pilote pilote = piloteRepository.findById(piloteId)
				.orElseThrow(() -> new PiloteNotFoundException("No pilots with this id found"));

		pilote.setChasseur(chasseur);
		return pilote;
	}
}
