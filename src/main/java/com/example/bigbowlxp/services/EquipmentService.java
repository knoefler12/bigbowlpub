package com.example.bigbowlxp.services;

import com.example.bigbowlxp.models.Equipment;
import com.example.bigbowlxp.models.Menu;
import com.example.bigbowlxp.repositories.EquipmentRepo;
import com.example.bigbowlxp.repositories.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    private EquipmentRepo equipmentRepo;

    public List<Equipment> fetchAllEquipment(){
        return equipmentRepo.fetchAllEquipment();
    }

    @Autowired
    public void setMenuRepo(EquipmentRepo equipmentRepo) {
        this.equipmentRepo = equipmentRepo;
    }

    public EquipmentRepo getEquipmentRepo() {
        return equipmentRepo;
    }

    public Equipment findEquipmentById(int equipment_id){
        return equipmentRepo.findEquipmentById(equipment_id);
    }
    public void updateEquipment(Equipment e){
        equipmentRepo.updateEquipment(e);
    }


}
