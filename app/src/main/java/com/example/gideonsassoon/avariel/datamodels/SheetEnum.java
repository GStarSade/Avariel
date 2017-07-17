package com.example.gideonsassoon.avariel.datamodels;

/**
 * Created by scorchgid on 17/07/17.
 */

public class SheetEnum {

    public enum Race {
        DRAGONBORN(0), HILL_DWARF(1), MOUNTAIN_DWARF(2), DROW_ELF(3), HIGH_ELF(4), WOOD_ELF(5), ROCK_GNOME(6), FOREST_GNOME(7), HALF_ELF(8), HALF_ORC(9), HALFLING_LIGHTFOOT(10), HALFLING_STOUT(11), HUMAN(12), TIEFLING(13);
        private int key;

        private Race(int keyValue) {
            key = keyValue;
        }

        public int getKey() {
            return key;
        }

        public static Race getEnumValue(int keyValue) {
            for (Race value : Race.values()) {
                if (value.getKey() == keyValue) {
                    return value;
                }
            }
            // didn't find it! Crash?  Error log?
            return null;
        }
    }

    public enum Language {
        COMMON(0), DRACONIC(1), DWARVISH(2), ELVISH(3), GIANT(4), GNOMISH(5), GOBLIN(6), HALFLING(7), INFERNAL(8), ORC(9);
        private int key;

        private Language(int keyValue) {
            key = keyValue;
        }

        public int getKey() {
            return key;
        }


        public static Language getEnumValue(int keyValue) {
            for (Language value : Language.values()) {
                if (value.getKey() == keyValue) {
                    return value;
                }
            }
            // didn't find it! Crash?  Error log?
            return null;
        }
    }

    public enum Class {
        BARBARIAN(0), BARD(1), CLERIC(2), DRUID(3), FIGHTER(4), MONK(5), PALADIN(6), RANGER(7), ROGUE(8), SORCERER(9), WARLOCK(10), WIZARD(11);
        private int key;

        private Class(int keyValue) {
            key = keyValue;
        }

        public int getKey() {
            return key;
        }

        public static Class getEnumValue(int keyValue) {
            for (Class value : Class.values()) {
                if (value.getKey() == keyValue) {
                    return value;
                }
            }
            // didn't find it! Crash?  Error log?
            return null;
        }
    }

    public enum Ability {
        STRENGTH(0), DEXTERITY(1), CONSTITUTION(2), INTELLIGENCE(3), WISDOM(4), CHARISMA(5);
        private int key;

        private Ability(int keyValue) {
            key = keyValue;

        }

        public int getKey() {
            return key;
        }

        public static Ability getEnumValue(int keyValue) {
            for (Ability value : Ability.values()) {
                if (value.getKey() == keyValue) {
                    return value;
                }
            }
            // didn't find it! Crash?  Error log?
            return null;

        }
    }

    public enum BarbarianSubClass {PATH_OF_THE_BERSERKER, PATH_OF_THE_TOTEM_WARRIOR}

    public enum BardSubClass {COLLEGE_OF_LORE, COLLEGE_OF_VALOR}

    public enum ClericSubClass {KNOWLEDGE_DOMAIN, LIFE_DOMAIN, LIGHT_DOMAIN, NATURE_DOMAIN, TEMPEST_DOMAIN, TRICKERY_DOMAIN, WAR_DOMAIN}

    public enum DruidSubClass {CIRCLE_OF_THE_LAND, CIRCLE_OF_THE_MOON}

    public enum FighterSubClass {BATTLEMASTER, CHAMPION, ELDRITCH_KNIGHT}

    public enum MonkSubClass {WAY_OF_SHADOW, WAY_OF_THE_FOUR_ELEMENTS, WAY_OF_THE_OPEN_HAND}

    public enum PaladinSubClass {OATH_OF_DEVOTION, OATH_OF_THE_ANCIENTS, OATH_OF_VENGEANCE}

    public enum RangerSubClass {BEAST_MASTER, HUNTER}

    public enum RogueSubClass {ARCANE_TRICKSTER, ASSASSIN, THIEF}

    public enum SorcererSubClass {DRACONIC_BLOODLINE, WILD_MAGIC}

    public enum WarlockSubClass {THE_ARCHFEY, THE_FIEND, THE_GREAT_OLD_ONE}

    public enum WizardSubClass {SCHOOL_OF_ABJURATION, SCHOOL_OF_CONJURATION, SCHOOL_OF_DIVINATION, SCHOOL_OF_ENCHANTMENT, SCHOOL_OF_EVOCATION, SCHOOL_OF_ILLUSION, SCHOOL_OF_NECROMANCY, SCHOOL_OF_TRANSMUTATION}
}

