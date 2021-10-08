package com.example.bigbowlxp.services;

import com.example.bigbowlxp.models.Beverage;
import com.example.bigbowlxp.repositories.BeverageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeverageService {

    private BeverageRepo beverageRepo;

    public List<Beverage> fetchBeverages() {
        return beverageRepo.fetchBeverages();
    }

    public void createBeverage(Beverage beverage) {
        beverageRepo.createBeverage(beverage);
    }

    public void deleteBeverage(int id) {
        beverageRepo.deleteBeverage(id);
    }

    public void updatePrice(double price, int id) {
        beverageRepo.updatePrice(price, id);
    }

    @Autowired
    public void setBeverageRepo(BeverageRepo beverageRepo) {
        this.beverageRepo = beverageRepo;
    }

    public BeverageRepo getBeverageRepo() {
        return beverageRepo;
    }
    public void updateBeverage(Beverage b){
        beverageRepo.updateBeverage(b);
    }
    public Beverage findBeverageById(int beverage_id){
        return beverageRepo.findBeverageById(beverage_id);
    }


}
