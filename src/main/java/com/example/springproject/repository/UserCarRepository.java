package com.example.springproject.repository;

import com.example.springproject.model.UserCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface UserCarRepository extends JpaRepository<UserCar, Long> {

    @Query(value = "select * from user_car where user_car.car_id = :carId and (user_car.start_date between :startDate and :endDate or user_car.end_date between :startDate and :endDate)", nativeQuery = true)
    List<UserCar> findAllReservedByCarId(@Param("carId") Long carId,
                                        @Param("startDate") Date startDate,
                                         @Param("endDate") Date endDate);
}
