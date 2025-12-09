package com.example.UberBackend.service;


import com.example.UberBackend.dto.DriverLocationDTO;

import java.util.List;

public interface LocationService {
    Boolean saveDriverLocation(Long driverId ,Double latitude , Double longitude);
    List<DriverLocationDTO> getNearByDrivers(Double latitude , Double longtitude , Double radius);
}
