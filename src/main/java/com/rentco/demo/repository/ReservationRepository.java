package com.rentco.demo.repository;

import com.rentco.demo.model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM RESERVATION INNER JOIN RENT_ROOM ON RESERVATION.RENT_ROOM_ID = RENT_ROOM.ID WHERE RENT_ROOM.ID= ?1")
    Optional<List<ReservationModel>> findAllReservationByRentRoomId(Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM RESERVATION ")
    List<ReservationModel> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM RESERVATION INNER JOIN TENANT ON RESERVATION.TENANT_ID = TENANT.ID WHERE TENANT.NAME=?1")
    Optional<List<ReservationModel>> findAllReservationByTenantName(String tenantName);

    @Query(nativeQuery = true, value = "SELECT * FROM RESERVATION WHERE RESERVATION.RENT_ROOM_ID=?2 AND (DATE_FROM<= ?1 AND DATE_TO >= ?1) LIMIT 1")
    Optional<ReservationModel> findIfRoomTaken(Date date, Integer roomId);

}
