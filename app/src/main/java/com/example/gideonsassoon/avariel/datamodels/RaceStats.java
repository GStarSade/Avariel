package com.example.gideonsassoon.avariel.datamodels;

/**
 * Created by Gideon Sassoon on 13/05/2017.
 */

/*

An object that describes each attributes and modifies
    Dwarf
    Elf
    Human
    Half-Orc

    A class someewhere
 */

public class RaceStats { //implements RealmObject

    int speed; //Measurement is in feet
    Abilities abilities;

    RaceStats(Abilities abilities) {
        this.abilities = abilities;
    }

    public Abilities getAbilities() {
        return abilities;
    }
}


