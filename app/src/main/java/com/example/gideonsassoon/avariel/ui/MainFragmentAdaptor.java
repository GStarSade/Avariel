package com.example.gideonsassoon.avariel.ui;
//MAIN CLASS CORE!!!
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Gideon Sassoon on 21/01/2017.
 */

public class MainFragmentAdaptor extends FragmentPagerAdapter {


    public MainFragmentAdaptor(FragmentManager fm) {
        super(fm);

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
                return new AdventureFragment();
            }
            case 1: {
                return new CombatFragment();
            }
            case 2: {
                return new MiscFragment();
            }
            default: {
                throw new RuntimeException("unhandled positing " + position);
            }
        }
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: {
                return "Adventure";
            }
            case 1: {
                return "Combat";
            }
            case 2: {
                return "Misc";
            }
            default: {
                return "Error";
            }
        }
    }
}