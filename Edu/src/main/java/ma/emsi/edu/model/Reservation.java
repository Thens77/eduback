package ma.emsi.edu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id  ;
	@ManyToOne
    @JoinColumn(name = "salle_id", referencedColumnName = "id")
	private Salle salle ;
	@ManyToOne
    @JoinColumn(name = "creneau_id", referencedColumnName = "id")
	private Creneau creneau ;
	@ManyToOne
    @JoinColumn(name = "matiere_id", referencedColumnName = "id")
	private Matiere matiere ;
	@ManyToOne
    @JoinColumn(name = "formatteur_id", referencedColumnName = "id")
	private Formateur formateur ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Creneau getCreneau() {
		return creneau;
	}
	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", salle=" + salle + ", creneau=" + creneau + ", matiere=" + matiere
				+ ", formateur=" + formateur + "]";
	}
	
	
	

}
