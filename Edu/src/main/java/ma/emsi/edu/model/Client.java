package ma.emsi.edu.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Client extends Utilisateur {

	private boolean active = true ;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

	

	public Client(Long id, String userName, String password, String nom, String prenom, int age, String email,
			String cin, boolean isActive, boolean isNotLocked, String[] autorities, List<Role> roles) {
		super(id, userName, password, nom, prenom, age, email, cin, isActive, isNotLocked, autorities, roles);
		// TODO Auto-generated constructor stub
	}

	public Client(String userName, String password, String nom, String prenom, int age, String email, String cin,
			boolean isActive, boolean isNotLocked, List<Role> roles) {
		super(userName, password, nom, prenom, age, email, cin, isActive, isNotLocked, roles);
		this.active  =isActive;
	}

	@Override
	public String toString() {
		return "Client [active=" + active + "]";
	}
	
	
	
	
}
