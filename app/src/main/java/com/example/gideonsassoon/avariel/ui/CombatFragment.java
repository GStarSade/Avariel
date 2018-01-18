package com.example.gideonsassoon.avariel.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.datamodels.Sheet;
import com.example.gideonsassoon.avariel.datamodels.Weapon;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Gideon Sassoon on 21/01/2017.
 */

public class CombatFragment extends Fragment {
    private static final String TAG = CombatFragment.class.getSimpleName();
    private Realm realm;
    private Sheet sheet;
    private int loopOnChanged = 0;
    private int loopOnMain = 0;
    MainFragmentAdaptor mMainFragmentAdaptor;

    @BindView(R.id.tv_armor_class_value)
    TextView tv_armorClassValue;
    @BindView(R.id.tv_initiative_value)
    TextView tv_initiativeValue;
    @BindView(R.id.tv_speed_value)
    TextView tv_speedValue;
    @BindView(R.id.tv_hit_dice_value)
    TextView tv_hitDiceValue;
    @BindView(R.id.et_success_value)
    NumberPicker np_successValue;
    @BindView(R.id.et_failure_value)
    NumberPicker np_failureValue;
    @BindView(R.id.lv_attack_spellcasting_content)
    ListView lv_attack_spellcasting_title;
    @BindView(R.id.b_add_attack_spellcasting_row)
    Button b_add_attack_spellcasting_row;
    /* Unstable section */
    /*
    @BindView(R.id.rl_attack_spellcasting_content)
    GridLayout rl_attack_spellcasting_content;
    @BindView(R.id.b_delete_attack_spellcasting_row)
    Button b_delete_attack_spellcasting_row;*/

    /*
    TODO Name - et_name_attack_spellcasting_value
    TODO Attack Bonus - tv_abilities_bonus_value
    TODO Damage Type - s_damage_type_value
     */
    //public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_combat, container, false);
        ButterKnife.bind(this, rootView);
        realm = Realm.getDefaultInstance();
        realm.where(Sheet.class).findAll().addChangeListener(new RealmChangeListener<RealmResults<Sheet>>() {
            @Override
            public void onChange(RealmResults<Sheet> sheets) {
                addPlayerToUI(sheets.first());
            }
        });

        sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();

        np_successValue.setMinValue(0);
        np_successValue.setMaxValue(3);
        np_successValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange success value: " + hasFocus);
                if (!hasFocus) {
                    ((MainActivity) getActivity()).getRealm().executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            Sheet sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();
                            sheet.setSuccessDeathSaves(np_successValue.getValue());
                        }
                    });
                }
            }
        });
        np_failureValue.setMinValue(0);
        np_failureValue.setMaxValue(3);
        np_failureValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange failure value: " + hasFocus);
                if (!hasFocus) {
                    ((MainActivity) getActivity()).getRealm().executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            Sheet sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();
                            sheet.setFailureDeathSaves(np_failureValue.getValue());
                        }
                    });
                }
            }
        });
        //final AlertDialog.Builder[] builder = new AlertDialog.Builder[1];
        b_add_attack_spellcasting_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* https://www.mkyong.com/android/android-alert-dialog-example */
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setTitle(R.string.add_weapon_dialog_title)
                        .setMessage(R.string.add_weapon_dialog_message)
                        .setCancelable(false)
                        .setPositiveButton(R.string.yes,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        newSheetWeapon();
                                    }
                                })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                newBlankSheetWeapon();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        /*
        Attack Section
        Widgets are views too.
        */
        //Sheet sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst(); MOVED TO TOP
        //TODO you seem to be providing a list of weapons to a single entry, are you sure you've got that right!?!?
        RealmList<Weapon> weaponList = sheet.getWeaponList();
        Log.d("LOOPING LIST", "onMain called INT: " + loopOnMain);
        final AttackListViewContentAdapter attackListViewContentAdapter = new AttackListViewContentAdapter(getActivity(), sheet, realm, weaponList);
        weaponList.addChangeListener(new RealmChangeListener<RealmList<Weapon>>() {
            @Override
            public void onChange(RealmList<Weapon> weapons) {
                /* Gives the adaptor a kick to know that the weapon realm list has changed */
                Log.d("LOOPING LIST", "onChanged called INT: " + loopOnChanged);
                attackListViewContentAdapter.notifyDataSetChanged();
                loopOnChanged++;
            }
        });
        lv_attack_spellcasting_title.setAdapter(attackListViewContentAdapter);
        playerInit();
        return rootView;
    }

    private void playerInit() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                final Sheet sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //TODO find why this isn't the same as in AdventureFragment
                        addPlayerToUI(sheet);
                    }
                });
            }
        });
    }

    /**
     * https://stackoverflow.com/questions/34296748/android-realm-inserting-one-to-many-primarykey
     **/
    public void newBlankSheetWeapon() {
        Log.d("newBlankSheetWeapon: ", "START");
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Number maxValue = realm.where(Weapon.class).max("weaponID");
                int maxValueInt;
                if (maxValue != null) {
                    maxValueInt = maxValue.intValue();
                    maxValueInt = maxValueInt + 1;
                } else maxValueInt = 0;
                try {
                    sheet.getWeaponList().add(realm.createObject(Weapon.class, maxValueInt));
                } catch (Exception e) {
                    Log.e("newBlankSheetWeapon: ", "maxValue: " + maxValue + " maxValueInt: " + String.valueOf(maxValueInt) + e.toString());
                }
            }
        });
    }

    /***
     Does not follow the exact patteren but was what started me off
     * https://www.youtube.com/watch?v=Z7oekIFb7fA
     */
    private void newSheetWeapon() {
        Log.d("newSheetWeapon: ", "START");
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.custom_dialogue);
        ListView listView = (ListView) dialog.findViewById(R.id.custom_dialogue_listView);
        listView.setAdapter(new AttackDialogCustomAdapter(getContext()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO add a translated getname (So get the name of the weapon it should corresponds too).
                Log.d(TAG, "newSheetWeapon: " + String.valueOf(position));
                newSheetWeaponSubmit(position);
            }
        });
        dialog.show();
    }

    private void newSheetWeaponSubmit(int position) {
        ArrayList<Weapon> weapons = MainActivity.getWeaponDefault();
        weapons.get(position);
        Number maxValue = realm.where(Weapon.class).max("weaponID");
        int maxValueInt;
        if (maxValue != null) {
            maxValueInt = maxValue.intValue();
            maxValueInt = maxValueInt + 1;
        } else maxValueInt = 0;
        try {
            Weapon weapon = weapons.get(position);
            sheet.getWeaponList().add(realm.createObject(weapon.getClass(), maxValueInt));
        } catch (Exception e) {
            Log.e("newBlankSheetWeapon: ", "Submit, maxValue: " + maxValue + " maxValueInt: " + String.valueOf(maxValueInt) + " " + e.toString());
        }
    }

    void addPlayerToUI(Sheet sheet) {
        tv_armorClassValue.setText(String.valueOf(sheet.getDexterityModified() + 10));
        tv_initiativeValue.setText(String.valueOf(sheet.getDexterityModified()));
        tv_speedValue.setText(String.valueOf(sheet.getRaceSpeed()));
        np_failureValue.setValue(sheet.getFailureDeathSaves());
        np_successValue.setValue(sheet.getSuccessDeathSaves());
    }
}