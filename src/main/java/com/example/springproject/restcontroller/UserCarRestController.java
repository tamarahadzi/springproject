package com.example.springproject.restcontroller;

import com.example.springproject.model.UserCar;
import com.example.springproject.service.UserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserCarRestController {

    @Autowired
    UserCarService userCarService;

    @PostMapping("/userCar")
    public ResponseEntity<List<UserCar>> createUserCar(Authentication authentication,
                                                       @RequestParam("userId") String userId,
                                                       @RequestParam("carId") String carId,
                                                       @RequestParam("startDate") String startDate,
                                                       @RequestParam("endDate") String endDate) {
        try {
            //zameniti datume!!!
            userCarService.createUserCar(Long.valueOf(userId), Long.valueOf(carId), new Date(44444), new Date(555555));
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/userCar/{id}")
    public ResponseEntity<Boolean> getUserCar(Authentication authentication,
                                              @PathVariable("id") Long id) {
        try {
            userCarService.getUserCar(id);
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/userCar/{id}")
    public ResponseEntity<Boolean> deleteUserCar(Authentication authentication,
                                                 @PathVariable("id") Long id) {
        try {
            userCarService.deleteUserCar(id);
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /*@GetMapping("/userCar")
    public ResponseEntity<List<UserCar>> getAllUserCars(Authentication authentication) {
        try {
            userCarService.get();
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }*/

}
