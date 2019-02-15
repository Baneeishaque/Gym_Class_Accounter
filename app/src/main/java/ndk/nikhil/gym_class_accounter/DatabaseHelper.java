package ndk.nikhil.gym_class_accounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    public long insertNote(String name, String address, String photo, String join_date, String fee_structure, String fee) {

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

}

