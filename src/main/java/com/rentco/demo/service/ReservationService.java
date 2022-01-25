package com.rentco.demo.service;

import com.rentco.demo.command.ReservationCommand;
import com.rentco.demo.dto.ReservationDto;
import com.rentco.demo.model.RentRoomModel;
import com.rentco.demo.model.ReservationModel;
import com.rentco.demo.model.TenantModel;
import com.rentco.demo.repository.RentRoomRepository;
import com.rentco.demo.repository.ReservationRepository;
import com.rentco.demo.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final TenantRepository tenantRepository;
    private final RentRoomRepository rentRoomRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, TenantRepository tenantRepository,
                              RentRoomRepository rentRoomRepository) {
        this.reservationRepository = reservationRepository;
        this.tenantRepository = tenantRepository;
        this.rentRoomRepository = rentRoomRepository;
    }

    public ResponseEntity<?> changeReservation(ReservationCommand command) {
        Optional<ReservationModel> optionalReservation = reservationRepository.findById(command.getId());
        Optional<RentRoomModel> room = rentRoomRepository.findById(command.getRentroomId());
        if (!optionalReservation.isPresent()) {
            return new ResponseEntity<>("Reservation was not Found", HttpStatus.NOT_FOUND);
        }
        if (isRoomTaken(command.getDateFrom(), command.getDateTo(), command.getRentroomId())) {
            return new ResponseEntity<>("Can't reserve in given date", HttpStatus.NOT_ACCEPTABLE);
        }
        if (!room.isPresent()) {
            return new ResponseEntity<>("Room does not exist", HttpStatus.NOT_FOUND);
        }
        ReservationModel reservation = optionalReservation.get();
        if (!Objects.equals(reservation.getTenant().getId(), command.getTenantId())) {
            return new ResponseEntity<>("You can't change someone else reservation", HttpStatus.UNAUTHORIZED);
        }
        reservation.setDateFrom(command.getDateFrom());
        reservation.setDateTo(command.getDateTo());
        float price = ((float) (command.getDateTo().toLocalDate().getDayOfYear()
                - command.getDateFrom().toLocalDate().getDayOfYear()) * room.get().getPrice());
        reservation.setPrice(price);
        reservationRepository.save(reservation);
        ReservationDto reservationDto = new ReservationDto(reservation);
        return new ResponseEntity<>(reservationDto, HttpStatus.OK);
    }

    public ResponseEntity<?> setReservation(ReservationCommand command) {
        Optional<TenantModel> tenant = tenantRepository.findById(command.getTenantId());
        Optional<RentRoomModel> room = rentRoomRepository.findById(command.getRentroomId());
        if (isRoomTaken(command.getDateFrom(), command.getDateTo(), command.getRentroomId())) {
            return new ResponseEntity<>("Room is already taken", HttpStatus.NOT_ACCEPTABLE);
        }
        if (!tenant.isPresent()) {
            return new ResponseEntity<>("Tenant does not exist", HttpStatus.NOT_FOUND);
        }
        if (!room.isPresent()) {
            return new ResponseEntity<>("Room does not exist", HttpStatus.NOT_FOUND);
        }
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setTenant(tenant.get());
        reservationModel.setLandlord(command.getLandlordId());
        reservationModel.setRentRoom(room.get());
        reservationModel.setDateFrom(command.getDateFrom());
        reservationModel.setDateTo(command.getDateTo());
        float price = ((float) (command.getDateTo().toLocalDate().getDayOfYear()
                - command.getDateFrom().toLocalDate().getDayOfYear()) * room.get().getPrice());
        reservationModel.setPrice(price);
        reservationModel = reservationRepository.save(reservationModel);
        ReservationDto reservation = new ReservationDto(reservationModel);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    private boolean isRoomTaken(Date dateFrom, Date dateTo, Integer rentroomId) {
        return (reservationRepository.findIfRoomTaken(dateFrom, rentroomId).isPresent()
                && reservationRepository.findIfRoomTaken(dateTo, rentroomId).isPresent());
    }

    public ResponseEntity<?> getReservationOfRoom(Integer roomId) {
        Optional<List<ReservationModel>> room = reservationRepository.findAllReservationByRentRoomId(roomId);
        Optional<RentRoomModel> roomOptional = rentRoomRepository.findById(roomId);
        if (!room.isPresent() || !roomOptional.isPresent()) {
            return new ResponseEntity<>("Room does not have any reservation", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(getListOfReservation(room.get()), HttpStatus.OK);
    }

    public ResponseEntity<?> getReservationOfGivenNames(String tenantName) {
        Optional<List<ReservationModel>> room = reservationRepository.findAllReservationByTenantName(tenantName);
        if (!room.isPresent()) {
            return new ResponseEntity<>("Tenant does not have any reservation ", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(getListOfReservation(room.get()), HttpStatus.OK);
    }

    private List<ReservationDto> getListOfReservation(List<ReservationModel> listReservation) {
        List<ReservationDto> reservationDtoList = new java.util.ArrayList<>(Collections.emptyList());

        listReservation.forEach(reservation -> {
            reservationDtoList.add(new ReservationDto(reservation));
        });
        return reservationDtoList;
    }
}
