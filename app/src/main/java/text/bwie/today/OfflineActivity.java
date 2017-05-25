package text.bwie.today;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import text.bwie.today.Beans.Tuijian_bean;
import text.bwie.today.Db.My_tuiajin_sql;

/**
 * Created by yufuhao on 2017/5/12.
 */
public class OfflineActivity extends Activity {

    private List<String> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
        ImageView image = (ImageView) findViewById(R.id.lixian_fanhui);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //图片的监听
                finish();
            }
        });
        TextView xiazai = (TextView) findViewById(R.id.lixian_xiazai);
        xiazai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击了下载
                Toast.makeText(OfflineActivity.this, "开始下载", Toast.LENGTH_SHORT).show();
                //访问网络，并且添加在数据库中
                boolean networkAvailable = MyApplication.isNetworkAvailable(OfflineActivity.this);
                if (networkAvailable == true) {
                    httpget();
                } else {
                    Toast.makeText(OfflineActivity.this, "当前没有网络", Toast.LENGTH_SHORT).show();
                }

            }

        });
        ListView lv = (ListView) findViewById(R.id.offline_listview);
        init();

        //添加数据


        //添加适配器
        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return list.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(OfflineActivity.this, R.layout.left_listview, null);
                }
                TextView tv = (TextView) convertView.findViewById(R.id.left_listview_tv);
                tv.setText(list.get(position));
                return convertView;
            }
        });
    }


    //访问网络
    private void httpget() {
        Toast.makeText(this, "开始下载", Toast.LENGTH_SHORT).show();
        //下载推荐，并保存在数据库中
        RequestParams params = new RequestParams("http://ic.snssdk.com/2/article/v25/stream/?count=20&min_behot_time=1455521444&bd_city=%E5%8C%97%E4%BA%AC%E5%B8%82&bd_latitude=40.049317&bd_longitude=116.296499&bd_loc_time=1455521401&loc_mode=5&lac=4527&cid=28883&iid=3642583580&device_id=11131669133&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=SCH-I919U&os_api=19&os_version=4.4.2&uuid=285592931621751&openudid=AC9E172CE2490000");

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //成功
                Gson gson = new Gson();
                Tuijian_bean tuijian_bean = gson.fromJson(result, Tuijian_bean.class);
                //获得数据
                List<Tuijian_bean.DataBean> datalist = tuijian_bean.getData();
                //将数据添加在数据库中
                My_tuiajin_sql user_sql = new My_tuiajin_sql(OfflineActivity.this);
                List<Tuijian_bean.DataBean> selecttuijian = user_sql.selecttuijian();
                if (selecttuijian.size() == 0) {
                    user_sql.addtuijian(datalist);
                    Toast.makeText(OfflineActivity.this, "缓存成功", Toast.LENGTH_SHORT).show();
                } else {
                    datalist.remove(0);
                    user_sql.addtuijian(datalist);
                    Toast.makeText(OfflineActivity.this, "缓存成功", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //失败
            }

            @Override
            public void onCancelled(CancelledException cex) {
                //取消
            }

            @Override
            public void onFinished() {
                //完成
            }
        });

    }

    //添加数据
    private void init() {
        list = new ArrayList<String>();
        //添加数据
        list.add("推荐");
        list.add("热点");
        list.add("北京");
        list.add("社会");
        list.add("娱乐");
        list.add("图片");
        list.add("科技");
        list.add("汽车");
        list.add("体育");
        list.add("财经");
        list.add("国际");
        list.add("段子");
        list.add("趣图");
        list.add("美女");
        list.add("健康");
        list.add("正能量");
        list.add("特卖");
        list.add("房产");
        list.add("故事");
        list.add("文化");
        list.add("家具");
        list.add("手机");
        list.add("旅游");
        list.add("数码");
        list.add("数码");
        list.add("美食");
        list.add("搞笑");
        list.add("数码");
        list.add("养生");
        list.add("时尚");
        list.add("历史");
        list.add("情感");
        list.add("教育");
        list.add("三农");
        list.add("孕产");
        list.add("游戏");
        list.add("精选");
        list.add("股票");
        list.add("科学");
        list.add("动漫");
        list.add("收藏");
        list.add("育儿");
        list.add("星座");
        list.add("美图");
        list.add("电影");
        list.add("宠物");
        list.add("语录");
        list.add("政务");
        list.add("辟谣");
        list.add("中国新唱将");
        list.add("订阅");
        list.add("彩票");
        list.add("军事");
        list.add("小说");
        list.add("快乐男生");
    }
}
