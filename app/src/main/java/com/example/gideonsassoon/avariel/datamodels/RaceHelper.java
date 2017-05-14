package com.example.gideonsassoon.avariel.datamodels;

/**
 * Created by Gideon Sassoon on 13/05/2017.
 */

public class RaceHelper {

    public enum Race {
        HUMAN, MOUNTAIN_DWARF, HIGH_ELF
    }

    public static RaceStats getRace(Race race) {
        switch (race) {
            case HUMAN:
                return getHuman();
            case MOUNTAIN_DWARF:
                return getMountianDwarf();
            case HIGH_ELF:
                return getHighElf();
            default:
                throw new RuntimeException("Unsupported Race :" + race);
        }
    }

    private static RaceStats getHuman() {

        Abilities abilities = new Abilities(1, 1, 1, 1, 1, 1);
        //Race stats class stats and your player (What you rolled)

        //Size

        //Speed

        //Languages

        //int number of additional languages

        return new RaceStats(abilities);
    }

    private static RaceStats getMountianDwarf() {
        Abilities abilities = new Abilities(2, 0, 2, 0, 0, 0);
        //Player player = new Player();
        return new RaceStats(abilities);
    }

    private static RaceStats getHighElf() {
        Abilities abilities = new Abilities(0, 2, 0, 0, 1, 0);
        return new RaceStats(abilities);
    }
}
