package com.example.gideonsassoon.avariel.database;

import android.provider.BaseColumns;

/**
 * Created by Gideon Sassoon on 04/05/2017.
 * Saving Data in SQL Databases - Define a Schema and Contract
 */


public final class AbilitiesEntryContract {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.

    private AbilitiesEntryContract() {
    }

    /* Inner class that defines the table contents */
    public static class AbilityEntry implements BaseColumns {
        public static final String TABLE_NAME = "abilities";
        public static final String _ID = "_id";
        public static final String STRENGTH = "strength";
        public static final String DEXTERITY = "dexterity";
        public static final String CONSTITUTION = "constitution";
        public static final String INTELLIGENCE = "intelligence";
        public static final String WISDOM = "wisdom";
        public static final String CHARISMA = "charisma";
        public static final String STRENGTH_NONMOD = "strengthNonMod";
        public static final String DEXTERITY_NONMOD = "dexterityNonMod";
        public static final String CONSTITUTION_NONMOD = "constitutionNonMod";
        public static final String INTELLIGENCE_NONMOD = "intelligenceNonMod";
        public static final String WISDOM_NONMOD = "wisdomNonMod";
        public static final String CHARISMA_NONMOD = "charismaNonMod";
    }
}
