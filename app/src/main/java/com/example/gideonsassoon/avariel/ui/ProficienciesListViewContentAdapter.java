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
import com.example.gideonsassoon.avariel.datamodels.Proficiencies;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Gideon on 18/01/2018.
 */

public class ProficienciesListViewContentAdapter extends ArrayAdapter<Proficiencies> {

    private static final String TAG = ProficienciesListViewContentAdapter.class.getSimpleName();
    private Realm realm;

    public ProficienciesListViewContentAdapter(@NonNull Context context, Realm realm, List<Proficiencies> proficienciesList) {
        super(context, 0, proficienciesList);
        this.realm = realm;
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, ViewGroup parent) {
        final Proficiencies proficiencies = getItem(position);
        assert proficiencies != null;
        if (convertView == null)
            //Because you're returning the view (AttachToRoot is false) the ArrayAdaptor (This class) will handle adding the view to the list.
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.generic_list_item, parent, false);

        Button b_delete_row = (Button) convertView.findViewById(R.id.b_delete_generic_row);
        EditText et_name_value = (EditText) convertView.findViewById(R.id.et_name_value);

        b_delete_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proficienciesToDeleteAdmin = proficiencies.toString();
                String proficienciesToDelete;
                if (proficiencies.getProficienciesName() != null)
                    proficienciesToDelete = "Deleted: " + proficiencies.getProficienciesName();
                else
                    proficienciesToDelete = "Deleted: \"Unnamed Proficiencies\"";
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        proficiencies.deleteFromRealm();
                    }
                });
                Log.i(TAG, "Removed: " + proficienciesToDeleteAdmin);
                Toast.makeText(getContext(), proficienciesToDelete, Toast.LENGTH_SHORT).show();
            }
        });
        et_name_value.setText(proficiencies.getProficienciesName());
        et_name_value.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(final View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange proficiencies name: " + hasFocus);
                if (!hasFocus) {
                    final String name = ((TextView) v).getText().toString();
                    try {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                proficiencies.setProficienciesName(name);
                            }
                        });
                    } catch (Exception e) {
                        Log.e(TAG, "Realm set P NAME ERROR " , e);
                    }
                }

            }
        });
        return convertView;
    }
}
