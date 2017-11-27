package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.datamodels.Sheet;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by Gideon Sassoon on 21/01/2017.
 */

public class MiscFragment extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Sheet sheet;
    private Realm realm;

    @BindView(R.id.et_personality_trait)
    EditText et_personality_trait;
    @BindView(R.id.et_ideals)
    EditText et_ideals;
    @BindView(R.id.et_bonds)
    EditText et_bonds;
    @BindView(R.id.et_flaws)
    EditText et_flaws;
    @BindView(R.id.et_platinum)
    EditText et_platinum;
    @BindView(R.id.et_gold)
    EditText et_gold;
    @BindView(R.id.et_electrum)
    EditText et_electrum;
    @BindView(R.id.et_silver)
    EditText et_silver;
    @BindView(R.id.et_copper)
    EditText et_copper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_misc, container, false);
        ButterKnife.bind(this, rootView);
        realm = Realm.getDefaultInstance();
        realm.where(Sheet.class).findAll().addChangeListener(new RealmChangeListener<RealmResults<Sheet>>() {
            @Override
            public void onChange(RealmResults<Sheet> sheets) {
                addPlayerToUI(sheets.first());
            }
        });
        sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();

        et_personality_trait.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange personality trait value: " + hasFocus);
                if (!hasFocus) {
                    final String personalityTrait = ((EditText) v).getText().toString();
                    try{
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setPersonalityTraits(personalityTrait);
                            }
                        });
                    }catch (Exception e){
                        Log.e("REALM SET PER.TR ERROR ", e.toString());
                    }
                }
            }
        });
        et_ideals.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange ideals value: " + hasFocus);
                if (!hasFocus) {
                    final String ideals = ((EditText) v).getText().toString();
                    try{
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setIdeals(ideals);
                            }
                        });
                    }catch (Exception e){
                        Log.e("REALM SET IDEALS ERROR ", e.toString());
                    }
                }
            }
        });
        et_bonds.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange bonds value: " + hasFocus);
                if (!hasFocus) {
                    final String bonds = ((EditText) v).getText().toString();
                    try{
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setBonds(bonds);
                            }
                        });
                    }catch (Exception e){
                        Log.e("REALM SET BONDS ERROR ", e.toString());
                    }
                }
            }
        });

        et_flaws.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange flaws value: " + hasFocus);
                if (!hasFocus) {
                    final String flaws = ((EditText) v).getText().toString();
                    try{
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                sheet.setFlaws(flaws);
                            }
                        });
                    }catch (Exception e){
                        Log.e("REALM SET FLAWS ERROR ", e.toString());
                    }
                }
            }
        });
        et_platinum.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange platinum: " + hasFocus);
                if (!hasFocus) {
                    final String platinumString = ((EditText) v).getText().toString();
                    final int platinum = Integer.parseInt(platinumString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setPlatinumCoins(platinum);
                        }
                    });
                }
            }
        });

        et_gold.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange gold: " + hasFocus);
                if (!hasFocus) {
                    final String goldString = ((EditText) v).getText().toString();
                    final int gold = Integer.parseInt(goldString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setGoldCoins(gold);
                        }
                    });
                }
            }
        });

        et_electrum.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange electrum: " + hasFocus);
                if (!hasFocus) {
                    final String electrumString = ((EditText) v).getText().toString();
                    final int electrum = Integer.parseInt(electrumString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setElectrumCoins(electrum);
                        }
                    });
                }
            }
        });

        et_silver.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange silver: " + hasFocus);
                if (!hasFocus) {
                    final String silverString = ((EditText) v).getText().toString();
                    final int silver = Integer.parseInt(silverString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setSilverCoins(silver);
                        }
                    });
                }
            }
        });

        et_copper.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange copper: " + hasFocus);
                if (!hasFocus) {
                    final String copperString = ((TextView) v).getText().toString();
                    final int copper = Integer.parseInt(copperString);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setCopperCoins(copper);
                        }
                    });
                }
            }
        });
        return rootView;
    }
    void addPlayerToUI(Sheet sheet) {
        et_personality_trait.setText(sheet.getPersonalityTraits());
        et_ideals.setText(sheet.getIdeals());
        et_bonds.setText(sheet.getBonds());
        et_flaws.setText(sheet.getFlaws());
        et_platinum.setText(String.valueOf(sheet.getPlatinumCoins()));
        et_gold.setText(String.valueOf(sheet.getGoldCoins()));
        et_electrum.setText(String.valueOf(sheet.getElectrumCoins()));
        et_silver.setText(String.valueOf(sheet.getSilverCoins()));
        et_copper.setText(String.valueOf(sheet.getCopperCoins()));
    }

}
