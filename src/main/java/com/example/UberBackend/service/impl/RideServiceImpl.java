package com.example.UberBackend.service.impl;

import com.example.UberBackend.RideAcceptanceRequest;
import com.example.UberBackend.RideAcceptanceResponse;
import com.example.UberBackend.RideServiceGrpc;
import com.example.UberBackend.service.BookingService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RideServiceImpl extends RideServiceGrpc.RideServiceImplBase {

    private final BookingService bookingService;

    @Override
    public void acceptRide(RideAcceptanceRequest request, StreamObserver<RideAcceptanceResponse> responseObserver) {
        // Call the BookingService to update the ride with the new driver id.
        boolean success = bookingService.acceptRide((long) request.getBookingId(),(long)request.getDriverId());
        RideAcceptanceResponse response = RideAcceptanceResponse.newBuilder()
                .setSuccess(success)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
