package com.microsoft.activitytracker.Classes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.microsoft.activitytracker.Classes.DatabaseContracts.*;

/**
 * Created by Jeremy Shore on 8/11/14.
 */
public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "ActivityTracker";
    private static final int DATABASE_VERSION = 2;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTableQuery = "CREATE TABLE " + HistoryEntry.TABLE_NAME + "("
                + HistoryEntry._ID + " INTEGER PRIMARY KEY,"
                + HistoryEntry.COLUMN_FULL_NAME + " TEXT,"
                + HistoryEntry.COLUMN_JOB_TITLE + " TEXT,"
                + HistoryEntry.COLUMN_ACCOUNT_NAME + " TEXT,"
                + HistoryEntry.COLUMN_LOGICAL_NAME + " TEXT,"
                + HistoryEntry.COLUMN_DATE_LAST_OPEN + " INTEGER,"
                + " UNIQUE (" + HistoryEntry._ID + ") ON CONFLICT REPLACE);";

        db.execSQL(CreateTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + HistoryEntry.TABLE_NAME);
        onCreate(db);
    }

}
