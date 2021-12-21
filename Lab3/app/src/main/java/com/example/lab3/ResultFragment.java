package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {

    private TextView passwordOutput;
    private DBHelper dbHelper;

    public ResultFragment() {
        super(R.layout.result_fragment);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbHelper = new DBHelper(getContext());
        passwordOutput = view.findViewById(R.id.passwordOutput);
        Button buttonStorage = view.findViewById(R.id.buttonStorage);
        buttonStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), StorageActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setResult(String value) {
        passwordOutput.setText(value);
        boolean success = dbHelper.addPassword(value);
        if (success) {
            Toast.makeText(getContext(), "You successfully added a password!", Toast.LENGTH_SHORT).show();
        }
    }
}
