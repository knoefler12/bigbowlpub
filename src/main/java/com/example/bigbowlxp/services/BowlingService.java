package com.example.bigbowlxp.services;

import com.example.bigbowlxp.models.BowlingLane;
import com.example.bigbowlxp.repositories.BowlingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

@Service
public class BowlingService {

    private BowlingRepo bowlingRepo;

    public List<BowlingLane> getLanes() {
        return bowlingRepo.fetchAllBowlingLanes();
    }

    public Boolean bowlingLaneStatus(int id){
        return bowlingRepo.bowlingLaneStatus(id);
    }

    public void bowlingStatusDesc(BowlingLane bowlingLane, int id ){
        bowlingRepo.bowlingStatusDesc(bowlingLane, id);
    }


    @Autowired
    public void setBowlingRepo(BowlingRepo bowlingRepo) {
        this.bowlingRepo = bowlingRepo;
    }



    public BowlingRepo getBowlingRepo() {
        return bowlingRepo;
    }
}

