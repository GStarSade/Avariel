package com.example.gideonsassoon.avariel.ui;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by Gideon Sassoon on 22/02/2017.
 */

public class TextViewAvariel extends android.support.v7.widget.AppCompatTextView {

    public TextViewAvariel(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/mrseavessmallcaps.ttf"));
    }
}
