package com.rentco.demo.controller;

import com.rentco.demo.command.ReservationCommand;
import com.rentco.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("RoomReservation")
    public ResponseEntity<?> getReservationOfRoom(@RequestParam Integer roomId) {

        return reservationService.getReservationOfRoom(roomId);
    }

    @GetMapping("TenantReservation")
    public ResponseEntity<?> getReservationOfGivenName(@RequestParam String tenantName) {

        return reservationService.getReservationOfGivenNames(tenantName); //
    }

    @PutMapping("RoomReservation")
    public ResponseEntity<?> changeReservation(@RequestBody ReservationCommand command) {

        return reservationService.changeReservation(command);

    }

    @PostMapping("RoomReservation")
    public ResponseEntity<?> setReservation(@RequestBody ReservationCommand command) {

        return reservationService.setReservation(command);
    }

}
