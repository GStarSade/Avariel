package com.example.gideonsassoon.avariel.database;

import android.provider.BaseColumns;

public final class PlayerEntryContract {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    //Spells and Weapons no longer have IDs to allow standard game items to be in one place.

    private PlayerEntryContract() {
    }

    /* Inner class that defines the table contents */
    public static class PlayerEntry implements BaseColumns {
        public static final String TABLE_NAME = "player";
        public static final String _ID = "_id";
        public static final String COLUMN_UUID = "uuid";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_BACKGROUND = "background";
        public static final String COLUMN_PLAYER_NAME = "playerName";
        public static final String COLUMN_RACE_NAME = "race";
        public static final String COLUMN_ALIGNMENT = "alignment";
        public static final String COLUMN_PLAYER_CLASS = "playerClass";
        public static final String COLUMN_CURRENT_HP = "currentHP";
        public static final String COLUMN_TOTAL_HP = "totalHP";
        public static final String COLUMN_EXPERIENCE_POINTS = "experiencePoints";
        public static final String COLUMN_ABILITIES_TABLEID = "abilitiesID";
        public static final String COLUMN_SKILLS_TABLEID = "skillsID";
        public static final String COLUMN_COMBAT_TABLEID = "combatID";
        public static final String COLUMN_EQUIPMENT_TABLEID = "equipmentID";
        public static final String COLUMN_CURRENCY_TABLEID = "currencyID";
        public static final String COLUMN_ARMOR_TABLEID = "armorID";
        public static final String COLUMN_PROFICIENCIES_LANGUAGES_TABLEID = "proficienciesAndLanguagesID";
        public static final String COLUMN_FEATURES_TRAITS_TABLEID = "featuresAndTraitsID";
        public static final String COLUMN_TRAITS_TABLEID = "traitsID";
    }
}