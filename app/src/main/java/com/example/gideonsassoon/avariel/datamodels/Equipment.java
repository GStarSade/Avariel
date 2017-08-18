package com.example.gideonsassoon.avariel.datamodels;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gideon Sassoon on 24/12/2016.
 * Can also be considered EQUIPMENT
 * A Player can have multiple items
 */

public class Equipment extends RealmObject {

    @PrimaryKey
    private String equipmentID;
    private String equipmentName;
    private String equipment;
    private double equipmentWeight;
    private int armorBonus;

    public Equipment() {
    }
/*
http://stackoverflow.com/questions/36261888/how-to-use-constructor-in-realm-on-android

 */

    /**
     * @param equipmentName
     * @param equipmentCost
     * @param equipmentWeight
     */
    public static Equipment create(String equipmentName, String equipmentCost, Double equipmentWeight) {
        Equipment equipment = new Equipment();
        equipment.equipmentName = equipmentName;
        equipment.equipment = equipmentCost;
        equipment.equipmentWeight = equipmentWeight; //to Double?
        return equipment;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public double getEquipmentWeight() {
        return equipmentWeight;
    }

    public void setEquipmentWeight(double equipmentWeight) {
        this.equipmentWeight = equipmentWeight;
    }
}
