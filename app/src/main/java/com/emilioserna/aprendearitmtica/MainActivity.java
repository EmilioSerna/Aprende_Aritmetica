package com.emilioserna.aprendearitmtica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fm;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new TitleFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}