package com.example.gideonsassoon.avariel.datamodels;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gideon Sassoon on 20/03/2017.
 * A player can have multiple PALs. Pol is if this is a language or if it is not.
 */

public class ProficienciesAndLanguages extends RealmObject {
    @PrimaryKey
    String pALName;
    boolean pOL;

    public static ProficienciesAndLanguages createProficienciesAndLanguages(String pALName, boolean pOL) {
        return new ProficienciesAndLanguages(pALName, pOL);
    }

    public String getpALName() {
        return pALName;
    }

    public void setpALName(String pALName) {
        this.pALName = pALName;
    }

    public boolean ispOL() {
        return pOL;
    }

    public void setpOL(boolean pOL) {
        this.pOL = pOL;
    }

    private ProficienciesAndLanguages(String pALName, boolean pOL) {
        this.pALName = pALName;
        this.pOL = pOL;
    }

    public ProficienciesAndLanguages() {
    }
}
