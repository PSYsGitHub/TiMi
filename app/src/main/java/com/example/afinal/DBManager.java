package com.example.afinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS names (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableQuery = "DROP TABLE IF EXISTS names";
        db.execSQL(dropTableQuery);
        onCreate(db);
    }

    public void saveName(String name) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO names (name) VALUES ('" + name + "')");
        db.close();
    }

    public String getName() {
        SQLiteDatabase db = getReadableDatabase();
        String selectQuery = "SELECT name FROM names";
        Cursor cursor = db.rawQuery(selectQuery, null);
        String name = "";

        if (cursor != null && cursor.moveToFirst()) { // 커서가 null이 아니고 커서를 이동시킬 수 있다면
            int nameIndex = cursor.getColumnIndex("name"); // "name" 열의 인덱스 가져오기
            if (nameIndex >= 0) { // 인덱스가 올바른 값인지 확인
                name = cursor.getString(nameIndex); // 이름 값 가져오기
            }
        }

        if (cursor != null) {
            cursor.close(); // 커서 닫기
        }
        db.close(); // 데이터베이스 닫기

        return name;
    }
}