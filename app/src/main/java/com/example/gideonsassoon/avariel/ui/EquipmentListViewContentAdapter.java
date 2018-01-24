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
import android.widget.Toast;

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

    public EquipmentListViewContentAdapter(@NonNull Context context, Realm realm, List<Equipment> equipmentList) {
        super(context, 0, equipmentList);
        this.realm = realm;
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "LoopChecker Start, Loop checker is at: " + position);
        final Equipment equipment = getItem(position);
        assert equipment != null;
        if (convertView == null)
            //Because you're returning the view (AttachToRoot is false) the ArrayAdaptor (This class) will handle adding the view to the list.
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.equipment_list_item, parent, false);
        Button b_delete_equipment_row = (Button) convertView.findViewById(R.id.b_delete_equipment_row);
        EditText et_name_value = (EditText) convertView.findViewById(R.id.et_name_value);
        EditText et_cost_value = (EditText) convertView.findViewById(R.id.et_equipment_cost_value);
        EditText et_weight_value = (EditText) convertView.findViewById(R.id.et_weight_value);

        b_delete_equipment_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String equipmentToDeleteAdmin = equipment.toString();
                String equipmentToDelete = null;
                try {
                    if (equipment.getEquipmentName() != null)
                        equipmentToDelete = "Deleted: " + equipment.getEquipmentName();
                    else
                        equipmentToDelete = "Deleted: \"Unnamed Equipment\"";
                } catch (Exception e) {
                    Log.e(TAG, "Equipment Delete Name retrieval Failed: ", e);
                }
                try {
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            equipment.deleteFromRealm();
                        }
                    });
                } catch (Exception e) {
                    Log.e(TAG, "Equipment Delete Failed: ", e);
                }
                Log.i(TAG, "Removed: " + equipmentToDeleteAdmin);
                Toast.makeText(getContext(), equipmentToDelete, Toast.LENGTH_SHORT).show();
            }
        });
        et_name_value.setText(equipment.getEquipmentName());
        et_name_value.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange equipment name: " + hasFocus);
                if (!hasFocus) {
                    final String name = ((TextView) v).getText().toString();
                    if (!name.isEmpty()) {
                        try {
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    equipment.setEquipmentName(name);
                                }
                            });
                        } catch (Exception e) {
                            Log.e(TAG, "Realm set Equipment Name Error ", e);
                        }
                    }
                }
            }
        });
        et_cost_value.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange equipment cost: " + hasFocus);
                if (!hasFocus) {
                    final String cost = ((TextView) v).getText().toString();
                    if (!cost.isEmpty()) {
                        try {
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    equipment.setEquipmentCost(cost);
                                }
                            });
                        } catch (Exception e) {
                            Log.e(TAG, "Realm set Equipment Cost Error", e);
                        }
                    }
                }
            }
        });
        et_weight_value.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange equipment weight: " + hasFocus);
                if (!hasFocus) {
                    String weightString = ((TextView) v).getText().toString();
                    if (!weightString.isEmpty()) {
                        final Double weight = Double.parseDouble(weightString);
                        try {
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    equipment.setEquipmentWeight(weight);
                                }
                            });
                        } catch (Exception e) {
                            Log.e(TAG, "Realm set Equipment Cost Error", e);
                        }
                    }
                }
            }
        });
        return convertView;
    }
}