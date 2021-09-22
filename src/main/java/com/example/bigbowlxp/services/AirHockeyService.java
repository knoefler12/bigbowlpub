package com.example.bigbowlxp.services;

import com.example.bigbowlxp.repositories.AirHockeyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirHockeyService {

    private AirHockeyRepo airHockeyRepo;

    @Autowired
    public void setAirHockeyRepo(AirHockeyRepo airHockeyRepo) {
        this.airHockeyRepo = airHockeyRepo;
    }


}
