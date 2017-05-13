package text.bwie.today;

import android.app.Application;

import org.xutils.x;


/**
 * Created by lenovo-pc on 2017/5/11.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
