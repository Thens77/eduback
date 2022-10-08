package ma.emsi.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.edu.model.Panier;
import ma.emsi.edu.model.Reservation;
import ma.emsi.edu.repository.PanierRepository;
import ma.emsi.edu.repository.ReservationRepository;
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	private ReservationRepository reservationRepository;
	
	
	
	public ReservationServiceImpl(ReservationRepository reservationRepository) {
		this.reservationRepository=reservationRepository;
		
		
	}
	
	@Override
	public void ajouter(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationRepository.save(reservation);
	}

	@Override
	public void modifier(Reservation reservation, Long id) {
		// TODO Auto-generated method stub
		Reservation reservation2 = reservationRepository.getById(id);
		if(reservation2!=null) {
			reservation2.setCreneau(reservation.getCreneau());
			reservation2.setFormateur(reservation.getFormateur());
			reservation2.setMatiere(reservation.getMatiere());
			reservation2.setSalle(reservation.getSalle());
		        reservationRepository.save(reservation2);
		}
	}

	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		reservationRepository.deleteById(id);
		
	}

	@Override
	public Reservation getReservation(Long id) {
		// TODO Auto-generated method stub
		return reservationRepository.findById(id).get();
	}

	@Override
	public List<Reservation> liste() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}

}
