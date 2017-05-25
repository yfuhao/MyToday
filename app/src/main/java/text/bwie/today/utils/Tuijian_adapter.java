package text.bwie.today.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import text.bwie.today.Beans.Tuijian_bean;
import text.bwie.today.MyApplication;
import text.bwie.today.R;

/**
 * Created by yufuhao on 2017/5/19.
 */

public class Tuijian_adapter extends BaseAdapter {
    Context context;
    List<Tuijian_bean.DataBean> list;

    public Tuijian_adapter(Context context, List<Tuijian_bean.DataBean> list) {
        this.context = context;
        this.list = list;
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
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = convertView.inflate(context, R.layout.item, null);
            viewHolder = new ViewHolder();
            viewHolder.item_title = (TextView) convertView.findViewById(R.id.item_title);
            viewHolder.item_media_name = (TextView) convertView.findViewById(R.id.item_media_name);
            viewHolder.item_comment_count = (TextView) convertView.findViewById(R.id.item_comment_count);
            //右方的图片
            viewHolder.right_image = (ImageView) convertView.findViewById(R.id.item_middle_image);
            //下方的图片
            viewHolder.item_image01 = (ImageView) convertView.findViewById(R.id.item_image01);
            viewHolder.item_image02 = (ImageView) convertView.findViewById(R.id.item_image02);
            viewHolder.item_image03 = (ImageView) convertView.findViewById(R.id.item_image03);
            viewHolder.item_bottom_layout = (LinearLayout) convertView.findViewById(R.id.item_image_layout);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Tuijian_bean.DataBean news = list.get(position);
        //System.out.println("list_news " + news.getMiddle_image().getUrl());

        viewHolder.item_title.setText(news.getTitle());
        viewHolder.item_media_name.setText(news.getSource());
        viewHolder.item_comment_count.setText("评论 " + news.getComment_count());
        List<Tuijian_bean.DataBean.ImageListBean> image_list = news.getImage_list();
        viewHolder.item_media_name.setVisibility(View.VISIBLE);
        if (image_list != null && image_list.size() != 0) {
            //如果image_list的个数等于3，则添加图片
            if (image_list.get(0).getUrl() != null && image_list.get(1).getUrl() != null && image_list.get(2).getUrl() != null) {
                viewHolder.right_image.setVisibility(View.GONE);
                viewHolder.item_bottom_layout.setVisibility(View.VISIBLE);
                ImageLoader.getInstance().displayImage(image_list.get(0).getUrl(), viewHolder.item_image01, MyApplication.getdisplaytwo());
                ImageLoader.getInstance().displayImage(image_list.get(1).getUrl(), viewHolder.item_image02, MyApplication.getdisplaytwo());
                ImageLoader.getInstance().displayImage(image_list.get(2).getUrl(), viewHolder.item_image03, MyApplication.getdisplaytwo());
            }
        } else {
            if (list.get(position).getMiddle_image() != null) {
                if (list.get(position).getMiddle_image().getUrl() != null) {

                    //显示和隐藏
                    viewHolder.right_image.setVisibility(View.VISIBLE);
                    viewHolder.item_bottom_layout.setVisibility(View.GONE);
                    System.out.println("list_new" + list.get(position).getMiddle_image().getUri() + 1111);
                    ImageLoader.getInstance().displayImage(list.get(position).getMiddle_image().getUrl(), viewHolder.right_image, MyApplication.getdisplaytwo());
                } else {
                    //不显示图片
                    viewHolder.right_image.setVisibility(View.GONE);
                    viewHolder.item_bottom_layout.setVisibility(View.GONE);
                    System.out.println("list_new " + "没有图片" + "  " + list.get(position).getUrl());
                }
            } else {
                //不显示图片
                viewHolder.right_image.setVisibility(View.GONE);
                viewHolder.item_bottom_layout.setVisibility(View.GONE);
                System.out.println("list_new " + "没有右侧图片" + "  " + list.get(position).getUrl());
            }

        }

        return convertView;
    }

    class ViewHolder {
        //新闻标题
        TextView item_title;
        //新闻源
        TextView item_media_name;
        //评论数
        TextView item_comment_count;
        //右边的图片
        ImageView right_image;
        //下边的布局
        LinearLayout item_bottom_layout;
        //下边的图片
        ImageView item_image01;
        ImageView item_image02;
        ImageView item_image03;

    }
}
