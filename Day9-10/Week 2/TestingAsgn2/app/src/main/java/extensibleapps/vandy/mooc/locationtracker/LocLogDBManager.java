package extensibleapps.vandy.mooc.locationtracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Manager that interfaces with the location logging database.
 */
public class LocLogDBManager {
    /**
     * Logging tag.
     */
    private static final String TAG = "LocLogDBManager";

    /**
     * Location logging database
     */
    private SQLiteDatabase mDB = null;

    /**
     * Constructor for the manager
     *
     * @param context
     */
    public LocLogDBManager(Context context) {

        // Obtain a reference to the database using the helper class.
        // It will create the database if this is the first time
        // it has been accessed.
        LocDBSQLHelper helper = new LocDBSQLHelper(context);
        mDB = helper.getWritableDatabase();
    }

    /**
     * This is only for testing/grading purposes. You wouldn't normally want to
     * expose the internal database this way
     * @return
     */
    public SQLiteDatabase getSQLiteDB(){
        return mDB;
    }

    /**
     * Store a location logging entry into the database.
     *
     * @param time
     * @param lat
     * @param lon
     * @param desc
     */
    public void storeLocationData(
            String time,
            String lat,
            String lon,
            String desc) {

        // TODO FINISHED | Store the location data in the database
        String timeK= LocDBContract.FeedEntry.COLUMN_NAME_ENTRY_TIME;
        String latK = LocDBContract.FeedEntry.COLUMN_NAME_ENTRY_LATITUDE;
        String lonK = LocDBContract.FeedEntry.COLUMN_NAME_ENTRY_lONGITUDE;
        String descK = LocDBContract.FeedEntry.COLUMN_NAME_ENTRY_DESCRIPTION;
        ContentValues values = new ContentValues();
        values.put(timeK,time);
        values.put(latK,lat);
        values.put(lonK,lon);
        values.put(descK,desc);
        mDB=mDB.insert(LocDBContract.FeedEntry.TABLE_NAME, null, values);
    }

    /**
     * Delete any rows that are associated with the values given for the
     * columns. If a column isn't needed, set as null. Return the number of rows
     * deleted.
     */
    public int deleteEntries(
            String timeToDelete, String latToDelete,
            String longToDelete, String descToDelete) {

        // TODO FINISSHED| Delete any database entries with the provided params. Return the
        // TODO FINISHED| number of rows that are deleted (change the return given below)
        Cursor c = mDB.query(LocDBContract.FeedEntry.TABLE_NAME,new String[]{timeToDelete,
                latToDelete,longToDelete,descToDelete},null,null,null,null,null);
        int deleted = mDB.delete(LocDBContract.FeedEntry.TABLE_NAME,c.getPosition(),null);
        return deleted;
    }

    /**
     * Query for rows in the database associated with the values given. If a
     * column isn't needed, set it as null.
     */
    public Cursor queryEntries(
            String time, String lat,
            String lon, String desc) {

        // TODO FINISHED| Return a Cursor containing entries with the provided params.

        return mDB.query(LocDBContract.FeedEntry.TABLE_NAME,new String[]{time,
                lat,lon,desc},null,null,null,null,null);
    }
}

