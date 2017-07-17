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
    private String gearID;
    private String gearName;
    private String gearCost;
    private double gearWeight;
    private int armorBonus;


    public Equipment() {
    }
/*
http://stackoverflow.com/questions/36261888/how-to-use-constructor-in-realm-on-android

 */
    /**
     * @param gearName
     * @param gearCost
     * @param gearWeight
     */
    public static Equipment create(String gearName, String gearCost, Double gearWeight) {
        Equipment equipment = new Equipment();
        equipment.gearName = gearName;
        equipment.gearCost = gearCost;
        equipment.gearWeight = gearWeight; //to Double?
        return equipment;
    }




    public String getGearName() {
        return gearName;
    }

    public void setGearName(String gearName) {
        this.gearName = gearName;
    }

    public String getGearCost() {
        return gearCost;
    }

    public void setGearCost(String gearCost) {
        this.gearCost = gearCost;
    }

    public double getGearWeight() {
        return gearWeight;
    }

    public void setGearWeight(double gearWeight) {
        this.gearWeight = gearWeight;
    }
}
