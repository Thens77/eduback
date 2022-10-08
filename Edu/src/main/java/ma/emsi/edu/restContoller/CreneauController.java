package ma.emsi.edu.restContoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.edu.model.Creneau;
import ma.emsi.edu.service.CreneauService;

@RestController
@RequestMapping("creneau")
public class CreneauController {
	@Autowired
	CreneauService creneauService;

	@PostMapping
	public void ajouter(@RequestBody Creneau creneau) {
		creneauService.ajouter(creneau);
	}

	@GetMapping
	public List<Creneau> liste() {
		return creneauService.liste();
	}

	@GetMapping("/{id}")
	public Creneau getById(@PathVariable Long id) {
		return creneauService.getCreneau(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		creneauService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Creneau creneau ) {
		creneauService.modifier(creneau,id);
    }
}
