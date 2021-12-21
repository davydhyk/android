package com.example.lab3;

import android.database.DataSetObserver;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class StorageActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private List<String> passwords;
    private ArrayAdapter passwordsAdapter;
    private ViewStub listPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        dbHelper = new DBHelper(getApplicationContext());
        listPlaceholder = findViewById(R.id.listStorageEmpty);

        ListView listView = findViewById(R.id.listStorage);
        passwords = dbHelper.getAllPasswords();
        passwordsAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, passwords);
        passwordsAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                Log.d("asdasdasdasdasdasd", String.valueOf(passwords.isEmpty()));
                Log.d("asdasdasdasdasdasd", String.valueOf(passwords.isEmpty() ? View.VISIBLE : View.GONE));
                listPlaceholder.setVisibility(passwords.isEmpty() ? View.VISIBLE : View.GONE);
            }
        });
        listView.setAdapter(passwordsAdapter);
        passwordsAdapter.notifyDataSetChanged();

        Button clearButton = findViewById(R.id.buttonClear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.clearPasswords();
                passwords.clear();
                passwordsAdapter.notifyDataSetChanged();
            }
        });

        Button backButton = findViewById(R.id.buttonBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}