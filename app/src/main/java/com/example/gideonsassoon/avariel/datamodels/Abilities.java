package com.example.gideonsassoon.avariel.datamodels;

/**
 * Created by Gideon Sassoon on 24/12/2016.
 */
public class Abilities {

    /**
     * The Strength.
     */
    int strength;
    /**
     * The Dexterity.
     */
    int dexterity;
    /**
     * The Constitution.
     */
    int constitution;
    /**
     * The Intelligence.
     */
    int intelligence;
    /**
     * The Wisdom.
     */
    int wisdom;
    /**
     * The Charisma.
     */
    int charisma;

    /**
     * The Strength non mod.
     */
    int strengthNonMod;
    /**
     * The Dexterity non mod.
     */
    int dexterityNonMod;
    /**
     * The Constitution non mod.
     */
    int constitutionNonMod;
    /**
     * The Intelligence non mod.
     */
    int intelligenceNonMod;
    /**
     * The Wisdom non mod.
     */
    int wisdomNonMod;
    /**
     * The Charisma non mod.
     */
    int charismaNonMod;

    public Abilities(){

    }

    public Abilities(int strengthNonMod, int dexterityNonMod, int constitutionNonMod, int intelligenceNonMod, int wisdomNonMod, int charismaNonMod) {
        this.strengthNonMod = strengthNonMod;
        this.dexterityNonMod = dexterityNonMod;
        this.constitutionNonMod = constitutionNonMod;
        this.intelligenceNonMod = intelligenceNonMod;
        this.wisdomNonMod = wisdomNonMod;
        this.charismaNonMod = charismaNonMod;
    }

    /**
     * Gets strength.
     *
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Sets strength.
     *
     * @param strength the strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Gets dexterity.
     *
     * @return the dexterity
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * Sets dexterity.
     *
     * @param dexterity the dexterity
     */
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * Gets constitution.
     *
     * @return the constitution
     */
    public int getConstitution() {
        return constitution;
    }

    /**
     * Sets constitution.
     *
     * @param constitution the constitution
     */
    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    /**
     * Gets intelligence.
     *
     * @return the intelligence
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Sets intelligence.
     *
     * @param intelligence the intelligence
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * Gets wisdom.
     *
     * @return the wisdom
     */
    public int getWisdom() {
        return wisdom;
    }

    /**
     * Sets wisdom.
     *
     * @param wisdom the wisdom
     */
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    /**
     * Gets charisma.
     *
     * @return the charisma
     */
    public int getCharisma() {
        return charisma;
    }

    /**
     * Sets charisma.
     *
     * @param charisma the charisma
     */
    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    /**
     * Gets strength non mod.
     *
     * @return the strength non mod
     */
    public int getStrengthNonMod() {
        return strengthNonMod;
    }

    /**
     * Sets strength non mod.
     *
     * @param strengthNonMod the strength non mod
     */
    public void setStrengthNonMod(int strengthNonMod) {
        this.strengthNonMod = strengthNonMod;
    }

    /**
     * Gets dexterity non mod.
     *
     * @return the dexterity non mod
     */
    public int getDexterityNonMod() {
        return dexterityNonMod;
    }

    /**
     * Sets dexterity non mod.
     *
     * @param dexterityNonMod the dexterity non mod
     */
    public void setDexterityNonMod(int dexterityNonMod) {
        this.dexterityNonMod = dexterityNonMod;
    }

    /**
     * Gets constitution non mod.
     *
     * @return the constitution non mod
     */
    public int getConstitutionNonMod() {
        return constitutionNonMod;
    }

    /**
     * Sets constitution non mod.
     *
     * @param constitutionNonMod the constitution non mod
     */
    public void setConstitutionNonMod(int constitutionNonMod) {
        this.constitutionNonMod = constitutionNonMod;
    }

    /**
     * Gets intelligence non mod.
     *
     * @return the intelligence non mod
     */
    public int getIntelligenceNonMod() {
        return intelligenceNonMod;
    }

    /**
     * Sets intelligence non mod.
     *
     * @param intelligenceNonMod the intelligence non mod
     */
    public void setIntelligenceNonMod(int intelligenceNonMod) {
        this.intelligenceNonMod = intelligenceNonMod;
    }

    /**
     * Gets wisdom non mod.
     *
     * @return the wisdom non mod
     */
    public int getWisdomNonMod() {
        return wisdomNonMod;
    }

    /**
     * Sets wisdom non mod.
     *
     * @param wisdomNonMod the wisdom non mod
     */
    public void setWisdomNonMod(int wisdomNonMod) {
        this.wisdomNonMod = wisdomNonMod;
    }

    /**
     * Gets charisma non mod.
     *
     * @return the charisma non mod
     */
    public int getCharismaNonMod() {
        return charismaNonMod;
    }

    /**
     * Sets charisma non mod.
     *
     * @param charismaNonMod the charisma non mod
     */
    public void setCharismaNonMod(int charismaNonMod) {
        this.charismaNonMod = charismaNonMod;
    }

    /**
     * Sets modifer.
     *
     * @param ability the ability
     * @param value   the value
     * @return the modifer
     */
    public int setModifer(String ability, int value) {
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
