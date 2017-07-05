package com.example.gideonsassoon.avariel.datamodels;

/**
 * Created by Gideon Sassoon on 13/05/2017.
 */

public class RaceHelper {

    public enum Race {
        DRAGONBORN, HILL_DWARF, MOUNTAIN_DWARF, DROW_ELF, HIGH_ELF, WOOD_ELF, GNOME, HALF_ELF, HALF_ORC, HALFLING_LIGHTFOOT, HALFLING_STOUT, HUMAN, TIEFLING
    }

    public static RaceStats getRace(Race race) {
        switch (race) {
            case DRAGONBORN:
                return getDragonborn();
            case HILL_DWARF:
                return getDwarf();
            case MOUNTAIN_DWARF:
                return getMountianDwarf();
            case DROW_ELF:
                return getDrowElf();
            case HIGH_ELF:
                return getHighElf();
            case WOOD_ELF:
                return getWoodElf();
            case GNOME:
                return getGnome();
            case HALF_ELF:
                return getHalfElf();
            case HALF_ORC:
                return getHalfOrc();
            case HALFLING_LIGHTFOOT:
                return getHalflingLightFoot();
            case HALFLING_STOUT:
                return getHalfingStout();
            case HUMAN:
                return getHuman();
            case TIEFLING:
                return getTiefling();
            default:
                throw new RuntimeException("Unsupported Race :" + race);
        }
    }

    private static RaceStats getHuman() {

        //Abilities abilities = new Abilities(1, 1, 1, 1, 1, 1);
        //Race stats class stats and your player (What you rolled)

        //Speed

        //Languages

        //int number of additional languages


        return new RaceStats(abilities);
    }

    private static RaceStats getMountianDwarf() {
        //Abilities abilities = new Abilities(2, 0, 2, 0, 0, 0);
        //Player player = new Player();
        return new RaceStats(abilities);
    }

    private static RaceStats getHighElf() {
        // Abilities abilities = new Abilities(0, 2, 0, 0, 1, 0);
        return new RaceStats(abilities);
    }
}
