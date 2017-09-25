package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by Gideon Sassoon on 21/01/2017.
 */

public class CombatFragment extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText mNameEditText;
    MainFragmentAdaptor mMainFragmentAdaptor;

    /*
    Get ... get an instance of MainActivity and get realm... seems like the best plan
    TODO 1) put a ListView in place of the attack views you currently have.
    TODO 2) put those attack views in their own layout; this will be an attack list item
    TODO 3) define your attack item datamodel -  name, damage whatever.  This should be a realm object you can persist in your Sheet as entries in a RealmList
    TODO 4) use an ArrayAdapter in CombatFragment to populate the ListView with your attack entry items as the layout and the realmlist of attack items as the data source
    TODO 5) you'll need some other ui with which to create new attack entries - perhaps a dialog pop-up, or a "create new" button that creates an empty attack item model for you to edit and save.
     */

    private Realm realm;
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
        ButterKnife.bind(this, rootView);
        realm = Realm.getDefaultInstance();
        realm.where(Sheet.class).findAll().addChangeListener(new RealmChangeListener<RealmResults<Sheet>>() {
            @Override
            public void onChange(RealmResults<Sheet> sheets) {
                addPlayerToUI(sheets.first());
            }
        });

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
                            Sheet sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();
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
                            Sheet sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();
                            sheet.setFailureDeathSaves(failureValue);
                        }
                    });
                }
            }
        });

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
                        addPlayerToUI(sheet);
                    }
                });
            }
        });
    }
    void addPlayerToUI(Sheet sheet) {
        tv_speedValue.setText(String.valueOf(sheet.getRaceSpeed()));
        et_failureValue.setText(String.valueOf(sheet.getFailureDeathSaves()));
        et_successValue.setText(String.valueOf(sheet.getSuccessDeathSaves()));
    }
}
