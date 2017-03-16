package com.example.gideonsassoon.avariel.data;

/**
 * Created by Gideon Sassoon on 24/12/2016.
 */
public class Abilities {

    int Strength;
    int Dexterity;
    int Constitution;
    int Intelligence;
    int Wisdom;
    int Charisma;

    //ADD ABILITY NON MODIFER VALUES

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }

    public int getConstitution() {
        return Constitution;
    }

    public void setConstitution(int constitution) {
        Constitution = constitution;
    }

    public int getIntelligence() {
        return Intelligence;
    }

    public void setIntelligence(int intelligence) {
        Intelligence = intelligence;
    }

    public int getWisdom() {
        return Wisdom;
    }

    public void setWisdom(int wisdom) {
        Wisdom = wisdom;
    }

    public int getCharisma() {
        return Charisma;
    }

    public void setCharisma(int charisma) {
        Charisma = charisma;
    }

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
}
