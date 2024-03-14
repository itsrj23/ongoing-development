package com.example.secondtryngsamplehehe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "log.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Db) {
        Db.execSQL("CREATE TABLE users(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Db, int i, int i1) {
        Db.execSQL("DROP TABLE IF EXISTS users");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase Db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = Db.insert("users", null, contentValues);
        if(result ==-1) return false;
        else
            return true;
    }
    public Boolean checkusername(String username){
        SQLiteDatabase Db = this.getWritableDatabase();
        Cursor cursor = Db.rawQuery("Select * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean checkusernamepassword(String username, String password){
        SQLiteDatabase Db = this.getWritableDatabase();
        Cursor cursor = Db.rawQuery("Select * from users where username = ? and password = ?", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
