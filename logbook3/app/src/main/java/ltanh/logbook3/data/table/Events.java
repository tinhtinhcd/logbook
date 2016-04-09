package ltanh.logbook3.data.table;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import ltanh.logbook3.Entities.Event;
import ltanh.logbook3.data.DatabaseHelper;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anhlt on 2/19/16.
 */
public class Events{

    static DatabaseHelper databaseHelper;
    public static final String COLUMN_NAME_ID = "id";
    public static final String venueId = "venueId";
    public static final String eventName = "eventName";
    public static final String createDate = "createDate";
    public static final String startDate = "startDate";
     public static final String dateOfEvent = "dateOfEvent";
    public static final String organizer = "organizer";
    public static final String remark = "remark";
    public static String TABLE_NAME = "events";
     static Context context;

     public Events(Context context) {
         this.context = context;
     }

     public static void onCreate(Context pContext, SQLiteDatabase pSQLiteDatabase) {
        pSQLiteDatabase.execSQL(createStatement());
        context = pContext;
    }

    public static void onUpgrade(Context pContext, SQLiteDatabase pSQLiteDatabase, int pOldVersion, int pNewVersion) {

    }

    protected static String createStatement(){
        StringBuilder createTable = new StringBuilder();
        createTable.append("Create Table `"+TABLE_NAME+"` (`");
        createTable.append(COLUMN_NAME_ID);
        createTable.append("` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        createTable.append("`"+venueId+"` BIGINT, ");
        createTable.append("`"+eventName+"` VARCHAR(255), ");
        createTable.append("`"+createDate+"` DATETIME, ");
        createTable.append("`"+dateOfEvent+"` DATETIME, ");
        createTable.append("`"+startDate+"` DATETIME, ");
        createTable.append("`"+organizer+"` BIGINT, ");
        createTable.append("`"+remark+"` VARCHAR(255)");
        createTable.append(");");
        return createTable.toString();
    }

     public void create(Event event) {
         create(Events.TABLE_NAME, event);
     }

     public List<String> getListEventName(){
         List<String> eventNames = new ArrayList<String>();
         Cursor cursor = databaseHelper.select(getColumns(Events.TABLE_NAME, Events.eventName, null),null,null);
         if(cursor.moveToFirst()){
             do{
                 eventNames.add(cursor.getString(0));
             }while (cursor.moveToNext());
         }
         return eventNames;
     }

     protected void create(String tableName, Object object) {

         ContentValues values = new ContentValues();
         try {
             for (Field field: object.getClass().getDeclaredFields()) {
                 field.setAccessible(true);
                 Object value = field.get(object);
                 if(value!=null)
                     values.put(field.getName(), value.toString());
             }
         }catch (Exception e){
             Log.e("error:", e.getMessage());
         }

         databaseHelper = new DatabaseHelper(context);
         databaseHelper.insert(tableName, values);
     }

    public static String getColumns(String table, String column,String condition){
        StringBuilder query = new StringBuilder();
        if(table!=null && column!=null && !table.isEmpty() && !column.isEmpty()){
            query.append("SELECT ");
            query.append(column);
            query.append(" FROM ");
            query.append(table);
            if (condition!=null && !condition.isEmpty()){
                query.append(" WHERE ");
                query.append(condition);
            }
        }
        return query.toString();
    }


}
