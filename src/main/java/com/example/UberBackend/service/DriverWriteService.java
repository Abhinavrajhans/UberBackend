package com.example.UberBackend.service;

import com.example.UberBackend.dto.DriverRequest;
import com.example.UberBackend.dto.DriverResponse;

/**
 * Interface for Driver write operations
 * Following Interface Segregation Principle
 */
public interface DriverWriteService {
    DriverResponse create(DriverRequest request);
    DriverResponse update(Long id, DriverRequest request);
    void deleteById(Long id);
}