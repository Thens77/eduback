package ma.emsi.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Creneau;
import ma.emsi.edu.repository.AbsenceRepository;
import ma.emsi.edu.repository.CreneauRepository;

@Service
@Transactional
public class CreneauServiceImpl implements CreneauService {
	private CreneauRepository creneauRepository;
	public CreneauServiceImpl(CreneauRepository creneauRepository) {
        this.creneauRepository = creneauRepository;
    }
	@Override
	public void ajouter(Creneau creneau) {
		// TODO Auto-generated method stub
		creneauRepository.save(creneau);
	}

	@Override
	public void modifier(Creneau creneau,Long id) {
		// TODO Auto-generated method stub
		Creneau creneau2 = creneauRepository.getById(id);
		if(creneau2!=null) {
			creneau2.setHeureDebut(creneau.getHeureDebut());
			creneau2.setHeureFin(creneau.getHeureFin());
			creneauRepository.save(creneau2);
		}
		
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		creneauRepository.deleteById(id);
		
	}

	@Override
	public Creneau getCreneau(Long id) {
		// TODO Auto-generated method stub
		return creneauRepository.findById(id).get();
	}

	@Override
	public List<Creneau> liste() {
		// TODO Auto-generated method stub
		return creneauRepository.findAll();
	}
	

}
