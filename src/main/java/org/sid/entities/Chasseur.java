package org.sid.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.sid.enums.EtatChasseur;
import org.sid.enums.TypeChasseur;

@Entity
@Table
public class Chasseur {
    @Id
    @SequenceGenerator(name = "chasseur_generator", sequenceName = "chasseur_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "chasseur_generator")
    @Column(name = "id_chasseur", updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeChasseur typeChasseur;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EtatChasseur etatChasseur;

    @OneToOne(cascade = CascadeType.ALL)
    private Pilote pilote;

    public Chasseur() {
    }

    public Chasseur(String name, TypeChasseur typeChasseur, EtatChasseur etatChasseur) {
	this.name = name;
	this.typeChasseur = typeChasseur;
	this.etatChasseur = etatChasseur;
    }

    public EtatChasseur getEtatChasseur() {
	return etatChasseur;
    }

    public void setEtatChasseur(EtatChasseur etatChasseur) {
	this.etatChasseur = etatChasseur;
    }

    public Pilote getPilote() {
	return pilote;
    }

    public void setPilote(Pilote pilote) {
	this.pilote = pilote;
    }

    public Long getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public TypeChasseur getTypeChasseur() {
	return typeChasseur;
    }

    public boolean getDispo() {
	return this.etatChasseur == EtatChasseur.OPERATIONNEL;
    }

    @Override
    public String toString() {
        return "Chasseur{" +
                "name='" + name + '\'' +
                ", typeChasseur=" + typeChasseur +
                '}';
    }
}
