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
    private int equipmentID;
    private String equipmentName;
    private double equipmentWeight;
    private String equipmentCost;

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
    public static Equipment create(String equipmentName, Double equipmentWeight, String equipmentCost) {
        Equipment equipment = new Equipment();
        equipment.equipmentName = equipmentName;
        equipment.equipmentWeight = equipmentWeight; //to Double?
        equipment.equipmentCost = equipmentCost;
        return equipment;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public double getEquipmentWeight() {
        return equipmentWeight;
    }

    public void setEquipmentWeight(double equipmentWeight) {
        this.equipmentWeight = equipmentWeight;
    }

    public String getEquipmentCost() {
        return equipmentCost;
    }

    public void setEquipmentCost(String equipmentCost) {
        this.equipmentCost = equipmentCost;
    }
}
