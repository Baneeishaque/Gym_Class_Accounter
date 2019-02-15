package ndk.nikhil.gym_class_accounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravi on 15/03/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "gym_class_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(Model_Gym_Class.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Model_Gym_Class.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertNote(String name, String address, byte[] photo, String join_date, String fee_structure, String fee) {

        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Model_Gym_Class.COLUMN_NAME, name);
        values.put(Model_Gym_Class.COLUMN_ADDRESS, address);
        values.put(Model_Gym_Class.COLUMN_PHOTO, photo);
        values.put(Model_Gym_Class.COLUMN_JOIN_DATE, join_date);
        values.put(Model_Gym_Class.COLUMN_FEE_STRUCTURE, fee_structure);
        values.put(Model_Gym_Class.COLUMN_FEE, fee);

        // insert row
        long id = db.insert(Model_Gym_Class.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public List<Model_Gym_Class> getAllNotes() {
        List<Model_Gym_Class> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Model_Gym_Class.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Model_Gym_Class note = new Model_Gym_Class();
                note.setId(cursor.getInt(cursor.getColumnIndex(Model_Gym_Class.COLUMN_ID)));
                note.setName(cursor.getString(cursor.getColumnIndex(Model_Gym_Class.COLUMN_NAME)));
                note.setAddress(cursor.getString(cursor.getColumnIndex(Model_Gym_Class.COLUMN_ADDRESS)));
//                note.setPhoto(cursor.getString(cursor.getColumnIndex(Model_Gym_Class.COLUMN_PHOTO)));
                note.setJoin_date(cursor.getString(cursor.getColumnIndex(Model_Gym_Class.COLUMN_JOIN_DATE)));
                note.setFee_structure(cursor.getString(cursor.getColumnIndex(Model_Gym_Class.COLUMN_FEE_STRUCTURE)));
                note.setFee(cursor.getString(cursor.getColumnIndex(Model_Gym_Class.COLUMN_FEE)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }


}

