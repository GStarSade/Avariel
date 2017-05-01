package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.data.Player;
import com.example.gideonsassoon.avariel.database.DbHelper;

/**
 * Created by Gideon Sassoon on 21/01/2017.
 */

public class SkillsSheetFragment extends Fragment {
    private DbHelper mDatabaseHelper;
    private EditText mNameEditText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDatabaseHelper = new DbHelper(getContext());
        Player newPlayer = mDatabaseHelper.getPlayer(11);

    View rootView = inflater.inflate(R.layout.content_skills, container, false);
  //      mNameEditText = (EditText) rootView.findViewById(R.id.et_character_name);
    //    mNameEditText.setText(newPlayer.getName());
        //return inflater.inflate(R.layout.content_skills,container,false);
        // This was incorrect http://stackoverflow.com/questions/33649232
        return rootView;
    }

    void addPlayerToUI(Player player){
    }
}
