package text.bwie.today.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yufuhao on 2017/5/19.
 */

public class Tuijian_database extends SQLiteOpenHelper {
    public Tuijian_database(Context context) {
        super(context, "tuijian.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据库
        System.out.println("list_new" + "创建了数据库");
        db.execSQL("create table tuijian (id Integer primary key autoincrement,title varchar(20),media_name varchar(20),commcent_count Integer,right_image varchar(20),bottom_image01 varchar(20),bottom_image02 varchar(20),bottom_image03 varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //更新数据库
    }
}
