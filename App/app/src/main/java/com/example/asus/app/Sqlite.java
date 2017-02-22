package com.example.asus.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asus on 2017/2/19.
 */

public class Sqlite extends SQLiteOpenHelper {
   public static final String TABLE_NAME ="user";
    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String NOTE = "note";


    public Sqlite(Context context) {
        super(context, "rizhi.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT NO NULL," + NOTE + " TEXT NO NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
