package ma.emsi.edu.restContoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.edu.model.Client;
import ma.emsi.edu.service.ClientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/client")
public class ClientContoller {
	@Autowired
	ClientService clientService;
	@PostMapping
	public void ajouter(@RequestBody Client client) {
		clientService.ajouter(client);
	}

	@GetMapping
	public List<Client> liste() {
		return clientService.liste();
	}

	@GetMapping("/{id}")
	public Client getById(@PathVariable Long id) {
		return clientService.getClient(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		clientService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Client client ) {
		clientService.modifier(client,id);
    }

	
}
