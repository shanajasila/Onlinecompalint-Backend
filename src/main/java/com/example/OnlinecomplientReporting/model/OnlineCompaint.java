package com.example.OnlinecomplientReporting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "complaints")
public class OnlineCompaint {

    @Id
    @GeneratedValue

    private int id;
    private int userId;
    private String complaint;

    public OnlineCompaint() {
    }

    public OnlineCompaint(int id, int userId, String complaint) {
        this.id = id;
        this.userId = userId;
        this.complaint = complaint;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
