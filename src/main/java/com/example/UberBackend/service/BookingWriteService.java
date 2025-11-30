package com.example.UberBackend.service;

import com.example.UberBackend.dto.BookingRequest;
import com.example.UberBackend.dto.BookingResponse;
import com.example.UberBackend.entity.BookingStatus;

/**
 * Interface for Booking write operations
 * Following Interface Segregation Principle
 */
public interface BookingWriteService {
    BookingResponse create(BookingRequest request);
    BookingResponse update(Long id, BookingRequest request);
    BookingResponse updateStatus(Long id, BookingStatus status);
    void deleteById(Long id);
}