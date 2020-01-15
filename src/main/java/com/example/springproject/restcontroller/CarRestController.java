package com.example.springproject.restcontroller;

import com.example.springproject.model.Car;
import com.example.springproject.model.UserCar;
import com.example.springproject.service.CarService;
import com.example.springproject.service.UserCarService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRestController {

    @Autowired
    CarService carService;

    @Autowired
    UserCarService userCarService;

    @PostMapping("/car")
    public ResponseEntity<List<Car>> createCar(Authentication authentication,
                                               @RequestParam("name") String name,
                                               @RequestParam("model") String model,
                                               @RequestParam("gearbox") String gearbox,
                                               @RequestParam("price") String price,
                                               @RequestParam("year") String year,
                                               @RequestParam("size") String size) {
        try {

            carService.createCar(name, model, gearbox, Double.valueOf(price), Integer.valueOf(year), size);
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Boolean> deleteCar(Authentication authentication,
                                               @PathVariable("id") Long id) {
        try {
            carService.deleteCar(id);
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Boolean> getCar(Authentication authentication,
                                             @PathVariable("id") Long id) {
        try {
            carService.getCar(id);
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/car")
    public ResponseEntity<List<Car>> getAllCars(Authentication authentication) {
        try {
            carService.getAllCars();
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/testapi")
    public void testapi(@RequestParam("aaa") String a) {
        String b = a;
        String c = b + "aaaaaaa";
    }

    @PostMapping("/getFreeCars")
    public ResponseEntity<List<Car>> getFreeCars(@RequestParam("startDate") String startDate,
                                                 @RequestParam("endDate") String endDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
            Date startDay = new Date(sdf.parse("2020-01-01").getTime());
            Date endDay = new Date(sdf.parse("2020-01-10").getTime());
            List<Car> allCars = carService.getAllCars();
            List<Car> freeCars = new ArrayList<>();
            for (Car car : allCars) {
                List<UserCar> cars = userCarService.getReservedByCar(car.getId(), startDay, endDay);
                if (cars.size() == 0) {
                    freeCars.add(car);
                }
            }
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
