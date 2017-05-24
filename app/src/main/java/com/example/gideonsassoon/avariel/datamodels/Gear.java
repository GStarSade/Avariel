package com.example.gideonsassoon.avariel.datamodels;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gideon Sassoon on 24/12/2016.
 * Can also be considered EQUIPMENT
 * A Player can have multiple items
 */

public class Gear extends RealmObject {

    @PrimaryKey
    private String gearID;
    private String gearName;
    private String gearCost;
    private double gearWeight;


    public Gear() {
    }
/*
http://stackoverflow.com/questions/36261888/how-to-use-constructor-in-realm-on-android

 */
    /**
     * @param gearName
     * @param gearCost
     * @param gearWeight
     */
    public static Gear create(String gearName, String gearCost, Double gearWeight) {
        Gear gear  = new Gear();
        gear.gearName = gearName;
        gear.gearCost = gearCost;
        gear.gearWeight = gearWeight; //to Double?
        return gear;
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
