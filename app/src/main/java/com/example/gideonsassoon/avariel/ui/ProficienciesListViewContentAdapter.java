package com.example.gideonsassoon.avariel.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.gideonsassoon.avariel.datamodels.Equipment;
import com.example.gideonsassoon.avariel.datamodels.Proficiencies;
import com.example.gideonsassoon.avariel.datamodels.Sheet;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Gideon on 18/01/2018.
 */

public class ProficienciesListViewContentAdapter extends ArrayAdapter<Proficiencies> {

    private static final String TAG = ProficienciesListViewContentAdapter.class.getSimpleName();
    //TODO this is not being used. Should it?
    private final Sheet sheet;
    private Realm realm;
    private Proficiencies proficiencies;

    private Button b_delete_row;
    private EditText et_name_value;

    public ProficienciesListViewContentAdapter(@NonNull Context context, Sheet sheet, Realm realm, List<Proficiencies> proficienciesList) {
        super(context, 0, proficienciesList);
        this.sheet = sheet;
        this.realm = realm;
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, ViewGroup parent) {

        b_delete_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        //proficiencies.deleteFromRealm();
                    }
                });
            }
        });

        return convertView;
    }
}
