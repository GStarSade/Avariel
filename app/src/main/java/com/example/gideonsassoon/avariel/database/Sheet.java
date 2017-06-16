package com.example.gideonsassoon.avariel.database;

import android.app.Activity;

import com.example.gideonsassoon.avariel.datamodels.Player;

import io.realm.Realm;

/**
 * Created by Gideon Sassoon on 10/06/2017.
 */

public class Sheet extends Activity {

    private Realm realm;
    public Player player;

    public void createSetPlayerAbilityValues(int strengthNonMod, int dexterityNonMod, int constitutionNonMod, int intelligenceNonMod, int wisdomNonMod, int charismaNonMod) {
        player = new Player();
        player.createPlayerChild();
        player.getAbilities().setStrengthNonMod(strengthNonMod);
        player.getAbilities().setDexterityNonMod(dexterityNonMod);
        player.getAbilities().setConstitutionNonMod(constitutionNonMod);
        player.getAbilities().setIntelligenceNonMod(intelligenceNonMod);
        player.getAbilities().setWisdomNonMod(wisdomNonMod);
        player.getAbilities().setCharismaNonMod(charismaNonMod);
    }

    public void setPlayerSkills() {
        player.getSkills().setValues(player.getAbilities());
    }

    public void setArmorClassBase(){
        player.getCombat().setArmorClassBase(player.getAbilities().getDexterity());
    }

    public Player getPlayer() {
        return player;
    }
}