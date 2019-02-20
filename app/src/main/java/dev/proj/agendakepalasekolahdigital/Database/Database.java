package dev.proj.agendakepalasekolahdigital.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static String databaseName = "agendaKepsek,db";
    private static Integer databaseVersion = 1;

    Database(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "";

        // Repeat 1 : Repeat, 2 : No Repeat
        sql = "CREATE TABLE agenda (" +
                "id Integer Primary Key," +
                "namaAcaara Text," +
                "lokasiAcara Text," +
                "tanggal Text," +
                "waktu Text," +
                "repeat Integer)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
