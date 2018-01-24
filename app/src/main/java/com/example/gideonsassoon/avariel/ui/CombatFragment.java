package com.example.gideonsassoon.avariel.ui;

import android.app.AlertDialog;
import android.app.Dialog;
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

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_combat, container, false);
        ButterKnife.bind(this, rootView);
        realm = Realm.getDefaultInstance();
        /* Changed to two lines so that it wont be garbage collected */
        RealmResults<Sheet> sheetResults = realm.where(Sheet.class).findAll();
        sheetResults.addChangeListener(new RealmChangeListener<RealmResults<Sheet>>() {
            @Override
            public void onChange(RealmResults<Sheet> sheets) {
                addPlayerToUI(sheets.first());
            }
        });
        sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();
        np_successValue.setMinValue(0);
        np_successValue.setMaxValue(3);
        np_successValue.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.d(TAG, "onFocusChange success value, oldVal: " + oldVal + " newVal: " + newVal);
                if (!String.valueOf(oldVal).equals(String.valueOf(newVal))) {
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
        np_failureValue.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.d(TAG, "onFocusChange failure value, oldVal: " + oldVal + " newVal: " + newVal);
                if (!String.valueOf(oldVal).equals(String.valueOf(newVal))) {
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
                        .setPositiveButton(R.string.dDWeapon,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        newSheetWeapon();
                                    }
                                })
                        .setNegativeButton(R.string.blankWeapon, new DialogInterface.OnClickListener() {
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
        */        /*
            ContentAdapters
            hold a reference to a list of data
            and provide the means for a list view to populate itself from the adapter
            the two are linked
         */
        RealmList<Weapon> weaponList = sheet.getWeaponList();
        int loopOnMain = 0;
        Log.d(TAG, "LOOPING LIST, onMain called INT: " + loopOnMain);
        final AttackListViewContentAdapter attackListViewContentAdapter = new AttackListViewContentAdapter(getActivity(), realm, weaponList);
        weaponList.addChangeListener(new RealmChangeListener<RealmList<Weapon>>() {
            @Override
            public void onChange(RealmList<Weapon> weapons) {
                /* Gives the adaptor a kick to know that the weapon realm list has changed */
                Log.d(TAG, "LOOPING LIST, onChanged called INT: " + loopOnChanged);
                attackListViewContentAdapter.notifyDataSetChanged();
                loopOnChanged++;
            }
        });
        lv_attack_spellcasting_title.setAdapter(attackListViewContentAdapter);
        return rootView;
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
                    maxValueInt += 1;
                } else maxValueInt = 0;
                try {
                    sheet.getWeaponList().add(realm.createObject(Weapon.class, maxValueInt));
                } catch (Exception e) {
                    Log.e(TAG, "newBlankSheetWeapon: maxValue: " + maxValue + " maxValueInt: " + String.valueOf(maxValueInt), e);
                }
            }
        });
    }

    /***
     Does not follow the exact pattern but was what started me off
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
                Log.d(TAG, "newSheetWeapon: " + String.valueOf(position));
                newSheetWeaponSubmit(position);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void newSheetWeaponSubmit(final int position) {
        final ArrayList<Weapon> weapons = MainActivity.getWeaponDefault();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Number maxValue = realm.where(Weapon.class).max("weaponID");
                int maxValueInt;
                if (maxValue != null) {
                    maxValueInt = maxValue.intValue();
                    maxValueInt += 1;
                } else maxValueInt = 0;
                try {
                    Weapon weapon = weapons.get(position);
                    Weapon newRealmWeapon = realm.createObject(weapon.getClass(), maxValueInt);
                    newRealmWeapon.setWeaponName(weapon.getWeaponName());
                    newRealmWeapon.setWeaponDamageNumberOfDie(weapon.getWeaponDamageNumberOfDie());
                    newRealmWeapon.setWeaponDamageDieType(weapon.getWeaponDamageDieType());
                    newRealmWeapon.setWeaponDamageType(weapon.getDamageType());
                    newRealmWeapon.setWeaponAbilityBonus(weapon.getWeaponAbilityBonus());
                    newRealmWeapon.setWeaponPropertiesAdditional(weapon.getWeaponPropertiesAdditional());
                    sheet.getWeaponList().add(newRealmWeapon);
                } catch (Exception e) {
                    Log.e(TAG, "newBlankSheetWeaponSubmit, maxValue: " + maxValue + " maxValueInt: " + String.valueOf(maxValueInt) + " ", e);
                }
            }
        });
    }

    private void addPlayerToUI(Sheet sheet) {
        tv_armorClassValue.setText(String.valueOf(sheet.getDexterityModified() + 10));
        tv_initiativeValue.setText(String.valueOf(sheet.getDexterityModified()));
        tv_speedValue.setText(String.valueOf(sheet.getRaceSpeed()));
        np_failureValue.setValue(sheet.getFailureDeathSaves());
        np_successValue.setValue(sheet.getSuccessDeathSaves());
    }
}