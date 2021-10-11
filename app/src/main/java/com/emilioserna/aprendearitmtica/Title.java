package com.emilioserna.aprendearitmtica;

import android.view.View;
import android.widget.TextView;

public class Title {

    private TextView mTextTitle;

    public Title(View v, int id) {
        this.mTextTitle = v.findViewById(R.id.title_text);
        this.mTextTitle.setText(id);
    }
}