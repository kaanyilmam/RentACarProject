package com.bilgeadam.rentacar.controller;

import com.bilgeadam.rentacar.entities.Car;
import com.bilgeadam.rentacar.services.CarService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    private final CarService carService;

    public CarController (CarService carService){
        this.carService = carService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getAllCars (){
        return carService.getAllCars();
    }

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car saveCar (@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car updateCar(@RequestBody Car car) {
        return carService.updateCar(car);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCarId(@PathVariable("id") Integer id) {
        carService.deleteCar(id);
        return "Silme işlemi başarılı";
    }
}
