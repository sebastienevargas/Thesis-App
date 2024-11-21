package com.example.testingnavtable.databaseSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {
    private DatabaseHelper dbHelper;

    public DatabaseManager(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void addItem(String title, String description) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_TITLE, title);
        values.put(DatabaseHelper.COLUMN_DESCRIPTION, description);
        db.insert(DatabaseHelper.TABLE_ITEMS, null, values);
        db.close();
    }
}
