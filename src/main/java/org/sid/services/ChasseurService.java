package org.sid.services;

import java.util.List;

import org.sid.entities.Chasseur;

public interface ChasseurService {
	List<Chasseur> listChasseurs();

	void saveChasseur(Chasseur chasseur);
}
