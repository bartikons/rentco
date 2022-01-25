package com.rentco.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.rentco.demo.command.ReservationCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    ObjectMapper mapper = new ObjectMapper();
    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

    @Test
    void contextLoads() {
    }

    @Test
    void crateReservationdRepeat() {
        ReservationCommand reservationCommand = new ReservationCommand(300, 1, 1, Date.valueOf("2023-01-01"), Date.valueOf("2023-01-21"), 5);
        try {
            mockMvc.perform(post("/api/RoomReservation")
                            .contentType("application/json")
                            .content(ow.writeValueAsString(reservationCommand)))
                    .andExpect(status().isNotAcceptable());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void changeReservationOfNegativid() {
        ReservationCommand reservationCommand = new ReservationCommand(-1, 300, 1, 1, Date.valueOf("2023-01-01"), Date.valueOf("2023-01-21"), 5);

        try {
            mockMvc.perform(put("/api/RoomReservation")
                            .contentType("application/json")
                            .content(ow.writeValueAsString(reservationCommand)))
                    .andExpect(status().isNotFound());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getReservation() {
        try {
            mockMvc.perform(get("/api/RoomReservation?roomId=1"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getReservationOfRoomThatNotExist() {
        try {
            mockMvc.perform(get("/api/RoomReservation?roomId=-1"))
                    .andExpect(status().isNotFound());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getReservationByGivenName() {
        try {
            mockMvc.perform(get("/api/TenantReservation?tenantName=DORI6"))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
