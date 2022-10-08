package ma.emsi.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.emsi.edu.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation , Long> {

}
