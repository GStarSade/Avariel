package com.example.gideonsassoon.avariel.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
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
import android.widget.Toast;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.datamodels.Sheet;
import com.example.gideonsassoon.avariel.datamodels.SheetEnum;
import com.example.gideonsassoon.avariel.datamodels.Weapon;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Gideon on 28/10/2017.
 */

public class AttackListViewContentAdapter extends ArrayAdapter<Weapon> {

    private static final String TAG = AttackListViewContentAdapter.class.getSimpleName();
    private Realm realm;

    public AttackListViewContentAdapter(Context context, Realm realm, List<Weapon> weaponList) {
        super(context, 0, weaponList);
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
        Log.d(TAG, "LoopChecker Start, Loop checker is at: " + position);
        final Weapon weapon = getItem(position);
        assert weapon != null;
        if (convertView == null)
            //Because you're returning the view (AttachToRoot is false) the ArrayAdaptor (This class) will handle adding the view to the list.
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.attack_list_item, parent, false);

        Button b_delete_attack_row = (Button) convertView.findViewById(R.id.b_delete_attack_row);
        EditText et_name_value = (EditText) convertView.findViewById(R.id.et_name_value);
        final TextView tv_attack_bonus_value = (TextView) convertView.findViewById(R.id.tv_attack_bonus_value);
        final NumberPicker np_damage_number_of_die_value = (NumberPicker) convertView.findViewById(R.id.np_damage_number_of_die_value);
        final Button b_damage_number_of_die_value = (Button) convertView.findViewById(R.id.b_damage_number_of_die_value);
        Spinner s_damage_die_type_value = (Spinner) convertView.findViewById(R.id.s_damage_die_type_value);
        Spinner s_damage_type_value = (Spinner) convertView.findViewById(R.id.s_damage_type_value);
        Spinner s_ability_bonus_value = (Spinner) convertView.findViewById(R.id.s_ability_bonus);
        EditText et_properties = (EditText) convertView.findViewById(R.id.et_properties);
        np_damage_number_of_die_value.setMinValue(1);
        np_damage_number_of_die_value.setMaxValue(20);
        /* https://stackoverflow.com/questions/3775726/invisible-transparent-button-that-works-like-a-regular-in-android */
        b_damage_number_of_die_value.setVisibility(View.VISIBLE);
        b_damage_number_of_die_value.setBackgroundColor(Color.TRANSPARENT);

        et_name_value.setText(weapon.getWeaponName());
        np_damage_number_of_die_value.setValue(weapon.getWeaponDamageNumberOfDie());
        tv_attack_bonus_value.setText(calculateAbilityAttackBonus(weapon));
        et_properties.setText(weapon.getWeaponPropertiesAdditional());

        b_delete_attack_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weaponToDeleteAdmin = weapon.toString();
                String weaponToDelete = aSwordHasNoName(weapon, false);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        weapon.deleteFromRealm();
                    }
                });
                Log.i(TAG, "Removed: " + weaponToDeleteAdmin);
                Toast.makeText(getContext(), weaponToDelete, Toast.LENGTH_SHORT).show();
            }
        });
        et_name_value.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange weapon name: " + hasFocus);
                if (!hasFocus) {
                    final String name = ((TextView) v).getText().toString();
                    if (!name.isEmpty()) {
                        try {
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    weapon.setWeaponName(name);
                                }
                            });
                        } catch (Exception e) {
                            Log.e(TAG, "Realm set W NAME ERROR: ", e);

                        }
                    }
                }
            }
        });

        /*https://android--examples.blogspot.co.uk/2015/05/how-to-use-numberpicker-in-android.html*/
        b_damage_number_of_die_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getContext());
                Log.d(TAG, "Value of Weapon Name " + weapon.getWeaponName());
                String question = aSwordHasNoName(weapon, true);
                Log.d(TAG, "Forth Stage " + question);
                dialog.setContentView(R.layout.custom_number_picker_dialogue);
                final NumberPicker np_custom_dialogue = (NumberPicker) dialog.findViewById(R.id.np_custom_dialogue);
                np_custom_dialogue.setMinValue(1);
                np_custom_dialogue.setMaxValue(20);
                np_custom_dialogue.setValue(np_damage_number_of_die_value.getValue());
                //https://stackoverflow.com/questions/39356495/attempt-to-invoke-virtual-method-textview-settextjava-lang-charsequence-o
                TextView tv_custom_dialogue_title = (TextView) dialog.findViewById(R.id.tv_custom_dialogue_title);
                tv_custom_dialogue_title.setText(question);
                Button b_cancel = (Button) dialog.findViewById(R.id.b_cancel_custom_dialogue);
                Button b_okay = (Button) dialog.findViewById(R.id.b_okay_custom_dialogue);
                b_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                b_okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(TAG, "onFocusChange Damage Number of Die. OldValue: "
                                + np_damage_number_of_die_value.getValue() + " NewValue: "
                                + np_custom_dialogue.getValue());
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                weapon.setWeaponDamageNumberOfDie(np_custom_dialogue.getValue());
                            }
                        });
                        dialog.dismiss();
                    }
                });
                dialog.setCancelable(false);
                dialog.show();
                np_damage_number_of_die_value.setValue(weapon.getWeaponDamageNumberOfDie());
            }
        });

       /*https://stackoverflow.com/questions/17834537/how-to-read-items-from-string-array-on-android
       * https://stackoverflow.com/questions/7666589/using-getresources-in-non-activity-class */
        ArrayAdapter<CharSequence> damageDieTypeAdapter = ArrayAdapter.createFromResource(getContext(), R.array.die_type, android.R.layout.simple_spinner_dropdown_item);
        s_damage_die_type_value.setAdapter(damageDieTypeAdapter);
        /* https://stackoverflow.com/questions/48215513/realm-calling-onchange-addchangelistener-continuously */
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

        ArrayAdapter<CharSequence> damageTypeAdapter = ArrayAdapter.createFromResource(getContext(), R.array.damage_type, R.layout.spinner_multiline_adapter);
        damageTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_damage_type_value.setAdapter(damageTypeAdapter);
        /* https://stackoverflow.com/questions/48215513/realm-calling-onchange-addchangelistener-continuously */
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
        /* https://stackoverflow.com/questions/48215513/realm-calling-onchange-addchangelistener-continuously */
        s_ability_bonus_value.setSelection(weapon.getWeaponAbilityBonusCheatingInt());
        s_ability_bonus_value.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                if (position != weapon.getWeaponAbilityBonusCheatingInt()) {
                    String[] value = getContext().getResources().getStringArray(R.array.die_type);
                    Log.d(TAG, "onItemSelectedChange damage die type: " + position + " value: " + value[position]);
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            Log.d(TAG, "onItemSelectedChange damage type execute " + position);
                            if (position == 2)
                                weapon.setWeaponAbilityBonus(6);
                            else
                                weapon.setWeaponAbilityBonus(position);
                            tv_attack_bonus_value.setText(calculateAbilityAttackBonus(weapon));
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        et_properties.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange weapon properties: " + hasFocus);
                if (!hasFocus) {
                    final String properties = ((TextView) v).getText().toString();
                    if (!properties.isEmpty()) {
                        try {
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    weapon.setWeaponPropertiesAdditional(properties);
                                }
                            });
                        } catch (Exception e) {
                            Log.e(TAG, "Realm set W Properties ERROR: ", e);
                        }
                    }
                }
            }
        });

        Log.d(TAG, "LoopChecker End Loop checker is at: " + position);
        return convertView;
    }

    private String calculateAbilityAttackBonus(Weapon weapon) {
        SheetEnum.Ability ability = weapon.getWeaponAbilityBonus();
        Sheet sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();
        switch (ability) {
            case STRENGTH:
                return String.valueOf(sheet.getStrengthModified());
            case DEXTERITY:
                String.valueOf(sheet.getDexterityModified());
            case FINESSE:
                int largerInt = Math.max(sheet.getStrengthModified(), sheet.getDexterityModified());
                Log.d(TAG, "calculateAbilityAttackBonus, value returned " + largerInt +
                        " Strength: " + sheet.getStrengthModified() +
                        " Dexterity: " + sheet.getDexterityModified());
                return String.valueOf(largerInt);
            default:
                throw new RuntimeException("Unsupported Weapon Ability: " + ability.toString());
        }
    }

    /**
     * Checks if weapon has any name value if it doesn't Unnamed Weapon is returned
     *
     * @param weapon
     * @param question
     * @return A sentence
     */
    private String aSwordHasNoName(Weapon weapon, boolean question) {
        String toReturn;

        if (question) {
            if (weapon.getWeaponName() != null)
                toReturn = getContext().getResources().getString(R.string.please_choose_the_number_of_dice) + weapon.getWeaponName() + "?";
            else
                toReturn = getContext().getResources().getString(R.string.please_choose_the_number_of_dice) + "\"Unnamed Weapon\"?";
        } else {
            if (weapon.getWeaponName() != null)
                toReturn = "Deleted: " + weapon.getWeaponName();
            else
                toReturn = "Deleted: \"Unnamed Weapon\"";
        }
        return toReturn;
    }
}