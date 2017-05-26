package text.bwie.today.fragments.mainfragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.liaoinstan.springview.container.MeituanFooter;
import com.liaoinstan.springview.container.MeituanHeader;
import com.liaoinstan.springview.widget.SpringView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import text.bwie.today.Beans.Tuijian_bean;
import text.bwie.today.Db.My_tuiajin_sql;
import text.bwie.today.MyApplication;
import text.bwie.today.R;
import text.bwie.today.WebActivity;
import text.bwie.today.utils.Tuijian_adapter;

/**
 * Created by lenovo-pc on 2017/5/11.
 */

public class RedianFragment extends Fragment implements SpringView.OnFreshListener{
    private View view;
    private SpringView springView;
    private ListView listView;
    private int page = 1;
    private Tuijian_adapter adapter;
    private RequestParams params;
    private List<Tuijian_bean.DataBean> list = new ArrayList<Tuijian_bean.DataBean>();
    private My_tuiajin_sql usersql;
    private List<Tuijian_bean.DataBean> selecttuijian;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    //创建适配器，并给listview添加适配器
                    adapter = new Tuijian_adapter(getActivity(), list);
                    listView.setAdapter(adapter);
                    break;
                case 2:
                    //刷新数据
                    adapter.notifyDataSetChanged();
                    break;

            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.redian_fragment,container,false);

        //创建数据库
        usersql = new My_tuiajin_sql(getActivity());
        //创建网络的url
        params = new RequestParams("http://ic.snssdk.com/2/article/v25/stream/?category=news_hot&count=20&min_behot_time=1455521166&bd_city=北京市&bd_latitude=40.049317&bd_longitude=116.296499&bd_loc_time=1455521401&loc_mode=5&lac=4527&cid=28883&iid=3642583580&device_id=11131669133&ac=wifi&channel=baidu&aid=13&app_nme=news_article&version_code=460&device_platform=android&device_type=SCH-I919U&os_api=19&os_version=4.4.2&uuid=285592931621751&openudid=AC9E172CE2490000");
        init(view);
        return view;
    }

    private void init(View view) {
        //创建一个上拉下拉
        springView = (SpringView) view.findViewById(R.id.springview_redian);
        springView.setHeader(new MeituanHeader(getActivity()));
        springView.setFooter(new MeituanFooter(getActivity()));
        springView.setType(SpringView.Type.FOLLOW);
        //下拉监听
        springView.setListener(this);
        listView = (ListView) view.findViewById(R.id.redian_listview);


        //查询数据库
        selsql();
        //判断当网络
        boolean networkAvailable = MyApplication.isNetworkAvailable(getActivity());
        if (networkAvailable == true) {
            //有网的时候
            //访问网络,并添加数据
            httpget();
        } else {
            //没网的时候
            List<Tuijian_bean.DataBean> selsql = selsql();
            list.addAll(selsql);
            handler.sendEmptyMessage(1);

        }


        //条目监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //条目监听,传递数据

                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("url", list.get(position).getDisplay_url());
                System.out.println("list_new" + list.get(position).getShare_url());
                startActivity(intent);
            }
        });
    }

    //访问网路给listview添加数据
    private void httpget() {
        //访问网络
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //成功返回的数据
                Gson gson = new Gson();
                //解析数据
                Tuijian_bean tuijian_bean = gson.fromJson(result, Tuijian_bean.class);
                List<Tuijian_bean.DataBean> data = tuijian_bean.getData();

                //添加适配器
                if (page == 1) {
                    //把访问网络获得的数据存在数据库中
                    list.addAll(data);
                    handler.sendEmptyMessage(1);
                } else {
                    data.remove(0);
                    //把访问网络获得的数据存在数据库中
                    list.addAll(data);
                    handler.sendEmptyMessage(2);
                }

                List<Tuijian_bean.DataBean> selsql = selsql();
                if (selsql.size() == 0) {
                    addsql(data);
                } else {
                    data.remove(0);
                    addsql(data);
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

    //下拉刷新
    @Override
    public void onRefresh() {

        //判断网络，有网加载更多，没网toast显示
        if (MyApplication.isNetworkAvailable(getActivity())) {
            //停止刷新
            list.clear();
            page = 1;
            //访问网络
            httpget();

        } else {
            List<Tuijian_bean.DataBean> selsql = selsql();
            list.clear();
            list.addAll(selsql);
            handler.sendEmptyMessage(1);

            Toast.makeText(getActivity(), "暂时没网", Toast.LENGTH_SHORT).show();
        }
        //刷新数据
        springView.onFinishFreshAndLoad();

    }

    //下拉加载更多
    @Override
    public void onLoadmore() {
        if (MyApplication.isNetworkAvailable(getActivity())) {  //停止加载
            page = page + 1;
            httpget();
        } else {
            Toast.makeText(getActivity(), "暂时没网", Toast.LENGTH_SHORT).show();
        }
        springView.onFinishFreshAndLoad();
        //加载更多
    }

    //添加数据到数据库
    public void addsql(List<Tuijian_bean.DataBean> list) {
        usersql.addtuijian(list);
    }

    //查询数据到
    public List<Tuijian_bean.DataBean> selsql() {
        List<Tuijian_bean.DataBean> selecttuijian = usersql.selecttuijian();
        return selecttuijian;
    }
}
