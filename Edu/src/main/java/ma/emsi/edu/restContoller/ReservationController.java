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

import ma.emsi.edu.model.Reservation;
import ma.emsi.edu.service.ReservationService;

@RestController
@RequestMapping("reservation")
public class ReservationController {
	@Autowired
	ReservationService reservationService;

	@PostMapping
	public void ajouter(@RequestBody Reservation reservation) {
		reservationService.ajouter(reservation);
	}

	@GetMapping
	public List<Reservation> liste() {
		return reservationService.liste();
	}

	@GetMapping("/{id}")
	public Reservation getById(@PathVariable Long id) {
		return reservationService.getReservation(id);
	}

	@GetMapping("/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		reservationService.supprimer(id);

	}
	
	@PutMapping("/{id}")
    public void modifier(@PathVariable(value = "id", required = false) final Long id, @RequestBody Reservation reservation ) {
		reservationService.modifier(reservation,id);
    }
}
