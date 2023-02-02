package org.sid.entities;

import org.sid.enums.Race;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Rebelle {
    @Id
    @SequenceGenerator(name = "rebelle_generator", sequenceName = "rebelle_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "rebelle_generator")
    @Column(name = "id_rebelle")
    private Long id;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Race race;

    @Column(nullable = false)
    @Min(10)
    @Max(800)
    private int age;

    @Column(nullable = false)
    private boolean enFormation;

    public Rebelle() {
    }

    public Rebelle(String prenom, String nom, Race race, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.race = race;
        this.age = age;
        this.enFormation = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public Race getRace() {
        return race;
    }

    public int getAge() {
        return age;
    }

    public boolean isEnFormation() {
        return enFormation;
    }

    public void setEnFormation(boolean enFormation) {
        this.enFormation = enFormation;
    }
}
