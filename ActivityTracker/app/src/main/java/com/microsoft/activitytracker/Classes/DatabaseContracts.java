package com.microsoft.activitytracker.Classes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by jshore on 3/31/2015.
 */
public class DatabaseContracts {

    public static final class HistoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "AccessHistory";

        public static final String COLUMN_LOGICAL_NAME = "logicalName";
        public static final String COLUMN_DATE_LAST_OPEN = "dateOpened";
        public static final String COLUMN_FULL_NAME = "name";
        public static final String COLUMN_JOB_TITLE = "jobTitle";
        public static final String COLUMN_ACCOUNT_NAME = "designatedAccount";

        public static Cursor getRecentHistory(Context context) {
            SQLiteDatabase db = new DatabaseHelper(context).getReadableDatabase();

            return db.query(TABLE_NAME, null, null,
                    null, null, null, String.format("%s DESC", COLUMN_DATE_LAST_OPEN), "15");
        }

        public static void clearRecentRecords(Context context) {
            SQLiteDatabase db = new DatabaseHelper(context).getWritableDatabase();
            db.delete(TABLE_NAME, null, null);
        }

//    public void addEntity(Entity thisEntity)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        Cursor cursor = db.query(ACCESS_HISTORY_TABLE, null, String.format("%s = ?", RECORD_ID),
//                new String[] { thisEntity.getId() }, null, null, null, null);
//
//        // if this record is NOT already in the database
//        if(cursor.getCount() < 1)
//        {
//            // bundle up all the info
//            ContentValues thisItem = new ContentValues();
//            thisItem.put(RECORD_ID, thisEntity.getId());
//            thisItem.put(LOGICAL_NAME, thisEntity.getLogicalname().name());
//            thisItem.put(FULL_NAME, thisEntity.getAttributeValue("fullname"));
//            thisItem.put(JOB_TITLE, thisEntity.getAttributeValue("jobtitle"));
//            thisItem.put(ACCOUNT_NAME, thisEntity.getAttributeValue("accountname"));
//            thisItem.put(DATE_LAST_OPEN, Calendar.getInstance().getTimeInMillis());
//
//            // insert it into the table
//            db.insert(ACCESS_HISTORY_TABLE, null, thisItem);
//        }
//        // if this record IS in the database already
//        else
//        {
//            ContentValues thisItem = new ContentValues();
//            thisItem.put(DATE_LAST_OPEN, Calendar.getInstance().getTimeInMillis());
//
//            // just update the date and time to now
//            db.update(ACCESS_HISTORY_TABLE, thisItem, String.format("%s = ?", RECORD_ID),
//                    new String[] { thisEntity.getId() });
//        }
//
//
//        db.close();
//    }
    }
}
