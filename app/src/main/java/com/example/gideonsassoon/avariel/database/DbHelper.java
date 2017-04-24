package com.example.gideonsassoon.avariel.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gideonsassoon.avariel.data.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.gideonsassoon.avariel.database.PlayerEntryContract.PlayerEntry;

/**
 * Created by Gideon Sassoon on 16/03/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "PlayerData.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PlayerEntry.TABLE_NAME + " (" +
                    PlayerEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PlayerEntry.COLUMN_UUID + " TEXT, " +
                    PlayerEntry.COLUMN_NAME + " TEXT, " +
                    PlayerEntry.COLUMN_BACKGROUND + " TEXT, " +
                    PlayerEntry.COLUMN_PLAYER_NAME + " TEXT, " +
                    PlayerEntry.COLUMN_RACE + " TEXT, " +
                    PlayerEntry.COLUMN_ALIGNMENT + " TEXT, " +
                    PlayerEntry.COLUMN_EXPERIENCE_POINTS + " INTEGER, " +
                    PlayerEntry.COLUMN_ABILITIES_TABLEID + " TEXT, " +
                    PlayerEntry.COLUMN_SKILLS_TABLEID + " TEXT, " +
                    PlayerEntry.COLUMN_COMBAT_TABLEID + " TEXT, " +
                    PlayerEntry.COLUMN_WEAPONS_TABLEID + " TEXT, " +
                    PlayerEntry.COLUMN_MAGIC_TABLEID + " TEXT, " +
                    PlayerEntry.COLUMN_EQUIPMENT_TABLEID + " TEXT, " +
                    PlayerEntry.COLUMN_CURRENCY_TABLEID + " TEXT, " +
                    PlayerEntry.COLUMN_ARMOR_TABLEID + " TEXT, " +
                    PlayerEntry.COLUMN_PROFICIENCIES_LANGUAGES_TABLEID + " TEXT, " +
                    PlayerEntry.COLUMN_FEATURES_TRAITS_TABLEID + " TEXT, " +
                    PlayerEntry.COLUMN_TRAITS_TABLEID + " TEXT )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PlayerEntry.TABLE_NAME;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public long createNewPlayer(String playerNameParam,
                                String playerBackgroundParam,
                                String playerRaceParam,
                                String playerAlignmentParam,
                                String playerPlayerNameParam) {
        SQLiteDatabase database = getWritableDatabase();
        String playerUUID = UUID.randomUUID().toString();
        String abilitiesID = "ABILITIES_" + playerUUID;
        String skillsID = "SKILLS_" + playerUUID;
        String combatID = "COMBAT_" + playerUUID;
        String weaponsID = "WEAPONS_" + playerUUID;
        String magicID = "MAGIC_" + playerUUID;
        String equipmentID = "EQUIPMENT_" + playerUUID;
        String currencyID = "CURRENCY_" + playerUUID;
        String armorID = "ARMOR_" + playerUUID;
        String proficienciesAndLanguagesID = "PROFICIENCIES_LANGUAGES_" + playerUUID;
        String featuresTraitsID = "FEATURES_TRAITS_" + playerUUID;
        String traitsID = "TRAITS_" + playerUUID;
        // TODO: New value for one column
        ContentValues values = new ContentValues();
        values.put(PlayerEntry.COLUMN_UUID, playerUUID);
        values.put(PlayerEntry.COLUMN_NAME, playerNameParam);
        values.put(PlayerEntry.COLUMN_BACKGROUND, playerBackgroundParam);
        values.put(PlayerEntry.COLUMN_PLAYER_NAME, playerPlayerNameParam);
        values.put(PlayerEntry.COLUMN_RACE, playerRaceParam);
        values.put(PlayerEntry.COLUMN_ALIGNMENT, playerAlignmentParam);
        values.put(PlayerEntry.COLUMN_EXPERIENCE_POINTS, 0);
        values.put(PlayerEntry.COLUMN_ABILITIES_TABLEID, abilitiesID);
        values.put(PlayerEntry.COLUMN_SKILLS_TABLEID, skillsID);
        values.put(PlayerEntry.COLUMN_COMBAT_TABLEID, combatID);
        values.put(PlayerEntry.COLUMN_WEAPONS_TABLEID, weaponsID);
        values.put(PlayerEntry.COLUMN_MAGIC_TABLEID, magicID);
        values.put(PlayerEntry.COLUMN_EQUIPMENT_TABLEID, equipmentID);
        values.put(PlayerEntry.COLUMN_CURRENCY_TABLEID, currencyID);
        values.put(PlayerEntry.COLUMN_ARMOR_TABLEID, armorID);
        values.put(PlayerEntry.COLUMN_PROFICIENCIES_LANGUAGES_TABLEID, proficienciesAndLanguagesID);
        values.put(PlayerEntry.COLUMN_FEATURES_TRAITS_TABLEID, featuresTraitsID);
        values.put(PlayerEntry.COLUMN_TRAITS_TABLEID, traitsID);

        // TODO: put other default values
        // TODO: Insert the new row, returning the primary key value of the new row
        return database.insert(PlayerEntry.TABLE_NAME, null, values);
    }


    public ArrayList<Player> getListOfPlayers() {
        List<String> listOfPlayerIDs = new ArrayList<>();
        SQLiteDatabase database = getWritableDatabase();
        String[] projection = {
                PlayerEntry._ID,
        };
        String sortOrder = PlayerEntry._ID + " DESC";
        Cursor cursor = database.query(
                PlayerEntry.TABLE_NAME,                     // The table to query
                projection,                                 // The columns to return
                PlayerEntry._ID + "=?",                     // The columns for the WHERE clause
                null,                                       // The values for the WHERE clause
                null,                                       // don't group the rows
                null,                                       // don't filter by row groups
                sortOrder                                   // The sort order
        );
        cursor.moveToFirst();
        for (int i = 0; i <= cursor.getCount(); cursor.moveToNext()) {
            listOfPlayerIDs.add(cursor.getString(0));
            // Log Info should go here
        }
        cursor.close();

        ArrayList<Player> listOfPlayers = new ArrayList<>();
        for (String id : listOfPlayerIDs) {

        }

        for (int i = 0; i < cursor.getCount(); cursor.moveToNext()) {
            /*String playerIdentifier = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry._ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_NAME));
            String playerName = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_PLAYER_NAME));
            listOfPlayers.add(i, );
*/
        }
        return null;
    }

    //TODO You will need a class similar to this for getWeapons, (Obviously the whole class, this is just an anchor memory)
    public Player getPlayer(long playerID) {
        SQLiteDatabase database = getWritableDatabase();
        // TODO: Define a projection that specifies which columns from the database
        // TODO: you will actually use after this query.
        String[] projection = {
                PlayerEntry._ID,
                PlayerEntry.COLUMN_UUID,
                PlayerEntry.COLUMN_NAME,
                PlayerEntry.COLUMN_BACKGROUND,
                PlayerEntry.COLUMN_PLAYER_NAME,
                PlayerEntry.COLUMN_RACE,
                PlayerEntry.COLUMN_ALIGNMENT,
                PlayerEntry.COLUMN_EXPERIENCE_POINTS,
                PlayerEntry.COLUMN_ABILITIES_TABLEID,
                PlayerEntry.COLUMN_SKILLS_TABLEID,
                PlayerEntry.COLUMN_COMBAT_TABLEID,
                PlayerEntry.COLUMN_WEAPONS_TABLEID,
                PlayerEntry.COLUMN_MAGIC_TABLEID,
                PlayerEntry.COLUMN_EQUIPMENT_TABLEID,
                PlayerEntry.COLUMN_CURRENCY_TABLEID,
                PlayerEntry.COLUMN_ARMOR_TABLEID,
                PlayerEntry.COLUMN_PROFICIENCIES_LANGUAGES_TABLEID,
                PlayerEntry.COLUMN_FEATURES_TRAITS_TABLEID,
                PlayerEntry.COLUMN_TRAITS_TABLEID,
        };
        // TODO: projection other column values
        // How you want the results sorted, in the resulting Cursor
        String sortOrder = PlayerEntry._ID + " DESC";
        Cursor cursor = database.query(
                PlayerEntry.TABLE_NAME,                     // The table to query
                projection,                                 // The columns to return
                PlayerEntry._ID + "=?",                     // The columns for the WHERE clause
                new String[]{String.valueOf(playerID)},     // The values for the WHERE clause
                null,                                       // don't group the rows
                null,                                       // don't filter by row groups
                sortOrder                                   // The sort order
        );
        cursor.moveToFirst();

        long playerIdentifier = cursor.getLong(cursor.getColumnIndexOrThrow(PlayerEntry._ID));
        String uuid = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_UUID));
        String name = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_NAME));
        String background = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_BACKGROUND));
        String playerName = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_PLAYER_NAME));
        String race = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_RACE));
        String alignment = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_ALIGNMENT));
        int experiencePoints = cursor.getInt(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_EXPERIENCE_POINTS));
        String abilitiesTableID = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_ABILITIES_TABLEID));
        String skillsTableID = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_SKILLS_TABLEID));
        String combatTableID = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_COMBAT_TABLEID));
        String weaponsTableID = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_WEAPONS_TABLEID));
        String magicTableID = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_MAGIC_TABLEID));
        String equipmentTableID = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_EQUIPMENT_TABLEID));
        String currencyTableID = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_CURRENCY_TABLEID));
        String armorTableID = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_ARMOR_TABLEID));
        String proficienciesAndLanguagesTableID = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_PROFICIENCIES_LANGUAGES_TABLEID));
        String featuresAndTraitsTableID = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_FEATURES_TRAITS_TABLEID));
        String traitsTableID = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_TRAITS_TABLEID));

        // TODO: access other values, add other values, DO THIS IF YOU ARE STRESSING OUT! SIMPLES.
        // String csvWeapons = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_WEAPONS_TABLEID));
        // List<Weapon> weapons =;
        cursor.close();
        return new Player(playerIdentifier, uuid, name, background, playerName,
                race, alignment, experiencePoints,
                abilitiesTableID, skillsTableID, combatTableID,
                weaponsTableID, magicTableID,
                equipmentTableID, currencyTableID, armorTableID,
                proficienciesAndLanguagesTableID,
                featuresAndTraitsTableID, traitsTableID);
    }

    public void updatePlayer(Player player) {
        SQLiteDatabase db = getReadableDatabase();

        // TODO: New value for one column
        ContentValues values = new ContentValues();
        values.put(PlayerEntry.COLUMN_NAME, player.getName());
        // TODO: put other player fields into values
        // Which row to update, based on the title
        String selection = "_id=" + PlayerEntry._ID;

        db.update(PlayerEntry.TABLE_NAME, values, selection, null);
    }

    public void setPlayerName(String value) {
//        // Gets the data repository in write mode
//        SQLiteDatabase database = getWritableDatabase();
//        // Create a new map of values, where column names are the keys
//        ContentValues values = new ContentValues();
//        values.put(FeedEntry.COLUMN_NAME_TITLE, title);
//        values.put(FeedEntry.COLUMN_NAME_SUBTITLE, subtitle);
//        // Insert the new row, returning the primary key value of the new row
//        long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);
    }
}