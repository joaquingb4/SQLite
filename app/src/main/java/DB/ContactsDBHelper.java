package DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Contacts;
import android.util.Log;
//import com.example.sqlite.DB.ContactsContract.*;



import androidx.annotation.Nullable;

import Model.Contact;

public class ContactsDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contacts.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            ContactsContract.ContactsEntry.TABLE_NAME + "(" + ContactsContract.ContactsEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ContactsContract.ContactsEntry.COLUMN_NAME_TITLE + " TEXT)";
    public ContactsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void insertContact(SQLiteDatabase db, Contact c){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the contacts getting all values
            values.put(ContactsContract.ContactsEntry.COLUMN_NAME_TITLE, c.getNom());

            db.insert(ContactsContract.ContactsEntry.TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
