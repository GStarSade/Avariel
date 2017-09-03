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
import com.example.gideonsassoon.avariel.datamodels.Spell;
import com.example.gideonsassoon.avariel.datamodels.Weapon;

import butterknife.BindView;
import io.realm.Realm;

/**
 * Created by Gideon Sassoon on 21/01/2017.
 */

public class CombatFragment extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText mNameEditText;

    /*
    Get ... get an instance of MainActivity and get realm... seems like the best plan
     */



    Sheet sheet;
    Weapon weapon;
    Spell spell;

    @BindView(R.id.tv_armor_class_value)
    TextView tv_armorClassValue;
    @BindView(R.id.tv_initiative_value)
    TextView tv_initiativeValue;
    @BindView(R.id.tv_speed_value)
    TextView tv_speedValue;
    @BindView(R.id.tv_hit_dice_value)
    TextView tv_hitDiceValue;
    @BindView(R.id.et_success_value)
    TextView et_successValue;
    @BindView(R.id.et_failure_value)
    TextView et_failureValue;

    /*
    TODO Name - et_name_attack_spellcasting_value
    TODO Attack Bonus - tv_attack_bonus_value
    TODO Damage Type - s_damage_type_value
     */

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_combat, container, false);

        /*
        TODO Fix Reference from/to Main Activity
        et_successValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange currentHP: " + hasFocus);
                if (!hasFocus) {
                    final String successValueString = ((EditText) v).getText().toString();
                    final int successValue = Integer.parseInt(successValueString);
                    ((MainActivity)getActivity()).getRealm().executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setSuccessDeathSaves(successValue);
                        }
                    });
                }
            }
        });

        et_failureValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange currentHP: " + hasFocus);
                if (!hasFocus) {
                    final String failureValueString = ((EditText) v).getText().toString();
                    final int failureValue = Integer.parseInt(failureValueString);
                    ((MainActivity)getActivity()).getRealm().executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            sheet.setFailureDeathSaves(failureValue);
                        }
                    });
                }
            }
        });


*/



        return rootView;
    }
}
