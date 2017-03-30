package com.example.gideonsassoon.avariel.data;

/**
 * Created by Gideon Sassoon on 24/12/2016.
 */

public class Currency {

    /*
        Currency Names (CN)     CP	    SP	   EP       GP	    PP
        Copper piece (cp)   =	1	    1/1    1/50     1/100	1/1,000
        Silver piece (sp)   =	10	    1	   1/10     1/10	1/100
        Electrum piece (ep) =   50      5      1        1/2     1/20
        Gold piece (gp)     =	100	    10	   2        1	    1/10
        Platinum piece (pp) =	1,000	100	   20       10	    1
     */

    int copper;
    int silver;
    int electrum;
    int gold;
    int platinum;

    public int getCopper() {
        return copper;
    }

    public void setCopper(int copper) {
        this.copper = copper;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getElectrum() {
        return electrum;
    }

    public void setElectrum(int electrum) {
        this.electrum = electrum;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getPlatinum() {
        return platinum;
    }

    public void setPlatinum(int platinum) {
        this.platinum = platinum;
    }
}
