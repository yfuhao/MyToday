package text.bwie.today.fragments.mainfragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
import text.bwie.today.R;

/**
 * Created by lenovo-pc on 2017/5/11.
 */

public class TuijiandianFragment extends Fragment implements SpringView.OnFreshListener {

    private View view;
    private SpringView springView;
    private ListView listView;
    private int page = 1;
    List<Tuijian_bean.DataBean> list = new ArrayList<Tuijian_bean.DataBean>();

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:

                    break;
                case 2:

                    break;

            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tuijian_fragment, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        //创建一个上拉下拉
        springView = (SpringView) view.findViewById(R.id.springview_tuijian);
        springView.setHeader(new MeituanHeader(getActivity()));
        springView.setFooter(new MeituanFooter(getActivity()));
        springView.setType(SpringView.Type.FOLLOW);
        springView.setListener(this);
        listView = (ListView) view.findViewById(R.id.tuijian_listview);

        //访问网路给listview添加数据
        //访问网络
        httpget();

    }

    private void httpget() {
        //访问网络
        RequestParams params = new RequestParams("http://ic.snssdk.com/2/article/v25/stream/?count=20&min_behot_time=1455521444&bd_city=%E5%8C%97%E4%BA%AC%E5%B8%82&bd_latitude=40.049317&bd_longitude=116.296499&bd_loc_time=1455521401&loc_mode=5&lac=4527&cid=28883&iid=3642583580&device_id=11131669133&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=SCH-I919U&os_api=19&os_version=4.4.2&uuid=285592931621751&openudid=AC9E172CE2490000");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //成功返回的数据
                Gson gson = new Gson();
                Tuijian_bean tuijian_bean = gson.fromJson(result, Tuijian_bean.class);
                List<Tuijian_bean.DataBean> datalist = tuijian_bean.getData();
                list.addAll(datalist);
                //添加适配器
                if (page == 1) {
                    handler.sendEmptyMessage(1);
                } else {
                    handler.sendEmptyMessage(2);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //失败
                // System.out.println(" 失败 ");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                //取消
                // System.out.println(" 取消 ");
            }

            @Override
            public void onFinished() {
                //完成
                System.out.println(" 完成 ");
            }
        });
    }

    //上拉刷新
    @Override
    public void onRefresh() {
        //停止刷新
        list.clear();
        page = 1;
        httpget();

        springView.onFinishFreshAndLoad();
        //刷新数据


    }

    //下拉加载更多
    @Override
    public void onLoadmore() {
        //停止加载
        page = page + 1;
        httpget();
        springView.onFinishFreshAndLoad();
        //加载更多
    }
}
