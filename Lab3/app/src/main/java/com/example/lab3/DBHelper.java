package com.example.lab3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TABLE_PASSWORDS = "passwords";
    private static final String COLUMN_PASSWORD = "password";

    public DBHelper(Context context) {
        super(context, "lab3.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "" +
            "CREATE TABLE " + TABLE_PASSWORDS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "password VARCHAR(255)" +
            ")" +
        "";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<String> getAllPasswords() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PASSWORDS, null);
        List<String> passwordList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            passwordList.add(cursor.getString(1));
            while (cursor.moveToNext()) {
                passwordList.add(cursor.getString(1));
            }
        }
        cursor.close();
        db.close();
        return passwordList;
    }

    public boolean addPassword(String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PASSWORD, password);
        long rows = db.insert(TABLE_PASSWORDS, null, cv);
        db.close();
        return rows != -1;
    }

    public void clearPasswords() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PASSWORDS, null, null);
        db.close();
    }
}
