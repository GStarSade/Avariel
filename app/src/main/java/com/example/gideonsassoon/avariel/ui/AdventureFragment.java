package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

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

public class AdventureFragment extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Realm realm;
    private Sheet sheet;

    @BindView(R.id.cb_acrobatics)
    CheckBox cb_acrobatics;
    @BindView(R.id.et_acrobatics)
    EditText et_acrobatics;

    @BindView(R.id.cb_animal_handling)
    CheckBox cb_animal_handling;
    @BindView(R.id.et_animal_handling)
    EditText et_animal_handling;

    @BindView(R.id.cb_arcana)
    CheckBox cb_arcana;
    @BindView(R.id.et_arcana)
    EditText et_arcana;

    @BindView(R.id.cb_athletics)
    CheckBox cb_athletics;
    @BindView(R.id.et_athletics)
    EditText et_athletics;

    @BindView(R.id.cb_deception)
    CheckBox cb_deception;
    @BindView(R.id.et_deception)
    EditText et_deception;

    @BindView(R.id.cb_history)
    CheckBox cb_history;
    @BindView(R.id.et_history)
    EditText et_history;

    @BindView(R.id.cb_insight)
    CheckBox cb_insight;
    @BindView(R.id.et_insight)
    EditText et_insight;

    @BindView(R.id.cb_intimidation)
    CheckBox cb_intimidation;
    @BindView(R.id.et_intimidation)
    EditText et_intimidation;

    @BindView(R.id.cb_investigation)
    CheckBox cb_investigation;
    @BindView(R.id.et_investigation)
    EditText et_investigation;

    @BindView(R.id.cb_medicine)
    CheckBox cb_medicine;
    @BindView(R.id.et_medicine)
    EditText et_medicine;

    @BindView(R.id.cb_nature)
    CheckBox cb_nature;
    @BindView(R.id.et_nature)
    EditText et_nature;

    @BindView(R.id.cb_perception)
    CheckBox cb_perception;
    @BindView(R.id.et_perception)
    EditText et_perception;

    @BindView(R.id.cb_performance)
    CheckBox cb_performance;
    @BindView(R.id.et_performance)
    EditText et_performance;

    @BindView(R.id.cb_persuasion)
    CheckBox cb_persuasion;
    @BindView(R.id.et_persuasion)
    EditText et_persuasion;

    @BindView(R.id.cb_religion)
    CheckBox cb_religion;
    @BindView(R.id.et_religion)
    EditText et_religion;

    @BindView(R.id.cb_sleight_of_hand)
    CheckBox cb_sleight_of_hand;
    @BindView(R.id.et_sleight_of_hand)
    EditText et_sleight_of_hand;

    @BindView(R.id.cb_stealth)
    CheckBox cb_stealth;
    @BindView(R.id.et_stealth)
    EditText et_stealth;

    @BindView(R.id.cb_survival)
    CheckBox cb_survival;
    @BindView(R.id.et_survival)
    EditText et_survival;

    @BindView(R.id.b_add_equipment)
    Button b_add_equipment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_adventure, container, false);
  /*      ButterKnife.bind(this, rootView);
        realm = Realm.getDefaultInstance();
        realm.where(Sheet.class).findAll().addChangeListener(new RealmChangeListener<RealmResults<Sheet>>() {
            @Override
            public void onChange(RealmResults<Sheet> sheets) {
                //addPlayerToUI(sheets.first());
            }
        });
        sheet = realm.where(Sheet.class).equalTo(Sheet.FIELD_SHEET_ID, 0).findFirst();
*/



        return rootView;
    }

    void addPlayerToUI(Sheet sheet) {
        cb_acrobatics.setChecked(sheet.isAcrobaticsProficiency());
        et_acrobatics.setText(sheet.getAcrobaticsProficiencyInt());

        cb_animal_handling.setChecked(sheet.isAnimalHealingProficiency());
        et_animal_handling.setText(sheet.getAnimalHealingProficiencyInt());

        cb_arcana.setChecked(sheet.isArcanaProficiency());
        et_arcana.setText(sheet.getArcanaProficiencyInt());

        cb_athletics.setChecked(sheet.isAthleticsProficiency());
        et_athletics.setText(sheet.getAthleticsProficiencyInt());

        cb_deception.setChecked(sheet.isDeceptionProficiency());
        et_deception.setText(sheet.getDeceptionProficiencyInt());

        cb_history.setChecked(sheet.isHistoryProficiency());
        et_history.setText(sheet.getHistoryProficiencyInt());

        cb_insight.setChecked(sheet.isInsightMarked());
        et_insight.setText(sheet.getInsightMarkedInt());

        cb_intimidation.setChecked(sheet.isIntimidationProficiency());
        et_intimidation.setText(sheet.getIntimidationProficiencyInt());

        cb_investigation.setChecked(sheet.isInvestigationProficiency());
        et_investigation.setText(sheet.getInvestigationProficiencyInt());

        cb_medicine.setChecked(sheet.isMedicineProficiency());
        et_medicine.setText(sheet.getMedicineProficiencyInt());

        cb_nature.setChecked(sheet.isNatureProficiency());
        et_nature.setText(sheet.getNatureProficiencyInt());

        cb_perception.setChecked(sheet.isPerceptionProficiency());
        et_perception.setText(sheet.getPerceptionProficiencyInt());

        cb_performance.setChecked(sheet.isPerformanceProficiency());
        et_performance.setText(sheet.getPerformanceProficiencyInt());

        cb_persuasion.setChecked(sheet.isPersuasionProficiency());
        et_persuasion.setText(sheet.getPersuasionProficiencyInt());

        cb_religion.setChecked(sheet.isReligionProficiency());
        et_religion.setText(sheet.getReligionProficiencyInt());

        cb_sleight_of_hand.setChecked(sheet.isSleightOfHandProficiency());
        et_sleight_of_hand.setText(sheet.getSleightOfHandProficiencyInt());

        cb_stealth.setChecked(sheet.isStealthProficiency());
        et_stealth.setText(sheet.getStealthProficiencyInt());

        cb_survival.setChecked(sheet.isSurvivalProficiency());
        et_survival.setText(sheet.getSurvivalProficiencyInt());
    }
}
