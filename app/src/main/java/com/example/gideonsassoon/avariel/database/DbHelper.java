package com.example.gideonsassoon.avariel.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gideonsassoon.avariel.data.Player;

import static com.example.gideonsassoon.avariel.database.PlayerEntryContract.PlayerEntry;

/**
 * Created by Gideon Sassoon on 16/03/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "PlayerData.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PlayerEntry.TABLE_NAME + " (" +
                    PlayerEntry._ID + " INTEGER PRIMARY KEY," +
                    PlayerEntry.COLUMN_NAME + " TEXT)" +
                    PlayerEntry.COLUMN_WEAPONS + " TEXT)";

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

    public long createNewPlayer() {
        SQLiteDatabase database = getWritableDatabase();
        // New value for one column
        ContentValues values = new ContentValues();
        values.put(PlayerEntry.COLUMN_NAME, "");
        // TODO: put other default values
        // Insert the new row, returning the primary key value of the new row
        return database.insert(PlayerEntry.TABLE_NAME, null, values);
    }

    public void updatePlayer(Player player) {
        //TODO ADD JEREMY CODE!!!!!!!
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


    //TODO You will need a class similar to this for getWeapons, (Obviously the whole class, this is just an anchor memory)
    public Player getPlayer(long playerID) {
        SQLiteDatabase database = getWritableDatabase();
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                PlayerEntry._ID,
                PlayerEntry.COLUMN_NAME,
        };
        // TODO: projection other column values
        // How you want the results sorted in the resulting Cursor
        String sortOrder = PlayerEntry._ID + " DESC";
        Cursor cursor = database.query(
                PlayerEntry.TABLE_NAME,                     // The table to query
                projection,                                 // The columns to return
                "_id=",                                     // The columns for the WHERE clause
                new String[]{String.valueOf(playerID)},     // The values for the WHERE clause
                null,                                       // don't group the rows
                null,                                       // don't filter by row groups
                sortOrder                                   // The sort order
        );
        cursor.moveToFirst();

        int playerIdentifier = cursor.getInt(cursor.getColumnIndexOrThrow(PlayerEntry._ID));
        String playerName = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_NAME));
        String weaponsTableID = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_WEAPONS));
        // TODO: access other values, add other values
        // String csvWeapons = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_WEAPONS));
        // List<Weapon> weapons =;
        cursor.close();
        return new Player(playerIdentifier, playerName, weaponsTableID);
        //return new Player(playerIdentifier, playerName, weapons);
    }
}