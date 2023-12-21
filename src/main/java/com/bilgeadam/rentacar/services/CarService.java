package com.bilgeadam.rentacar.services;

import com.bilgeadam.rentacar.entities.Car;
import com.bilgeadam.rentacar.repository.CarRepository;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class CarService {
    private  final CarRepository carRepository;

    public CarService (CarRepository carRepository){ this.carRepository = carRepository;}
    public List<Car> getAllCars(){
      return carRepository.findAll();
    }

    public Car saveCar (Car car){
        return carRepository.save(car);
    }

    public Car updateCar(Car car) {
        return carRepository.save(car);
    }
    public void deleteCar(Integer id){
        carRepository.deleteById(id);
    }
}
