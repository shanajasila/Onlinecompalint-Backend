package com.example.OnlinecomplientReporting.controller;

import com.example.OnlinecomplientReporting.dao.OnlineCompaintDao;
import com.example.OnlinecomplientReporting.model.OnlineCompaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OnlinecomplaintController {
    @Autowired
    private OnlineCompaintDao dc;

    @CrossOrigin(origins = "*")
    @PostMapping(path="/addcomplaint",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> AddComplaints(@RequestBody OnlineCompaint oc){
        HashMap<String,String> map=new HashMap<>();
        dc.save(oc);
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path="/viewmycomplaints",consumes = "application/json",produces = "application/json")
    public List<OnlineCompaint> ViewMyComplaints(@RequestBody OnlineCompaint c){
        String userid=String.valueOf(c.getUserId());
        System.out.println(userid);
        return (List<OnlineCompaint>) dc.ViewComplaints(c.getUserId());
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path="/viewall")
    public List<Map<String,String>> ViewAll(){
        return (List<Map<String,String>>) dc.Complaints();
    }

}
