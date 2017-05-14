package com.example.gideonsassoon.avariel.datamodels;

/**
 * Created by Gideon Sassoon on 20/03/2017.
 */

public class Combat {

    int initiative;

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
