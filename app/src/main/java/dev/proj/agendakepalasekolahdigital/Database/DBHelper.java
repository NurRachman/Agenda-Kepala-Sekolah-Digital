package dev.proj.agendakepalasekolahdigital.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import dev.proj.agendakepalasekolahdigital.Model.Agendas;

public class DBHelper {
    private Database database;
    private Context context;
    private Cursor cursor;
    private SQLiteDatabase sqLiteDatabase;

    public DBHelper(Context context) {
        this.context = context;
        database = new Database(context);
    }

}
