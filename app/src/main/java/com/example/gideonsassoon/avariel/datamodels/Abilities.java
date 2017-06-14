package com.example.gideonsassoon.avariel.datamodels;

import io.realm.RealmObject;

public class Abilities extends RealmObject {

    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;

    int strengthNonMod;
    int dexterityNonMod;
    int constitutionNonMod;
    int intelligenceNonMod;
    int wisdomNonMod;
    int charismaNonMod;

    public Abilities(){

    }

    /*public Abilities(int strengthNonMod, int dexterityNonMod, int constitutionNonMod, int intelligenceNonMod, int wisdomNonMod, int charismaNonMod) {
        this.strengthNonMod = strengthNonMod;
        this.dexterityNonMod = dexterityNonMod;
        this.constitutionNonMod = constitutionNonMod;
        this.intelligenceNonMod = intelligenceNonMod;
        this.wisdomNonMod = wisdomNonMod;
        this.charismaNonMod = charismaNonMod;
    }*/

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getStrengthNonMod() {
        return strengthNonMod;
    }

    public void setStrengthNonMod(int strengthNonMod) {
        this.strengthNonMod = strengthNonMod;
        setStrength(setModifer(strengthNonMod));
    }

    public int getDexterityNonMod() {
        return dexterityNonMod;
    }

    public void setDexterityNonMod(int dexterityNonMod) {
        this.dexterityNonMod = dexterityNonMod;
        setDexterity(setModifer(dexterityNonMod));
    }

    public int getConstitutionNonMod() {
        return constitutionNonMod;
    }

    public void setConstitutionNonMod(int constitutionNonMod) {
        this.constitutionNonMod = constitutionNonMod;
        setConstitution(setModifer(constitutionNonMod));
    }

    public int getIntelligenceNonMod() {
        return intelligenceNonMod;
    }

    public void setIntelligenceNonMod(int intelligenceNonMod) {
        this.intelligenceNonMod = intelligenceNonMod;
        setIntelligence(setModifer(intelligenceNonMod));
    }

    public int getWisdomNonMod() {
        return wisdomNonMod;
    }

    public void setWisdomNonMod(int wisdomNonMod) {
        this.wisdomNonMod = wisdomNonMod;
        setWisdom(setModifer(wisdomNonMod));
    }

    public int getCharismaNonMod() {
        return charismaNonMod;
    }

    public void setCharismaNonMod(int charismaNonMod) {
        this.charismaNonMod = charismaNonMod;
        setCharisma(setModifer(charismaNonMod));
    }

    public int setModifer(int value) {
        switch (value) {
            case 1:
                return -5;
            case 2:
            case 3:
                return -4;
            case 4:
            case 5:
                return -3;
            case 6:
            case 7:
                return -2;
            case 8:
            case 9:
                return -1;
            case 10:
            case 11:
                return 0;
            case 12:
            case 13:
                return 1;
            case 14:
            case 15:
                return 2;
            case 16:
            case 17:
                return 3;
            case 18:
            case 19:
                return 4;
            default:
                return 0;
        }
    }

    //public void modiferChange
    /*
    class
    race
    roles
    */
}
