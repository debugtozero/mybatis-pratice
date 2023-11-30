package com.mayikt;

import com.mayikt.entity.FlightEntity;
import com.mayikt.service.FlightService;

import java.io.IOException;
import java.util.List;

public class test01 {
    public static void main(String[] args) throws IOException {
        FlightService flightService = new FlightService();
        List<FlightEntity> flightEntitys = flightService.getByFlightAll();
        System.out.println(flightEntitys);
    }
}
