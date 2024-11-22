package com.fleet.fleetflow.repository;

import com.fleet.fleetflow.model.TripEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TripEventRepository extends JpaRepository<TripEvent, String> {
    Optional<TripEvent> findByTransactionId(String transactionId);
}
