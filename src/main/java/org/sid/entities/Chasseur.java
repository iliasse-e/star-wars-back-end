package org.sid.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.sid.enums.EtatChasseur;
import org.sid.enums.TypeChasseur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chasseur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_chasseur")
	private Long id;

	private String name;

	@Enumerated(EnumType.STRING)
	private TypeChasseur typeChasseur;

	@Enumerated(EnumType.STRING)
	private EtatChasseur etatChasseur;

	@JoinColumn(name = "id_pilote")
	@OneToOne
	private Pilote pilote;

	public Chasseur(String name, TypeChasseur typeChasseur, EtatChasseur etatChasseur) {
		super();
		this.name = name;
		this.typeChasseur = typeChasseur;
		this.etatChasseur = etatChasseur;
	}

	public boolean getDispo() {
		return this.etatChasseur == EtatChasseur.OPERATIONNEL;
	}
}
