package org.sayem.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sayem on 7/14/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA = ", ";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper sInstance;

    public static final String CREATE_TABLE = "CREATE TABLE "
            + DatabaseContract.PostTable.TABLE_NAME + "("
            + DatabaseContract.PostTable.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DatabaseContract.PostTable.GYM + TEXT_TYPE + COMMA
            + DatabaseContract.PostTable.SPENDING + TEXT_TYPE + COMMA
            + DatabaseContract.PostTable.FRUITS + TEXT_TYPE + COMMA
            + DatabaseContract.PostTable.VITAMINS + TEXT_TYPE + " )";

    private DatabaseHelper(Context context) {
        super(context, DatabaseContract.DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.PostTable.TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String gym, String spending,
                              String fruits, String vitamin) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseContract.PostTable.GYM, gym);
        contentValues.put(DatabaseContract.PostTable.SPENDING, spending);
        contentValues.put(DatabaseContract.PostTable.FRUITS, fruits);
        contentValues.put(DatabaseContract.PostTable.VITAMINS, vitamin);

        long result = db.insert(DatabaseContract.PostTable.TABLE_NAME, null, contentValues);
        return result != -1;
    }

    // Update data
    public boolean updateData(String id, String gym, String spending,
                              String fruits, String vitamin) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseContract.PostTable.ID, id);
        contentValues.put(DatabaseContract.PostTable.GYM, gym);
        contentValues.put(DatabaseContract.PostTable.SPENDING, spending);
        contentValues.put(DatabaseContract.PostTable.FRUITS, fruits);
        contentValues.put(DatabaseContract.PostTable.VITAMINS, vitamin);

        db.update(DatabaseContract.PostTable.TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + DatabaseContract.PostTable.TABLE_NAME, null);
    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(DatabaseContract.PostTable.TABLE_NAME, "ID + ?", new String[]{id});
    }
}
