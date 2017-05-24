package com.example.gideonsassoon.avariel.datamodels;

import io.realm.RealmObject;

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

public class RaceStats extends RealmObject {

    int speed; //Measurement is in feet
    Abilities abilities;

    public RaceStats() {
    }

    private RaceStats(int speed, Abilities abilities) {

        this.speed = speed;
        this.abilities = abilities;
    }

    RaceStats(Abilities abilities) {
        this.abilities = abilities;
    }

    public static RaceStats createRaceStats(int speed, Abilities abilities) {
        return new RaceStats(speed, abilities);
    }

    public Abilities getAbilities() {
        return abilities;
    }
}


