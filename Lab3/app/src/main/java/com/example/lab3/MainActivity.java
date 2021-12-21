package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements FormFragment.OnFormFragmentEvent {

    private FragmentManager fm;

    public MainActivity() {
        super(R.layout.activity_main);
        fm = getSupportFragmentManager();
    }

    @Override
    public void onSubmit(String value) {
        ResultFragment resultFragment = (ResultFragment) fm.findFragmentById(R.id.resultFragment);
        resultFragment.setResult(value);
    }
}