package com.example.UberBackend.service;


import com.example.UberBackend.dto.PassengerRequest;
import com.example.UberBackend.dto.PassengerResponse;

/**
 * Interface for Passenger write operations
 * Following Interface Segregation Principle
 */
public interface PassengerWriteService {
    PassengerResponse create(PassengerRequest request);
    PassengerResponse update(Long id, PassengerRequest request);
    void deleteById(Long id);
}