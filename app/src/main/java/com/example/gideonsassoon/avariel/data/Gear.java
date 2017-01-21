package com.example.gideonsassoon.avariel.data;

/**
 * Created by Gideon Sassoon on 24/12/2016.
 */

public class Gear {

    private String gearName;
    private String gearCost;
    private double gearWeight;


    public Gear() {
    }

    /**
     * @param gearName
     * @param gearCost
     * @param gearWeight
     */
    public Gear(String gearName, String gearCost, String gearWeight) {
        this.gearName = gearName;
        this.gearCost = gearCost;
        this.gearWeight = Double.parseDouble(gearWeight); //to Double?
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
