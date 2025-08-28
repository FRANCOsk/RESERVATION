package sk.navratil.service;

import org.springframework.stereotype.Service;
import sk.navratil.entity.Reservation;
import sk.navratil.repository.ReservationRepository;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(Long id, LocalDateTime start, LocalDateTime end) {

        List<Reservation> conflicts = reservationRepository.findConflictingReservations(id, start, end);
        if (!conflicts.isEmpty()) {

            return null;
        }

        Reservation reservation = new Reservation();

        reservation.setId(id);
        reservation.setStart(start);
        reservation.setEnd(end);

        return reservationRepository.save(reservation);

    }

}
