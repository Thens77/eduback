package ma.emsi.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Client;
import ma.emsi.edu.model.Formateur;
import ma.emsi.edu.repository.FormateurRepository;

@Service
@Transactional
public class FormateurServiceImpl implements FormateurService {
 private FormateurRepository formateurRepository;
 public FormateurServiceImpl(FormateurRepository formateurRepository) {
	 this.formateurRepository=formateurRepository;
 }
	@Override
	public void ajouter(Formateur formateur) {
		// TODO Auto-generated method stub
		formateurRepository.save(formateur);
	}

	@Override
	public void modifier(Formateur formateur,Long id) {
		// TODO Auto-generated method stub
		Formateur formateur1 =formateurRepository.getById(id);
        if (formateur1 != null){
        	formateur1.setAge(formateur.getAge());
        	formateur1.setCin(formateur.getCin());
        	formateur1.setEmail(formateur.getEmail());
        	formateur1.setNom(formateur.getNom());
        	formateur1.setDernierPaiement(formateur.getDernierPaiement());
        	formateur1.setSalaire(formateur.getSalaire());
        	formateur1.setPassword(formateur.getPassword());
        	formateur1.setPrenom(formateur.getPassword());
        	formateur1.setRoles(formateur.getRoles());
        	formateur1.setUserName(formateur.getUserName());
        	
        	
        	
        	formateurRepository.save(formateur1);
        }
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		formateurRepository.deleteById(id);
	}

	@Override
	public Formateur getFormateur(Long id) {
		// TODO Auto-generated method stub
		return formateurRepository.findById(id).get();
	}

	@Override
	public List<Formateur> liste() {
		// TODO Auto-generated method stub
		return formateurRepository.findAll();
	}
	

}
