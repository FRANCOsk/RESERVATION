package sk.navratil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sk.navratil.entity.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.room_id = :room_Id AND " +
            "(:start < r.end AND :end > r.start)")
    List<Reservation> findConflictingReservations(@Param("room_Id") Long room_Id,
                                                  @Param("start") LocalDateTime start,
                                                  @Param("end") LocalDateTime end);

}
