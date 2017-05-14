package com.example.gideonsassoon.avariel.database;

/**
 * Created by Gideon Sassoon on 09/05/2017.
 */

import android.provider.BaseColumns;

public final class WeaponEntryContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.

    private WeaponEntryContract() {
    }

    /* Inner class that defines the table contents */
    public static class WeaponEntry implements BaseColumns {
        public static final String TABLE_NAME = "weapons";
        public static final String _ID = "_id";
        public static final String COLUMN_WEAPON_PLAYER_ID = "weaponPlayerID";
        public static final String COLUMN_WEAPON_LIB_ITEM = "weaponLibItem";
        public static final String COLUMN_WEAPON_NAME = "weaponName";
        public static final String COLUMN_WEAPON_COST = "weaponCost";
        public static final String COLUMN_WEAPON_WEIGHT = "weaponWeight";
        public static final String COLUMN_WEAPON_PROPERTIES_ADDITIONAL = "weaponPropertiesAdditional";
        public static final String COLUMN_WEAPON_STAT_BONUS = "weaponStatBonus";
        public static final String COLUMN_WEAPON_RANGE_NORMAL = "weaponRangeNormal";
        public static final String COLUMN_WEAPON_RANGE_LONG = "weaponRangeLond";
        public static final String COLUMN_WEAPON_DAMAGE_DIE_TYPE = "weaponDamageDieType";
        public static final String COLUMN_WEAPON_DAMAGE_NUMBER_OF_DIE = "weaponDamageNumberOfDie";
        public static final String COLUMN_WEAPON_DAMAGE_DIE_TYPE_VERSATILE = "weaponDamageDieTypeVersatile";
        public static final String COLUMN_WEAPON_DAMAGE_NUMBER_OF_DIE_VERSATILE = "weaponDamageNumberOfDieVersatile";
        public static final String COLUMN_WEAPON_DAMAGE_ADDITIONAL = "weaponDamageAdditional";
        public static final String COLUMN_WEAPON_DAMAGE_TYPE = "weaponDamageType";
    }
}
