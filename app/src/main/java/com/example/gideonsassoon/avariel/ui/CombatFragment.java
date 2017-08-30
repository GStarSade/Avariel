package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

/**
 * Created by Gideon Sassoon on 21/01/2017.
 */

public class CombatFragment extends Fragment {
    private EditText mNameEditText;

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




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_combat, container, false);

        return rootView;
    }


}
