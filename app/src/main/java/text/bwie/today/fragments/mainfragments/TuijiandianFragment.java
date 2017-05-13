package text.bwie.today.fragments.mainfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.liaoinstan.springview.container.MeituanFooter;
import com.liaoinstan.springview.container.MeituanHeader;
import com.liaoinstan.springview.widget.SpringView;

import text.bwie.today.R;

/**
 * Created by lenovo-pc on 2017/5/11.
 */

public class TuijiandianFragment extends Fragment implements SpringView.OnFreshListener {

    private View view;
    private SpringView springView;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tuijian_fragment, container, false);
        //init(view);
        return view;
    }

//    private void init(View view) {
//        //创建一个上拉下拉
//        springView = (SpringView) view.findViewById(R.id.springview_tuijian);
//        springView.setHeader(new MeituanHeader(getActivity()));
//        springView.setFooter(new MeituanFooter(getActivity()));
//        springView.setType(SpringView.Type.FOLLOW);
//        springView.setListener(this);
//        listView = (ListView) view.findViewById(R.id.tuijian_listview);
//
//    }

    //上拉刷新
    @Override
    public void onRefresh() {
        System.out.println(" hao " );
        //停止刷新
        springView.onFinishFreshAndLoad();
        //刷新数据


    }

    //下拉加载更多
    @Override
    public void onLoadmore() {
        System.out.println(" hao" );
        //停止加载
        springView.onFinishFreshAndLoad();
        //加载更多
    }
}
