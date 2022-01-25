package com.rentco.demo.repository;

import com.rentco.demo.model.RentRoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRoomRepository extends JpaRepository<RentRoomModel, Integer> {

}