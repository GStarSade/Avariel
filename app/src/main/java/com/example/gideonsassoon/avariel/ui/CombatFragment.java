package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.datamodels.Sheet;
import com.example.gideonsassoon.avariel.datamodels.Spell;
import com.example.gideonsassoon.avariel.datamodels.Weapon;

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
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText mNameEditText;
    MainFragmentAdaptor mMainFragmentAdaptor;

    /*See GAMEPLAN and convo with Jeremy before working on anything, GAMEPLAN JUST STORES DATE FOR WRITE UP.*/

    /*
    Get ... get an instance of MainActivity and get realm... seems like the best plan
    TODO 1) put a ListView in place of the attack views you currently have.
    TODO 2) put those attack views in their own layout; this will be an attack list item
    TODO 3) define your attack item datamodel -  name, damage whatever.  This should be a realm object you can persist in your Sheet as entries in a RealmList
    TODO 4) use an ArrayAdapter in CombatFragment to populate the ListView with your attack entry items as the layout and the realmlist of attack items as the data source
    TODO 5) you'll need some other ui with which to create new attack entries - perhaps a dialog pop-up, or a "create new" button that creates an empty attack item model for you to edit and save.

    TODO 6) try googling for "android list adapter tutorial" -
    TODO 7) the idea with a list is not to manually add each entry to a layout with different content each time,

    TODO 8) but to use an Adapter to populate a ListView with rows,
    TODO 9) where the row is a separate layout that is inflated and populated from each entry in the data fed to the adapter.
    TODO 10) You'll end up with your own ArrayAdapter extending class that knows how to turn your data into a row,
    TODO 11) and you'll do listView.setAdapter(myArrayAdapter) to hook the two together.
    TODO 12) There's a similar principle when using a GridView, if that's what you're after as well - Adapters are the key to turning a list of data into a list of views.
     */

    private Realm realm;
    private Sheet sheet;

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
    TODO Attack Bonus - tv_attack_bonus_value
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

        et_successValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange success value: " + hasFocus);
                if (!hasFocus) {
                    final String successValueString = ((EditText) v).getText().toString();
                    final int successValue = Integer.parseInt(successValueString);
                    ((MainActivity) getActivity()).getRealm().executeTransaction(new Realm.Transaction() {
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
                Log.d(TAG, "onFocusChange failure value: " + hasFocus);
                if (!hasFocus) {
                    final String failureValueString = ((EditText) v).getText().toString();
                    final int failureValue = Integer.parseInt(failureValueString);
                    ((MainActivity) getActivity()).getRealm().executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            Sheet sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();
                            sheet.setFailureDeathSaves(failureValue);
                        }
                    });
                }
            }
        });

        b_add_attack_spellcasting_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newSheetWeapon();
            }
        });

        /*
        ATTaCK SPELLCASTING SECTION
        Widgets are views too.
        */

        //TODO Add/provide list of Weapon.
        //Sheet sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst(); MOVED TO TOP
        RealmList<Weapon> weaponList = sheet.getWeaponList();
        final AttackListViewContentAdapter attackListViewContentAdapter = new AttackListViewContentAdapter(getActivity(), sheet, realm, weaponList);
        weaponList.addChangeListener(new RealmChangeListener<RealmList<Weapon>>() {
            @Override
            public void onChange(RealmList<Weapon> weapons) {
                /* Gives the adaptor a kick to know that the weapon realm list has changed */
                attackListViewContentAdapter.notifyDataSetChanged();
            }
        });
        lv_attack_spellcasting_title.setAdapter(attackListViewContentAdapter);
        /*
        b_add_attack_spellcasting_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Rel
                //getLayoutInflater().inflate(R.layout.attack_view_grid_item, rl_attack_spellcasting_content);
            }
        });
        */
        //buttonSetMatchingWidth();
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

    /***
     * https://stackoverflow.com/questions/9977721/how-to-set-width-which-is-equal-to-another-widget-on-android
     */
    /*private void buttonSetMatchingWidth() {
        if (b_add_attack_spellcasting_row.getWidth() < b_delete_attack_spellcasting_row.getWidth())
            b_add_attack_spellcasting_row.setWidth(b_delete_attack_spellcasting_row.getWidth());
        else
            b_delete_attack_spellcasting_row.setWidth(b_add_attack_spellcasting_row.getWidth());
    }*/

    /**
     * https://stackoverflow.com/questions/34296748/android-realm-inserting-one-to-many-primarykey
     **/
    public void newSheetWeapon() {
        Log.i("newSheetWeapon: ", "START");
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
                    Log.e("CATCH newSheetWeapon: ", "maxValue: " + maxValue + " maxValueInt: " + String.valueOf(maxValueInt) + e.toString());
                }
            }
        });
    }

    public void deleteSheetWeapon(final Weapon weapon) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                weapon.deleteFromRealm();
            }
        });
    }

    void addPlayerToUI(Sheet sheet) {
        tv_speedValue.setText(String.valueOf(sheet.getRaceSpeed()));
        et_failureValue.setText(String.valueOf(sheet.getFailureDeathSaves()));
        et_successValue.setText(String.valueOf(sheet.getSuccessDeathSaves()));
    }
}