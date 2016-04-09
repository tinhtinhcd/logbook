package ltanh.logbook3.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ltanh.logbook3.data.table.Events;

/**
 * Created by anhlt on 2/19/16.
 */

class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 7;
    public static final String DB_NAME = "mad_discover.db";
    public static String dateFormat = "MMM-dd-yyyy";
    public static String dateTimeFormat = "MMM-dd-yyyy hh:mm";

    private static Context context;

    public MySQLiteOpenHelper(Context context){
        super(context, DB_NAME, null, MySQLiteOpenHelper.DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Events.onCreate(context, sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlLiteDatabase, int oldVersion, int newVersion) {
        Events.onUpgrade(context, sqlLiteDatabase, oldVersion, newVersion);
    }
}
