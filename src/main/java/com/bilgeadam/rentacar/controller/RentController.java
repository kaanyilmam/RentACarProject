package com.bilgeadam.rentacar.controller;


import com.bilgeadam.rentacar.entities.Rent;
import com.bilgeadam.rentacar.services.RentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping(path = "/api/rent")
public class RentController {

    private RentService rentService;
    public RentController(RentService rentService){this.rentService = rentService;}

    @GetMapping("/getRentalsWithinDateRange")
    public List<Rent> getRentalsWithinDateRange(Date startDate, Date endDate){
        return rentService.getRentalsWithinDateRange(startDate,endDate);
    }

    @GetMapping("/getRentalsByYearAndMonth")
    public List<Rent> getRentalsByYearAndMonth(int year, int month){
        return rentService.getRentalsByYearAndMonth(year,month);
    }

    @GetMapping("/findAllRentsByCarId")
    public List<Rent> findAllRentsByCarId(Integer carId){
        return rentService.findAllRentsByCarId(carId);
    }

    @GetMapping("/findRentsByCarAndDateRange")
    public List<Rent> findRentsByCarAndDateRange(Integer carId, Date startDate, Date endDate){
        return rentService.findRentsByCarAndDateRange(carId,startDate,endDate);
    }

    @GetMapping("/countRentalsByYearAndMonth")
    public Long countRentalsByYearAndMonth(int year, int month){
        return rentService.countRentalsByYearAndMonth(year,month);
    }

    @GetMapping("/totalRentalDurationByYearAndMonth")
    public Integer totalRentalDurationByYearAndMonth(int year, int month){
        return rentService.totalRentalDurationByYearAndMonth(year,month);

    }

    @GetMapping( path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rent> getAllRents(){
        return  rentService.getAllRents();
    }
}
