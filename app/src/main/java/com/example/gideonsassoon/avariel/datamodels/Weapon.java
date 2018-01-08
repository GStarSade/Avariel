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

    private int weaponAbilityBonus; //strength, dexterity, Finesse (Both)
    private int weaponRangeNormal; //*
    private int weaponRangeLong;

    private int weaponDamageDieType;//*
    private int weaponDamageNumberOfDie;//*

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

    public SheetEnum.Ability getWeaponAbilityBonus(){
        return SheetEnum.Ability.getEnumValue(weaponAbilityBonus);
    }

    public String getWeaponAbilityBonusAsReadableString(){
        String abilityBonus = String.valueOf(getWeaponAbilityBonus());
        abilityBonus = abilityBonus.substring(0,1).toUpperCase() + abilityBonus.substring(1).toLowerCase();
        return abilityBonus;
    }

    public int getWeaponAbilityBonusInt() {
        return weaponAbilityBonus;
    }

    public void setWeaponAbilityBonus(String ability){
        setWeaponAbilityBonus(SheetEnum.Ability.valueOf(ability.toUpperCase()));
    }

    public void setWeaponAbilityBonus(SheetEnum.Ability ability){
        this.weaponAbilityBonus = ability.getKey();
    }

    public void setWeaponAbilityBonus(int weaponStatBonus) {
        this.weaponAbilityBonus = weaponStatBonus;
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

    public WeaponEnum.DamageDieType getWeaponDamageDieType() {
        return WeaponEnum.DamageDieType.getEnumValue(weaponDamageDieType);
    }

    public int getWeaponDamageDieTypeInt() {
        return weaponDamageDieType;
    }

    public void setWeaponDamageDieType(String weaponDamageDieType) {
        setWeaponDamageDieType(WeaponEnum.DamageDieType.valueOf(weaponDamageDieType));
    }

    public void setWeaponDamageDieType(WeaponEnum.DamageDieType weaponDamageDieType) {
        this.weaponDamageDieType = weaponDamageDieType.getKey();
    }

    public void setWeaponDamageDieType(int weaponDamageDieType) {
        this.weaponDamageDieType = weaponDamageDieType;
    }

    public int getWeaponDamageNumberOfDie() {
        if (weaponDamageNumberOfDie == 0)
            return 1;
        else return weaponDamageNumberOfDie;
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

    public WeaponEnum.DamageType getDamageType() {
        return WeaponEnum.DamageType.getEnumValue(weaponDamageType);
    }

    public String getDamageTypeString() {
        return getDamageType().toString().replace("_", " ");
    }

    public int getWeaponDamageTypeInt() {
        return weaponDamageType;
    }

    public void setWeaponDamageType(String damageType) {
        if(damageType.contains(" "))
            damageType = damageType.replace(" ", "_");
        setWeaponDamageType(WeaponEnum.DamageType.valueOf(damageType));
    }

    public void setWeaponDamageType(WeaponEnum.DamageType damageType) {
        this.weaponDamageType = damageType.getKey();
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
