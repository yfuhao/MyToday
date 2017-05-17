package text.bwie.today.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import text.bwie.today.Beans.Tuijian_bean;
import text.bwie.today.MyApplication;
import text.bwie.today.R;

/**
 * Created by lenovo-pc on 2017/5/16.
 */

public class MyAdapter extends BaseAdapter {

    private List<Tuijian_bean.DataBean> list;
    private Context context;

    public MyAdapter(Context context, List<Tuijian_bean.DataBean> list) {
        this.list = list;
        this.context = context;
    }

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
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item, null);
            holder.im = (ImageView) convertView.findViewById(R.id.item_image);
            holder.tv_title = (TextView) convertView.findViewById(R.id.item_title);
            holder.tv_data = (TextView) convertView.findViewById(R.id.item_info);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
            holder.tv_title.setText(list.get(position).getTitle());
            holder.tv_data.setText(list.get(position).getSource());

            ImageLoader.getInstance().displayImage(list.get(position).getMiddle_image().getUrl(),holder.im, MyApplication.getdisplaytwo());

        return convertView;
    }

    class ViewHolder {
        TextView tv_title;
        TextView tv_data;
        ImageView im;
    }
}
