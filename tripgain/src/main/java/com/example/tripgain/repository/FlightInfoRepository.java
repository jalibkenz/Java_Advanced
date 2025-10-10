package com.example.tripgain.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tripgain.model.FlightInfo;

@Repository
public interface FlightInfoRepository extends JpaRepository<FlightInfo, Long> {
    Optional<FlightInfo> findByFlightNumber(String flightNumber);
    Optional<FlightInfo> findTopByOrderByTotalAmountDesc();
    Optional<FlightInfo> findTopByOrderByTotalAmountAsc();
}
