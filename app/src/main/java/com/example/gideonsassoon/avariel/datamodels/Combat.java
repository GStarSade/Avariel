package com.example.gideonsassoon.avariel.datamodels;

import io.realm.RealmObject;

/**
 * Created by Gideon Sassoon on 20/03/2017.
 */

public class Combat extends RealmObject {

    int initiative;
    /**
     * DO NOT REMOVE setArmorClassBase without backing it up
     * If you forget it's this.ArmorClassBase = parameter + 10;
     */
    int armorClassBase;
    /**
     * Your AC is equal to the following: 10 + armor bonus + shield bonus + Dexterity modifier + size modifier
     */
    int armorClassCurrent;
    int armorClassShieldBonus;
    int armorClassSizeModifyer;

    int currentHitPoints;
    int temporaryHitPoints;
    int hitDieType;
    int hitNumberOfDie;
    int successDeathSaves;
    int failureDeathSaves;

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getArmorClassBase() {
        return armorClassBase;
    }

    /***
     * Sets ArmorClassBase whichs adds the + 10
     * DO NOT REMOVE without backing it up
     * @param dex current dexterity
     */
    public void setArmorClassBase(int dex) {
        this.armorClassBase = dex + 10;
    }

    public int getArmorClassCurrent() {
        return armorClassCurrent;
    }

    public void setArmorClassCurrent(int armorClassCurrent) {
        this.armorClassCurrent = armorClassCurrent;
    }

    public int getArmorClassShieldBonus() {
        return armorClassShieldBonus;
    }

    public void setArmorClassShieldBonus(int armorClassShieldBonus) {
        this.armorClassShieldBonus = armorClassShieldBonus;
    }

    public int getArmorClassSizeModifyer() {
        return armorClassSizeModifyer;
    }

    public void setArmorClassSizeModifyer(int armorClassSizeModifyer) {
        this.armorClassSizeModifyer = armorClassSizeModifyer;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getTemporaryHitPoints() {
        return temporaryHitPoints;
    }

    public void setTemporaryHitPoints(int temporaryHitPoints) {
        this.temporaryHitPoints = temporaryHitPoints;
    }

    public int getHitDieType() {
        return hitDieType;
    }

    public void setHitDieType(int hitDieType) {
        this.hitDieType = hitDieType;
    }

    public int getHitNumberOfDie() {
        return hitNumberOfDie;
    }

    public void setHitNumberOfDie(int hitNumberOfDie) {
        this.hitNumberOfDie = hitNumberOfDie;
    }

    public int getSuccessDeathSaves() {
        return successDeathSaves;
    }

    public void setSuccessDeathSaves(int successDeathSaves) {
        this.successDeathSaves = successDeathSaves;
    }

    public int getFailureDeathSaves() {
        return failureDeathSaves;
    }

    public void setFailureDeathSaves(int failureDeathSaves) {
        this.failureDeathSaves = failureDeathSaves;
    }
}
