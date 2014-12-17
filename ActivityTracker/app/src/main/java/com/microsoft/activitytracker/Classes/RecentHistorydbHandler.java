// Android Activity Tracker Sample app for Microsoft Dynamics CRM
//
// Copyright (c) Microsoft Corporation
// All rights reserved.
// MIT License
//
// Permission is hereby granted, free of charge, to any person obtaining a copy of this software
// and associated documentation files (the ""Software""), to deal in the Software without
// restriction, including without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
// Software is furnished to do so, subject to the following conditions:
//
//    The above copyright notice and this permission notice shall be included in all copies
//    or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
// BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
// DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

package com.microsoft.activitytracker.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RecentHistorydbHandler extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "ActivityTracker";
    private static final int DATABASE_VERSION = 1;

    private static final String ACCESS_HISTORY_TABLE = "AccessHistory";

    private static final String LOGICAL_NAME = "logicalName";
    private static final String DATE_LAST_OPEN = "dateOpened";
    private static final String RECORD_ID = "guidId";
    private static final String FULL_NAME = "name";
    private static final String JOB_TITLE = "jobTitle";
    private static final String ACCOUNT_NAME = "designatedAccount";

    public RecentHistorydbHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CreateTableQuery = "CREATE TABLE " + ACCESS_HISTORY_TABLE + "("
                + RECORD_ID + " INTEGER,"
                + FULL_NAME + " TEXT,"
                + JOB_TITLE + " TEXT,"
                + ACCOUNT_NAME + " TEXT,"
                + LOGICAL_NAME + " TEXT,"
                + DATE_LAST_OPEN + " INTEGER" + ")";

        db.execSQL(CreateTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + ACCESS_HISTORY_TABLE);

        // Create tables again
        onCreate(db);
    }

    public List<Entity> getRecentHistory()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Entity> FullHistory = new ArrayList<Entity>();

        Cursor cNeedle = db.query( ACCESS_HISTORY_TABLE, null, null,
                null, null, null, String.format("%s DESC", DATE_LAST_OPEN), "15");

        if (cNeedle.moveToFirst())
        {
            while (!cNeedle.isAfterLast())
            {
                Entity thisEntity = new Entity();

                thisEntity.setId(cNeedle.getString(cNeedle.getColumnIndex(RECORD_ID)));
                thisEntity.setLogicalName(cNeedle.getString(cNeedle.getColumnIndex(LOGICAL_NAME)));
                thisEntity.attributes.put("fullname", cNeedle.getString(cNeedle.getColumnIndex(FULL_NAME)));
                thisEntity.attributes.put("jobtitle", cNeedle.getString(cNeedle.getColumnIndex(JOB_TITLE)));
                thisEntity.attributes.put("accountname", cNeedle.getString(cNeedle.getColumnIndex(ACCOUNT_NAME)));

                FullHistory.add(thisEntity);
                cNeedle.moveToNext();
            }
        }

        db.close();
        return FullHistory;
    }

    public void addEntity(Entity thisEntity)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(ACCESS_HISTORY_TABLE, null, String.format("%s = ?", RECORD_ID),
                new String[] { thisEntity.getId() }, null, null, null, null);

        // if this record is NOT already in the database
        if(cursor.getCount() < 1)
        {
            // bundle up all the info
            ContentValues thisItem = new ContentValues();
            thisItem.put(RECORD_ID, thisEntity.getId());
            thisItem.put(LOGICAL_NAME, thisEntity.getLogicalname().name());
            thisItem.put(FULL_NAME, thisEntity.getAttributeValue("fullname"));
            thisItem.put(JOB_TITLE, thisEntity.getAttributeValue("jobtitle"));
            thisItem.put(ACCOUNT_NAME, thisEntity.getAttributeValue("accountname"));
            thisItem.put(DATE_LAST_OPEN, Calendar.getInstance().getTimeInMillis());

            // insert it into the table
            db.insert(ACCESS_HISTORY_TABLE, null, thisItem);
        }
        // if this record IS in the database already
        else
        {
            ContentValues thisItem = new ContentValues();
            thisItem.put(DATE_LAST_OPEN, Calendar.getInstance().getTimeInMillis());

            // just update the date and time to now
            db.update(ACCESS_HISTORY_TABLE, thisItem, String.format("%s = ?", RECORD_ID),
                    new String[] { thisEntity.getId() });
        }


        db.close();
    }

    public void clearRecentRecords() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(ACCESS_HISTORY_TABLE, null, null);
    }
}
