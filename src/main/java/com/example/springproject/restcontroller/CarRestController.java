package com.example.springproject.restcontroller;

import com.example.springproject.model.Car;
import com.example.springproject.service.CarService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRestController {

    @Autowired
    CarService carService;

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
}
