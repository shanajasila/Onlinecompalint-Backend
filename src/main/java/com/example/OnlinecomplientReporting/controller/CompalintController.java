package com.example.OnlinecomplientReporting.controller;

import com.example.OnlinecomplientReporting.dao.RegistrationDao;
import com.example.OnlinecomplientReporting.model.OnlineCompaint;
import com.example.OnlinecomplientReporting.model.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class CompalintController {

    @Autowired
    private RegistrationDao dao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/register",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> userRegistration(@RequestBody UserRegistration r){
        System.out.println(r.getName());
        System.out.println(r.getEmail());
        System.out.println(r.getContact());
        System.out.println(r.getPassword());
        dao.save(r);
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> userlogin(@RequestBody UserRegistration r) {

        HashMap<String, String> map = new HashMap<>();
        List<UserRegistration> result = (List<UserRegistration>) dao.login(r.getPassword(), r.getEmail());

        if (result.size() == 0) {
            map.put("status", "failed");

        } else {
            int id = result.get(0).getId();
            map.put("message", "user login success");
            map.put("userId", String.valueOf(id));
            map.put("status", "success");

        }
        return map;

    }
        @CrossOrigin(origins = "*")
        @PostMapping(path = "/viewprofile",consumes = "application/json",produces = "application/json")
        public List<UserRegistration> viewprofile(@RequestBody UserRegistration r){
            return dao.viewprofile(r.getId());
        }


}
