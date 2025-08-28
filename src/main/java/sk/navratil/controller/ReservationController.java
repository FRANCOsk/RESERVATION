package sk.navratil.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.navratil.entity.Reservation;
import sk.navratil.service.ReservationService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Long id, @RequestBody LocalDateTime start, @RequestBody LocalDateTime end) {

        Reservation reservation = reservationService.createReservation(id,start,end);
        if (reservation == null) {

            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        else return new ResponseEntity<>(reservation, HttpStatus.OK);

    }

}
