package com.example.bigbowlxp.services;

import com.example.bigbowlxp.models.AirHockeyTable;
import com.example.bigbowlxp.models.Customer;
import com.example.bigbowlxp.models.Equipment;
import com.example.bigbowlxp.repositories.AirHockeyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirHockeyService {

    private AirHockeyRepo airHockeyRepo;

    @Autowired
    public void setAirHockeyRepo(AirHockeyRepo airHockeyRepo) {
        this.airHockeyRepo = airHockeyRepo;
    }

    public List<AirHockeyTable> fetchAirHockeyTable(){
        return airHockeyRepo.fetchAirHockey();
    }

    public AirHockeyRepo getAirHockeyRepo() {
        return airHockeyRepo;
    }

    public void updateAirHockey(AirHockeyTable a){
        airHockeyRepo.updateAirHockey(a);
    }


    public AirHockeyTable findEquipmentById(int airhockeyTableId){
        return airHockeyRepo.findAirhockeyTableById(airhockeyTableId);
    }
    public Boolean airhockeyTableStatus(int id){
        return airHockeyRepo.airhockeyTableStatus(id);
    }

    public void airhockeyDescription(AirHockeyTable airHockeyTable, int id ) {
        airHockeyRepo.airhockeyDescription(airHockeyTable, id);
    }
}
