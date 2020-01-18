package com.example.springproject.restcontroller;

import com.example.springproject.model.UserCar;
import com.example.springproject.service.UserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserCarRestController {

    @Autowired
    UserCarService userCarService;

    @PostMapping("/userCar")
    public ResponseEntity<Boolean> createUserCar(Authentication authentication,
                                                 @RequestParam("userId") String userId,
                                                 @RequestParam("carId") String carId,
                                                 @RequestParam("startDate") String startDate,
                                                 @RequestParam("endDate") String endDate) {
        try {
            if (authentication != null) {
                if (authentication.isAuthenticated()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
                    Date startDay = new Date(sdf.parse(startDate).getTime());
                    Date endDay = new Date(sdf.parse(endDate).getTime());
                    userCarService.createUserCar(Long.valueOf(userId), Long.valueOf(carId), startDay, endDay);
                    return ResponseEntity.ok().body(true);
                }
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/userCar/{id}")
    public ResponseEntity<Boolean> getUserCar(Authentication authentication,
                                              @PathVariable("id") Long id) {
        try {
            if (authentication != null) {
                if (authentication.isAuthenticated()) {
                    userCarService.getUserCar(id);
                    return ResponseEntity.ok().body(null);
                }
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/userCar/{id}")
    public ResponseEntity<Boolean> deleteUserCar(Authentication authentication,
                                                 @PathVariable("id") Long id) {
        try {
            if (authentication != null) {
                if (authentication.isAuthenticated()) {
                    userCarService.deleteUserCar(id);
                    return ResponseEntity.ok().body(null);
                }
            }
            return ResponseEntity.badRequest().build();
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
