package com.example.gideonsassoon.avariel.datamodels;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gideon Sassoon on 24/12/2016.
 */

public class Weapon extends RealmObject {

    @PrimaryKey
    int weaponID;

    private String weaponName;//*
    private String weaponCost;
    private double weaponWeight; //Weight is in lb.
    private String weaponPropertiesAdditional; //heavy, light, loading, special, thrown, improvised weapon, Silvered, special, ammunition

    private int weaponStatBonus; //strength, dexterity, Finesse (Both)
    private int weaponRangeNormal; //*
    private int weaponRangeLong;

    private int weaponDamageDieType;//*
    //Shouldn't really be string try and get it back to int if you can
    private String weaponDamageNumberOfDie;//*

    private int weaponDamageDieTypeVersatile;
    private int weaponDamageNumberOfDieVersatile;

    private int weaponDamageAdditional; //* Any additional +/- damage
    private int weaponDamageType; //* P, B, S
    /**
     * IS this weapon part of the default lib for selection?
     */
    private boolean weaponLibItem;

    public int getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(int weaponID) {
        this.weaponID = weaponID;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getWeaponCost() {
        return weaponCost;
    }

    public void setWeaponCost(String weaponCost) {
        this.weaponCost = weaponCost;
    }

    public double getWeaponWeight() {
        return weaponWeight;
    }

    public void setWeaponWeight(double weaponWeight) {
        this.weaponWeight = weaponWeight;
    }

    public String getWeaponPropertiesAdditional() {
        return weaponPropertiesAdditional;
    }

    public void setWeaponPropertiesAdditional(String weaponPropertiesAdditional) {
        this.weaponPropertiesAdditional = weaponPropertiesAdditional;
    }

    public int getWeaponStatBonus() {
        return weaponStatBonus;
    }

    public void setWeaponStatBonus(int weaponStatBonus) {
        this.weaponStatBonus = weaponStatBonus;
    }

    public int getWeaponRangeNormal() {
        return weaponRangeNormal;
    }

    public void setWeaponRangeNormal(int weaponRangeNormal) {
        this.weaponRangeNormal = weaponRangeNormal;
    }

    public int getWeaponRangeLong() {
        return weaponRangeLong;
    }

    public void setWeaponRangeLong(int weaponRangeLong) {
        this.weaponRangeLong = weaponRangeLong;
    }

    public int getWeaponDamageDieType() {
        return weaponDamageDieType;
    }

    public void setWeaponDamageDieType(int weaponDamageDieType) {
        this.weaponDamageDieType = weaponDamageDieType;
    }

    public String getWeaponDamageNumberOfDie() {
        return weaponDamageNumberOfDie;
    }

    public void setWeaponDamageNumberOfDie(String weaponDamageNumberOfDie) {
        this.weaponDamageNumberOfDie = weaponDamageNumberOfDie;
    }

    public int getWeaponDamageDieTypeVersatile() {
        return weaponDamageDieTypeVersatile;
    }

    public void setWeaponDamageDieTypeVersatile(int weaponDamageDieTypeVersatile) {
        this.weaponDamageDieTypeVersatile = weaponDamageDieTypeVersatile;
    }

    public int getWeaponDamageNumberOfDieVersatile() {
        return weaponDamageNumberOfDieVersatile;
    }

    public void setWeaponDamageNumberOfDieVersatile(int weaponDamageNumberOfDieVersatile) {
        this.weaponDamageNumberOfDieVersatile = weaponDamageNumberOfDieVersatile;
    }

    public int getWeaponDamageAdditional() {
        return weaponDamageAdditional;
    }

    public void setWeaponDamageAdditional(int weaponDamageAdditional) {
        this.weaponDamageAdditional = weaponDamageAdditional;
    }

    public int getWeaponDamageType() {
        return weaponDamageType;
    }

    public void setWeaponDamageType(int weaponDamageType) {
        this.weaponDamageType = weaponDamageType;
    }

    public boolean isWeaponLibItem() {
        return weaponLibItem;
    }

    public void setWeaponLibItem(boolean weaponLibItem) {
        this.weaponLibItem = weaponLibItem;
    }
}
