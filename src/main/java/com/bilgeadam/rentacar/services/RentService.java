package com.bilgeadam.rentacar.services;

import com.bilgeadam.rentacar.entities.Rent;
import com.bilgeadam.rentacar.repository.RentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class RentService {
    private RentRepository rentRepository;
    public RentService(RentRepository rentRepository){this.rentRepository = rentRepository;}

    public List<Rent> getAllRents(){
        return rentRepository.findAll();
    }

    public List<Rent> getRentalsWithinDateRange(Date startDate, Date endDate){
        return rentRepository.getRentalsWithinDateRange(startDate,endDate);
    }

    public List<Rent> getRentalsByYearAndMonth(int year, int month){
        return rentRepository.getRentalsByYearAndMonth(year,month);
    }

    public List<Rent> findAllRentsByCarId(Integer carId){
        return rentRepository.findAllRentsByCarId(carId);
    }


    public List<Rent> findRentsByCarAndDateRange(Integer carId, Date startDate, Date endDate){
        return rentRepository.findRentsByCarAndDateRange(carId,startDate,endDate);
    }

    public Long countRentalsByYearAndMonth(int year, int month){
        return rentRepository.countRentalsByYearAndMonth(year,month);
    }

    public Integer totalRentalDurationByYearAndMonth(int year, int month){
        return rentRepository.totalRentalDurationByYearAndMonth(year,month);
    }
}
