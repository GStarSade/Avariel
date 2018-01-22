package com.example.gideonsassoon.avariel.datamodels;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gideon on 18/01/2018.
 */

public class Proficiencies extends RealmObject {

    @PrimaryKey
    int proficienciesID;

    private String proficienciesName;

    public int getProficienciesID() {
        return proficienciesID;
    }

    public void setProficienciesID(int proficienciesID) {
        this.proficienciesID = proficienciesID;
    }

    public String getProficienciesName() {
        return proficienciesName;
    }

    public void setProficienciesName(String proficienciesName) {
        this.proficienciesName = proficienciesName;
    }
}
