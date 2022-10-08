package ma.emsi.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Client;
import ma.emsi.edu.repository.ClientRepository;
@Service
@Transactional
public class ClientServiceImpl implements ClientService {
	 private ClientRepository clientRepository;
	 
	 public ClientServiceImpl(ClientRepository clientRepository) {
	        this.clientRepository = clientRepository;
	    }
	@Override
	public void ajouter(Client client) {
		// TODO Auto-generated method stub
		clientRepository.save(client);
	}

	@Override
	public void modifier(Client client,Long id) {
		// TODO Auto-generated method stub
		Client client1 = clientRepository.getById(id);
        if (client1 != null){
        	client1.setAge(client.getAge());
        	client1.setCin(client.getCin());
        	client1.setEmail(client.getEmail());
        	client1.setNom(client.getNom());
        	client1.setActive(client.isActive());
        	client1.setPassword(client.getPassword());
        	client1.setPrenom(client.getPassword());
        	client1.setRoles(client.getRoles());
        	client1.setUserName(client.getUserName());
        	
        	
        	
        	clientRepository.save(client1);
        }
		
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);
	}

	@Override
	public Client getClient(Long id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(id).get();
	}

	@Override
	public List<Client> liste() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

}
