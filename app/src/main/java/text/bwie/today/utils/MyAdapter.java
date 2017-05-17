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
    public int getItemViewType(int position) {
        if (list.get(position).getImage_list().size()==0) {
            return 0;
        } else {
            return 1;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        ViewHolderthree three = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            if (type == 0) {
                holder = new ViewHolder();
                convertView = convertView.inflate(context, R.layout.item, null);
                holder.im = (ImageView) convertView.findViewById(R.id.item_image);
                holder.tv_title = (TextView) convertView.findViewById(R.id.item_title);
                holder.tv_data = (TextView) convertView.findViewById(R.id.item_info);
                convertView.setTag(holder);
            } else if (type == 1) {
                three = new ViewHolderthree();
                convertView = convertView.inflate(context, R.layout.three, null);
                three.tv_title = (TextView) convertView.findViewById(R.id.three_title);
                three.tv_data = (TextView) convertView.findViewById(R.id.three_foot);
                three.image01 = (ImageView) convertView.findViewById(R.id.three_one_image);
                three.image02 = (ImageView) convertView.findViewById(R.id.three_two_image);
                three.image03 = (ImageView) convertView.findViewById(R.id.three_three_image);
                convertView.setTag(three);
            }
        } else {
            if (type == 0) {
                holder = (ViewHolder) convertView.getTag();
            } else if (type == 1) {
                three = (ViewHolderthree) convertView.getTag();
            }
        }
        if (type == 0) {
            holder.tv_title.setText(list.get(position).getTitle());
            holder.tv_data.setText(list.get(position).getSource());
            ImageLoader.getInstance().displayImage(list.get(position).getMiddle_image().getUrl(), holder.im, MyApplication.getdisplaytwo());
        } else if (type == 1) {
            three.tv_title.setText(list.get(position).getTitle());
            three.tv_data.setText(list.get(position).getSource());
            ImageLoader.getInstance().displayImage(list.get(position).getImage_list().get(0).getUrl(), three.image01, MyApplication.getdisplaytwo());
            ImageLoader.getInstance().displayImage(list.get(position).getImage_list().get(1).getUrl(), three.image02, MyApplication.getdisplaytwo());
            ImageLoader.getInstance().displayImage(list.get(position).getImage_list().get(2).getUrl(), three.image03, MyApplication.getdisplaytwo());
        }

        return convertView;
    }

    class ViewHolder {
        TextView tv_title;
        TextView tv_data;
        ImageView im;
    }

    class ViewHolderthree {
        TextView tv_title;
        TextView tv_data;
        ImageView image01;
        ImageView image02;
        ImageView image03;
    }
}
