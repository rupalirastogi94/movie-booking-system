package me.project.movie.repository;

import me.project.movie.model.SeatBooked;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatBookedRepository extends JpaRepository<SeatBooked, Long> {
}
