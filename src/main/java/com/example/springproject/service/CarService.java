package com.example.springproject.service;

import com.example.springproject.model.Car;
import com.example.springproject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> createCar(String name, String model, String gearbox, Double price, Integer year, String size){
        Car car = new Car();
        car.setName(name);
        car.setModel(model);
        car.setGearbox(gearbox);
        car.setPrice(price);
        car.setYear(year);
        car.setSize(size);
        carRepository.save(car);
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    public List<Car> deleteCar(Long id) {
        carRepository.deleteById(id);
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        cars = carRepository.findAll();
        return cars;
    }

    public Car getCar(Long id) {
        Car car = carRepository.getOne(id);
        return car;
    }
}
