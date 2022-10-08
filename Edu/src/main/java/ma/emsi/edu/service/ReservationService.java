package ma.emsi.edu.service;

import java.util.List;

import ma.emsi.edu.model.Reservation;

public interface ReservationService {
	
	void ajouter(Reservation reservation);

	void modifier(Reservation reservation, Long id );
	
	void supprimer(Long id);

	Reservation getReservation(Long id);
	
	List<Reservation> liste();
}
