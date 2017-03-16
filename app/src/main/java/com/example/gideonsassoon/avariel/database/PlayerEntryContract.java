package com.example.gideonsassoon.avariel.database;

import android.provider.BaseColumns;

/**
 * Created by Gideon Sassoon on 16/03/2017.
 */

public final class PlayerEntryContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.

    private PlayerEntryContract() {}

    /* Inner class that defines the table contents */
    public static class PlayerEntry implements BaseColumns {
        public static final String TABLE_NAME = "player";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_WEAPONS = "weapons";
    }
}