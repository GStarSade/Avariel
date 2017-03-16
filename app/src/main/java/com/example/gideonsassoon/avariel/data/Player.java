package com.example.gideonsassoon.avariel.data;

/**
 * Created by Gideon Sassoon on 16/03/2017.
 */

public class Player {

    private final int playerIdentifier;
    private final String name;
    private final String weaponsTableID;
    // TODO Add all of the components of a player here

    public Player(int playerIdentifier, String name, String weaponsTableID) {
        this.playerIdentifier = playerIdentifier;
        this.name = name;
        this.weaponsTableID = weaponsTableID; //01,06,03
    }

    public int getPlayerIdentifier() {
        return playerIdentifier;
    }

    public String getName() {
        return name;
    }
}
