package com.example.springproject.repository;

import com.example.springproject.model.UserCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCarRepository extends JpaRepository<UserCar, Long> {


}
