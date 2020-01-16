package com.example.springproject.restcontroller;

import com.example.springproject.model.Car;
import com.example.springproject.model.UserCar;
import com.example.springproject.service.CarService;
import com.example.springproject.service.UserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
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
            if (authentication != null) {
                if (authentication.isAuthenticated()) {
                    List<Car> cars = carService.createCar(name, model, gearbox, Double.valueOf(price), Integer.valueOf(year), size);
                    return ResponseEntity.ok().body(cars);
                }
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<List<Car>> deleteCar(Authentication authentication,
                                               @PathVariable("id") Long id) {
        try {
            if (authentication != null) {
                if (authentication.isAuthenticated()) {
                    List<Car> cars = carService.deleteCar(id);
                    return ResponseEntity.ok().body(cars);
                }
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCar(Authentication authentication,
                                             @PathVariable("id") Long id) {
        try {
            if (authentication != null) {
                if (authentication.isAuthenticated()) {
                    Car car = carService.getCar(id);
                    return ResponseEntity.ok().body(car);
                }
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/car")
    public ResponseEntity<List<Car>> getAllCars(Authentication authentication, Model model) {
        try {
            if (authentication != null) {
                if (authentication.isAuthenticated()) {
                    List<Car> cars = carService.getAllCars();
                    return ResponseEntity.ok().body(cars);
                }
            }
            return ResponseEntity.badRequest().build();
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
    public ResponseEntity<List<Car>> getFreeCars(Authentication authentication,
                                                 @RequestParam("startDate") String startDate,
                                                 @RequestParam("endDate") String endDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
            Date startDay = new Date(sdf.parse(startDate).getTime());
            Date endDay = new Date(sdf.parse(endDate).getTime());
            List<Car> allCars = carService.getAllCars();
            List<Car> freeCars = new ArrayList<>();
            for (Car car : allCars) {
                List<UserCar> cars = userCarService.getReservedByCar(car.getId(), startDay, endDay);
                if (cars.size() == 0) {
                    freeCars.add(car);
                }
            }
            return ResponseEntity.ok().body(freeCars);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
