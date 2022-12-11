package com.example.OnlinecomplientReporting.dao;

import com.example.OnlinecomplientReporting.model.UserRegistration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistrationDao extends CrudRepository<UserRegistration,Integer> {

    @Query(value = "SELECT `id`, `address`, `contact`, `dob`, `email`, `name`, `password` FROM `user_registration` WHERE `email`= :email AND `password`= :password",nativeQuery = true)
    List<UserRegistration>login(@Param("password")String password,@Param("email")String email);

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `contact`, `dob` FROM `user_registration` WHERE `id`= :id",nativeQuery = true)
    List<UserRegistration>viewprofile(@Param("id") Integer id);
}
