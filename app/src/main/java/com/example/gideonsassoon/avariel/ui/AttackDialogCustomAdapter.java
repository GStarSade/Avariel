package com.example.gideonsassoon.avariel.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.datamodels.Weapon;

import java.util.ArrayList;

/**
 * Created by Gideon on 08/01/2018.
 */

public class AttackDialogCustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Weapon> weapons;

    public AttackDialogCustomAdapter(Context context) {
        this.context = context;
        weapons = MainActivity.getWeaponDefault();
    }

    @Override
    public int getCount() {
        return weapons.size();
    }

    @Override
    public Object getItem(int position) {
        return weapons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_dialogue_list, parent, false);

        TextView tv_cusdia_name_value = (TextView) row.findViewById(R.id.tv_cusdia_name_value);
        TextView tv_cusdia_number_of_die_value = (TextView) row.findViewById(R.id.tv_cusdia_number_of_die_value);
        TextView tv_cusdia_dice_type_value = (TextView) row.findViewById(R.id.tv_cusdia_dice_type_value);
        TextView tv_cusdia_ability_bonus_value = (TextView) row.findViewById(R.id.tv_cusdia_ability_bonus_value);
        TextView tv_cusdia_damage_type_value = (TextView) row.findViewById(R.id.tv_cusdia_damage_type_value);
        TextView tv_cusdia_properties_value = (TextView) row.findViewById(R.id.tv_cusdia_properties_value);

        tv_cusdia_name_value.setText(weapons.get(position).getWeaponName());
        tv_cusdia_number_of_die_value.setText(String.valueOf(weapons.get(position).getWeaponDamageNumberOfDie()));
        tv_cusdia_dice_type_value.setText(String.valueOf(weapons.get(position).getWeaponDamageDieType()));
        tv_cusdia_ability_bonus_value.setText(weapons.get(position).getWeaponAbilityBonusAsReadableString());
        tv_cusdia_damage_type_value.setText(weapons.get(position).getDamageTypeString());
        tv_cusdia_properties_value.setText(weapons.get(position).getWeaponPropertiesAdditional());

        return row;
    }
}
