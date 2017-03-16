package com.example.gideonsassoon.avariel.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.gideonsassoon.avariel.database.DbHelper;

/**
 * Created by Gideon Sassoon on 21/01/2017.
 */

public class MainFragmentAdaptor extends FragmentPagerAdapter {

    DbHelper dbHelper;
    public MainFragmentAdaptor(FragmentManager fm, DbHelper dbHelper) {
        super(fm);
        this.dbHelper = dbHelper;
    }



    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                return new SkillsSheetFragment();
            }
            case 1: {
                return new SkillsSheetFragment(); //change skill sheet fragoment to attack sheet when done
            }
            case 2: {
                break;
            }
            default: {
                throw new RuntimeException("unhandled positing " + position);
            }
        }
        return null;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "TAB " + (position + 1);
    }
}