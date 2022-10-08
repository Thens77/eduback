package ma.emsi.edu.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class Formateur extends Utilisateur{
	
	private double salaire ;
	private Date dernierPaiement ;
	
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public Date getDernierPaiement() {
		return dernierPaiement;
	}
	public void setDernierPaiement(Date dernierPaiement) {
		this.dernierPaiement = dernierPaiement;
	}
	@Override
	public String toString() {
		return "Formateur [salaire=" + salaire + ", dernierPaiement=" + dernierPaiement + "]";
	}
	
	

}
