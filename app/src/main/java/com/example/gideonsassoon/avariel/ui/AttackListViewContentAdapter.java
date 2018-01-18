package com.example.gideonsassoon.avariel.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.datamodels.Sheet;
import com.example.gideonsassoon.avariel.datamodels.Weapon;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Gideon on 28/10/2017.
 */

public class AttackListViewContentAdapter extends ArrayAdapter<Weapon> {

    private static final String TAG = AttackListViewContentAdapter.class.getSimpleName();
    private final Sheet sheet;
    private Realm realm;
    private Weapon weapon;

    private Button b_delete_attack_row;
    private EditText et_name_value;
    private TextView tv_attack_bonus_value;
    private NumberPicker np_damage_number_of_die_value;
    private Spinner s_damage_die_type_value;
    private Spinner s_damage_type_value;
    private Spinner s_ability_bonus_value;

    public AttackListViewContentAdapter(Context context, Sheet sheet, Realm realm, List<Weapon> weaponList) {
        super(context, 0, weaponList);
        this.sheet = sheet;
        this.realm = realm;
    }

    /*
    * GridView Adaptor is now ListView
    * As the adaptor adds views to the list, it calls getivew in order to know what to put at the view.
    * Context is an android real core component of android.
    * A root context of an android app is the application context.
    * Each activity also has a context. And lasts for the lifecycle of that activity
    * Accessing system services and system resources
    * Activity extends context (so it is a type of context)
    * Inflater - give me an xml and return an android view.
    * ViewGroup - an android view container. Examples are LineaLayout, RelativeLayout
     */

    @Override
    @NonNull
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("LoopChecker Start", "Loop checker is at: " + position);
        weapon = getItem(position);
        //Integer[] diceType = new Integer[]{4, 6, 8, 10, 12, 20, 100};

        if (convertView == null)
            //Because you're returning the view (AttachToRoot is false) the ArrayAdaptor (This class) will handle adding the view to the list.
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.attack_list_item, parent, false);

        b_delete_attack_row = (Button) convertView.findViewById(R.id.b_delete_attack_row);
        et_name_value = (EditText) convertView.findViewById(R.id.et_name_value);
        tv_attack_bonus_value = (TextView) convertView.findViewById(R.id.tv_abilities_bonus_value);
        np_damage_number_of_die_value = (NumberPicker) convertView.findViewById(R.id.np_damage_number_of_die_value);
        s_damage_die_type_value = (Spinner) convertView.findViewById(R.id.s_damage_die_type_value);
        s_damage_type_value = (Spinner) convertView.findViewById(R.id.s_damage_type_value);
        s_ability_bonus_value = (Spinner) convertView.findViewById(R.id.s_ability_bonus);

        np_damage_number_of_die_value.setMinValue(1);
        np_damage_number_of_die_value.setMaxValue(20);

        b_delete_attack_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        weapon.deleteFromRealm();
                    }
                });
            }
        });

        et_name_value.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange weapon name: " + hasFocus);
                if (!hasFocus) {
                    final String name = ((TextView) v).getText().toString();
                    try {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                weapon.setWeaponName(name);
                            }
                        });
                    } catch (Exception e) {
                        Log.e("REALM SET W NAME ERROR", e.toString());

                    }
                }
            }
        });

        //https://android--examples.blogspot.co.uk/2015/05/how-to-use-numberpicker-in-android.html
        np_damage_number_of_die_value.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.d(TAG, "onFocusChange Damage Number of Die. OldValue: " + oldVal + " NewValue: " + newVal);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        weapon.setWeaponDamageNumberOfDie(np_damage_number_of_die_value.getValue());
                    }
                });
            }
        });

        /*https://stackoverflow.com/questions/17834537/how-to-read-items-from-string-array-on-android
        * https://stackoverflow.com/questions/7666589/using-getresources-in-non-activity-class */
        ArrayAdapter<CharSequence> damageDieTypeAdapter = ArrayAdapter.createFromResource(getContext(), R.array.die_type, android.R.layout.simple_spinner_dropdown_item);
        s_damage_die_type_value.setAdapter(damageDieTypeAdapter);
        /* STACKOVERFLOW ANSWER */
        s_damage_die_type_value.setSelection(weapon.getWeaponDamageDieTypeInt());
        s_damage_die_type_value.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, final int position, long id) {
                if (position != weapon.getWeaponDamageDieTypeInt()) {
                    String[] value = getContext().getResources().getStringArray(R.array.die_type);
                    Log.d(TAG, "onItemSelectedChange damage die type: " + position + " value: " + value[position]);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            weapon.setWeaponDamageDieType(position);
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<CharSequence> damageTypeAdapter = ArrayAdapter.createFromResource(getContext(), R.array.damage_type, android.R.layout.simple_spinner_dropdown_item);
        s_damage_type_value.setAdapter(damageTypeAdapter);
        //
        s_damage_type_value.setSelection(weapon.getWeaponDamageTypeInt());
        s_damage_type_value.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, View v, final int position, long id) {
                if (position != weapon.getWeaponDamageTypeInt()) {
                    String[] value = getContext().getResources().getStringArray(R.array.damage_type);
                    Log.d(TAG, "onItemSelectedChange damage type: " + position + " value: " + value[position]);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            Log.d(TAG, "onItemSelectedChange damage type execute " + position);
                            weapon.setWeaponDamageType(position);
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<CharSequence> abilityBonusAdapter = ArrayAdapter.createFromResource(getContext(), R.array.ability_bonus, android.R.layout.simple_spinner_dropdown_item);
        s_ability_bonus_value.setAdapter(abilityBonusAdapter);
        //
        s_ability_bonus_value.setSelection(weapon.getWeaponAbilityBonusInt());
        s_ability_bonus_value.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                if (position != weapon.getWeaponAbilityBonusInt()) {
                    String[] value = getContext().getResources().getStringArray(R.array.die_type);
                    Log.d(TAG, "onItemSelectedChange damage die type: " + position + " value: " + value[position]);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            Log.d(TAG, "onItemSelectedChange damage type execute " + position);
                            weapon.setWeaponAbilityBonus(position);
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Log.d("LoopChecker End", "Loop checker is at: " + position);
        addWeaponToUI();
        return convertView;
    }

    //TODO calculateAbilityAttackBonus
    private int calculateAbilityAttackBonus(Weapon weapon) {

        return 0;
    }

    private void addWeaponToUI() {
        et_name_value.setText(weapon.getWeaponName());
        tv_attack_bonus_value.setText(weapon.getWeaponAbilityBonusAsReadableString());
        np_damage_number_of_die_value.setValue(weapon.getWeaponDamageNumberOfDie());
    }
}
