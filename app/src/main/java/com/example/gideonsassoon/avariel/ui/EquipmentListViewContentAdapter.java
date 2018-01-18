package com.example.gideonsassoon.avariel.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.datamodels.Equipment;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Gideon on 02/01/2018.
 */

public class EquipmentListViewContentAdapter extends ArrayAdapter<Equipment> {

    private static final String TAG = EquipmentListViewContentAdapter.class.getSimpleName();
    private Realm realm;
    private Equipment equipment;

    private Button b_delete_equipment_row;
    private EditText et_name_value;

    public EquipmentListViewContentAdapter(@NonNull Context context, Realm realm, List<Equipment> equipmentList) {
        super(context, 0, equipmentList);
        this.realm = realm;
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG,"LoopChecker Start, Loop checker is at: " + position);
        equipment = getItem(position);

        if (convertView == null)
            //Because you're returning the view (AttachToRoot is false) the ArrayAdaptor (This class) will handle adding the view to the list.
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.equipment_list_item, parent, false);

        b_delete_equipment_row = (Button) convertView.findViewById(R.id.b_delete_equipment_row);
        et_name_value = (EditText) convertView.findViewById(R.id.et_name_value);

        b_delete_equipment_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        equipment.deleteFromRealm();
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
                                equipment.setEquipmentName(name);
                            }
                        });
                    } catch (Exception e) {
                        Log.e(TAG, "REALM SET E NAME ERROR" + e.toString());
                    }
                }
            }
        });
        addEquipmentToUI();
        return convertView;
    }

    private void addEquipmentToUI() {
        et_name_value.setText(equipment.getEquipmentName());
    }
}