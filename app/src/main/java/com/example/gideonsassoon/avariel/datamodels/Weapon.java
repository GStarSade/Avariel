package com.example.gideonsassoon.avariel.datamodels;

/**
 * Created by Gideon Sassoon on 24/12/2016.
 */

public class Weapon {

    private String weaponName;
    private String weaponCost;
    private double weaponWeight; //Weight is in lb.
    private String weaponPropertiesAdditional; //heavy, light, loading, special, thrown, improvised weapon, Silvered, special, ammunition

    private String weaponStatBonus; //strength, dexterity, Finesse (Both)
    private int weaponRangeNormal;
    private int weaponRangeLong;

    private int weaponDamageDieType;
    private int weaponDamageNumberOfDie;

    private int weaponDamageDieTypeVersatile;
    private int weaponDamageNumberOfDieVersatile;

    private int weaponDamageAdditional; //Any additional +/- damage
    private Character weaponDamageType; //P, B, S
    /**
     * IS this weapon part of the default lib for selection?
     */
    private boolean weaponLibItem;

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

    public String getWeaponStatBonus() {
        return weaponStatBonus;
    }

    public void setWeaponStatBonus(String weaponStatBonus) {
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

    public int getWeaponDamageNumberOfDie() {
        return weaponDamageNumberOfDie;
    }

    public void setWeaponDamageNumberOfDie(int weaponDamageNumberOfDie) {
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

    public Character getWeaponDamageType() {
        return weaponDamageType;
    }

    public void setWeaponDamageType(Character weaponDamageType) {
        this.weaponDamageType = weaponDamageType;
    }

    public boolean isWeaponLibItem() {
        return weaponLibItem;
    }

    public void setWeaponLibItem(boolean weaponLibItem) {
        this.weaponLibItem = weaponLibItem;
    }
}
