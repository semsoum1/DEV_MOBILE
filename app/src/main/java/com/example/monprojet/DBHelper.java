package com.example.monprojet;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";
    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table annonce(titre TEXT primary key, spinnerville TEXT,spinnercat TEXT)");
        MyDB.execSQL("select count(titre),ville from annonce group by ville");    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists annonce");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;

    }
    public boolean insertData2(String spinnerville){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("ville", spinnerville);
        long result = MyDB.insert("annonce", null, contentValues);
        if(result==-1) return false;
        else
            return true;

    }
    public boolean insertData3(String spinnercat){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("cat", spinnercat);
        long result = MyDB.insert("annonce", null, contentValues);
        if(result==-1) return false;
        else
            return true;

    }
    public boolean insertData4(String titre){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("titre", titre);
        long result = MyDB.insert("annonce", null, contentValues);
        if(result==-1) return false;
        else
            return true;

    }

    public String getSingleValue() {
        SQLiteDatabase MyDB = this.getReadableDatabase();
        String value = null;

        Cursor cursor = MyDB.query("annonce", new String[]{"value"}, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            cursor.getCount();
        }

        cursor.close();
        MyDB.close();

        return value;
    }


    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }


}
