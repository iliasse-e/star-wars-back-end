package org.sid.services;

import java.util.List;

import org.sid.dao.ChasseurRepository;
import org.sid.entities.Chasseur;
import org.springframework.stereotype.Service;

@Service
public class ChasseurService {

    private final ChasseurRepository chasseurRepository;

    public ChasseurService(ChasseurRepository chasseurRepository) {
	this.chasseurRepository = chasseurRepository;
    }

    public List<Chasseur> getChasseurs() {
	return chasseurRepository.findAll();
    }
}
