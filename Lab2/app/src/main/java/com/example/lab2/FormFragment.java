package com.example.lab2;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.*;
import androidx.fragment.app.Fragment;

public class FormFragment extends Fragment {

    public interface OnFormFragmentEvent {
        void onSubmit(String value);
    }

    private OnFormFragmentEvent listener;

    public FormFragment() {
        super(R.layout.form_fragment);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnFormFragmentEvent) context;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText passwordInput = view.findViewById(R.id.passwordInput);

        RadioGroup passwordVisibility = view.findViewById(R.id.passwordVisibility);
        passwordVisibility.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id) {
                    case R.id.showPassword:
                        passwordInput.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    case R.id.hidePassword:
                        passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        break;
                }
            }
        });

        Button submit = view.findViewById(R.id.buttonOk);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = passwordInput.getText().toString();
                if (password.isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please, complete the input!", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onSubmit(password);
            }
        });
    }
}
