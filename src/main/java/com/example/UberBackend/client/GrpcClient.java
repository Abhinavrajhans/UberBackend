package com.example.UberBackend.client;


import com.example.UberBackend.RideNotificationRequest;
import com.example.UberBackend.RideNotificationResponse;
import com.example.UberBackend.RideNotificationServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.util.List;

@Component
public class GrpcClient {


    @Value("${grpc.server.port:9090}")
    private int grpcServerPort;

    @Value("${grpc.server.host:localhost}")
    private String grpcServerHost;

    private ManagedChannel channel;

    private RideNotificationServiceGrpc.RideNotificationServiceBlockingStub rideNotificationServiceBlockingStub;


    @PostConstruct
    public void init(){
        channel = ManagedChannelBuilder.forAddress(grpcServerHost, grpcServerPort)
                .usePlaintext().build();

        rideNotificationServiceBlockingStub = RideNotificationServiceGrpc.newBlockingStub(channel);
    }

    public boolean notifyDriversForNewRide(String pickUpLocationLatitude , String pickUpLocationLongitude,
                                           Long bookingId , List<Long> driverIds)
    {
        RideNotificationRequest request = RideNotificationRequest.newBuilder()
                .setPickUpLocationLatitude(pickUpLocationLatitude)
                .setPickUpLocationLongitude(pickUpLocationLongitude)
                .setBookingId(bookingId)
                .addAllDriverIds(driverIds)
                .build();

        RideNotificationResponse response = rideNotificationServiceBlockingStub.notifyDriversForNewRide(request);
        return response.getSuccess();
    }

}
