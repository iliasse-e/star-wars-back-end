package org.sid.services;

import java.util.List;

import org.sid.dao.ChasseurRepository;
import org.sid.entities.Chasseur;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Transactional
public class ChasseurServiceImpl implements ChasseurService {
	private final ChasseurRepository chasseurRepository;

	public ChasseurServiceImpl(ChasseurRepository chasseurRepository) {
		this.chasseurRepository = chasseurRepository;
	}

	@Override
	@GetMapping("/chasseurs")
	public List<Chasseur> listChasseurs() {
		return chasseurRepository.findAll();
	}

	@Override
	public void saveChasseur(Chasseur chasseur) {
		chasseurRepository.save(chasseur);
	}
}
