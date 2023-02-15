package org.sid.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.sid.enums.EtatChasseur;
import org.sid.enums.TypeChasseur;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chasseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeChasseur typeChasseur;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EtatChasseur etatChasseur;

    private Long piloteId = null;

    public Chasseur(String name, TypeChasseur typeChasseur, EtatChasseur etatChasseur) {
	this.name = name;
	this.typeChasseur = typeChasseur;
	this.etatChasseur = etatChasseur;
    }

    public boolean hasPilote() {
        return piloteId != null;
    }

    public boolean isOperationnal() {
	return this.etatChasseur == EtatChasseur.OPERATIONNEL;
    }

    public boolean isMissionReady() {
        return (hasPilote() && isOperationnal());
    }

    public boolean isAvailable() {
        return (!hasPilote() && isOperationnal());
    }

    @Override
    public String toString() {
        return "Chasseur{" +
                "name='" + name + '\'' +
                ", typeChasseur=" + typeChasseur +
                '}';
    }
}
