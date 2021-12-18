package com.example.lab2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {

    private TextView passwordOutput;

    public ResultFragment() {
        super(R.layout.result_fragment);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        passwordOutput = view.findViewById(R.id.passwordOutput);
    }

    public void setResult(String value) {
        passwordOutput.setText(value);
    }
}
