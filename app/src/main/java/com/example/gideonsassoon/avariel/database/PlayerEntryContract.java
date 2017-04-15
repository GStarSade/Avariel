package com.example.gideonsassoon.avariel.database;

import android.provider.BaseColumns;

/**
 * Created by Gideon Sassoon on 16/03/2017.
 * Saving Data in SQL Databases - Define a Schema and Contract
 */

public final class PlayerEntryContract {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.

    private PlayerEntryContract() {}

    /* Inner class that defines the table contents */
    public static class PlayerEntry implements BaseColumns {
        public static final String TABLE_NAME = "player";
        public static final String _ID = "_id";
        public static final String COLUMN_UUID = "uuid";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_BACKGROUND = "background";
        public static final String COLUMN_PLAYER_NAME = "playerName";
        public static final String COLUMN_RACE = "race";
        public static final String COLUMN_ALIGNMENT = "alignment";
        public static final String COLUMN_EXPERIENCE_POINTS = "experiencePoints";
        public static final String COLUMN_ABILITIES_TABLEID = "abilitiesID";
        public static final String COLUMN_SKILLS_TABLEID = "skillsID";
        public static final String COLUMN_COMBAT_TABLEID = "combatID";
        public static final String COLUMN_WEAPONS_TABLEID = "weaponsID";
        public static final String COLUMN_MAGIC_TABLEID = "magicID";
        public static final String COLUMN_EQUIPMENT_TABLEID = "equipmentID";
        public static final String COLUMN_CURRENCY_TABLEID = "currencyID";
        public static final String COLUMN_ARMOR_TABLEID = "armorID";
        public static final String COLUMN_PROFICIENCIES_LANGUAGES_TABLEID= "proficienciesAndLanguages";
        public static final String COLUMN_FEATURES_TRAITS_TABLEID = "featuresAndTraits";
        public static final String COLUMN_TRAITS_TABLEID = "traits";
    }
}