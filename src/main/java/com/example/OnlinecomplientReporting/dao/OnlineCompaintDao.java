package com.example.OnlinecomplientReporting.dao;

import com.example.OnlinecomplientReporting.model.OnlineCompaint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface OnlineCompaintDao extends CrudRepository<OnlineCompaint,Integer> {

    @Query(value="SELECT `id`, `complaints`, `userid` FROM `complaints` WHERE `userid`= :userid",nativeQuery = true)
    List<OnlineCompaint> ViewComplaints(@Param("userid") Integer userid);

    @Query(value="SELECT  r.`address`,  r.`emailid`, r.`name`,  r.`phoneno`,c.complaints FROM `registration` r JOIN complaints c ON c.userid=r.`id`",nativeQuery = true)
    List<Map<String,String>> Complaints();
}
