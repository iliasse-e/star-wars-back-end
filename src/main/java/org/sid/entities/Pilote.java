package org.sid.entities;


import org.sid.enums.Grade;
import org.sid.enums.Sante;

import javax.persistence.*;

@Entity
@Table
public class Pilote extends Rebelle {
    //------------------------------------------------------
    // ATTRIBUTS
    //------------------------------------------------------
    @Id
    @SequenceGenerator(name = "pilote_generator", sequenceName = "pilote_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pilote_generator")
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private Grade grade;

    private double heureDeVol;
    private int nbMission;

    @Column(nullable = false)
    private Sante sante;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_chasseur")
    private Chasseur chasseur;

    @ManyToOne
    @JoinColumn(name = "id_mission")
    private Mission missionActuelle;

    /*public Pilote(
            String _prenom, String _nom, Race _race, int _age,
            Grade _grade, double _heureDeVol,
            int _nbMission, Sante _sante, Chasseur _chasseur,
            Mission _missionActuelle) {
        super(null, _prenom, _nom, _race, _age, true);
        grade = _grade;
        heureDeVol = _heureDeVol;
        nbMission = _nbMission;
        sante = _sante;
        chasseur = _chasseur;
        missionActuelle = _missionActuelle;
    }*/
    //------------------------------------------------------
    // CONSTRUCTEURS
    //------------------------------------------------------

	/*public Pilote(
        String _prenom, String _nom, Race _race, int _age,
        Grade _grade, double _heureDeVol,
        int _nbMission, Sante _sante, Chasseur _chasseur,
        Mission _missionActuelle) {
    super(null, _prenom, _nom, _race, _age, true);
    grade = _grade;
    heureDeVol = _heureDeVol;
    nbMission = _nbMission;
    sante = _sante;
    chasseur = _chasseur;
    missionActuelle = _missionActuelle;
}*/
    //------------------------------------------------------
    // METHODES
    //------------------------------------------------------

    public boolean getDispo() {
        return true;
    }

    //------------------------------------------------------
    // GETTER & SETTER
    //------------------------------------------------------

    public Grade getGrade() {
        return grade;
    }

    public double getHeureDeVol() {
        return heureDeVol;
    }

    public void setHeureDeVol(double heureDeVol) {
        this.heureDeVol = heureDeVol;
    }

    public int getNbMission() {
        return nbMission;
    }

    public void setNbMission(int nbMission) {
        this.nbMission = nbMission;
    }

    public Sante getSante() {
        return sante;
    }

    public void setSante(Sante sante) {
        this.sante = sante;
    }

    public Chasseur getChasseur() {
        return chasseur;
    }

    public void setChasseur(Chasseur chasseur) {
        this.chasseur = chasseur;
    }

    public Mission getMissionActuelle() {
        return missionActuelle;
    }

    public void setMissionActuelle(Mission missionActuelle) {
        this.missionActuelle = missionActuelle;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
