package com.example.bigbowlxp.services;

import com.example.bigbowlxp.repositories.BowlingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BowlingService {

    private BowlingRepo bowlingRepo;

    @Autowired
    public void setBowlingRepo(BowlingRepo bowlingRepo) {
        this.bowlingRepo = bowlingRepo;
    }

}
