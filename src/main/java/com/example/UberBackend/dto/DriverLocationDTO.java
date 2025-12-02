package com.example.UberBackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverLocationDTO {
    @NotBlank(message = "driverId is required")
    private String driverId;

    @NotNull(message="latitude is required")
    private Double latitude;

    @NotNull(message="longitude is required")
    private Double longitude;
}
