package com.example.gideonsassoon.avariel.datamodels;

import io.realm.RealmObject;

/**
 * Created by Gideon Sassoon on 24/12/2016.
 */

public class Spell extends RealmObject {

    private String spellName; //*
    private String spellCantripLevel;

    private int spellRangeNormal; //*
    private String spellRangeType; // cone, line, cube, spear

    private int spellDuration;
    private String spellDurationUnit; //Minute, Second, Hour, Instant
    private boolean spellDurationConcentration;

    private boolean spellComponentVerbal;
    private boolean spellComponentSomatic;
    private boolean spellComponentMaterial;

    private int spellDamageDieType; //*
    private int spellDamageNumberOfDie; //*

    private int spellDamageAdditional; //* Any additional +/- damage
    private String spellDamageType; //* P, B, S

    private String spellDescription; //heavy, light, loading, special, thrown, improvised weapon, Silvered, special, ammunition

    public String getSpellName() {
        return spellName;
    }

    public String getSpellCantripLevel() {
        return spellCantripLevel;
    }

    public void setSpellCantripLevel(String spellCantripLevel) {
        this.spellCantripLevel = spellCantripLevel;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public int getSpellRangeNormal() {
        return spellRangeNormal;
    }

    public void setSpellRangeNormal(int spellRangeNormal) {
        this.spellRangeNormal = spellRangeNormal;
    }

    public String getSpellRangeType() {
        return spellRangeType;
    }

    public void setSpellRangeType(String spellRangeType) {
        this.spellRangeType = spellRangeType;
    }

    public int getSpellDuration() {
        return spellDuration;
    }

    public void setSpellDuration(int spellDuration) {
        this.spellDuration = spellDuration;
    }

    public String getSpellDurationUnit() {
        return spellDurationUnit;
    }

    public void setSpellDurationUnit(String spellDurationUnit) {
        this.spellDurationUnit = spellDurationUnit;
    }

    public boolean isSpellDurationConcentration() {
        return spellDurationConcentration;
    }

    public void setSpellDurationConcentration(boolean spellDurationConcentration) {
        this.spellDurationConcentration = spellDurationConcentration;
    }

    public boolean isSpellComponentVerbal() {
        return spellComponentVerbal;
    }

    public void setSpellComponentVerbal(boolean spellComponentVerbal) {
        this.spellComponentVerbal = spellComponentVerbal;
    }

    public boolean isSpellComponentSomatic() {
        return spellComponentSomatic;
    }

    public void setSpellComponentSomatic(boolean spellComponentSomatic) {
        this.spellComponentSomatic = spellComponentSomatic;
    }

    public boolean isSpellComponentMaterial() {
        return spellComponentMaterial;
    }

    public void setSpellComponentMaterial(boolean spellComponentMaterial) {
        this.spellComponentMaterial = spellComponentMaterial;
    }

    public int getSpellDamageDieType() {
        return spellDamageDieType;
    }

    public void setSpellDamageDieType(int spellDamageDieType) {
        this.spellDamageDieType = spellDamageDieType;
    }

    public int getSpellDamageNumberOfDie() {
        return spellDamageNumberOfDie;
    }

    public void setSpellDamageNumberOfDie(int spellDamageNumberOfDie) {
        this.spellDamageNumberOfDie = spellDamageNumberOfDie;
    }

    public int getSpellDamageAdditional() {
        return spellDamageAdditional;
    }

    public void setSpellDamageAdditional(int spellDamageAdditional) {
        this.spellDamageAdditional = spellDamageAdditional;
    }

    public String getSpellDamageType() {
        return spellDamageType;
    }

    public void setSpellDamageType(String spellDamageType) {
        this.spellDamageType = spellDamageType;
    }

    public String getSpellDescription() {
        return spellDescription;
    }

    public void setSpellDescription(String spellDescription) {
        this.spellDescription = spellDescription;
    }
}
