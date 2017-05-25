package text.bwie.today.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import text.bwie.today.Beans.Tuijian_bean;

/**
 * Created by yufuhao on 2017/5/20.
 */

public class My_tuiajin_sql {

    private final SQLiteDatabase db;

    //构造方法
    public My_tuiajin_sql(Context context) {
        //创建数据库
        Tuijian_database tuiajin_db = new Tuijian_database(context);
        db = tuiajin_db.getWritableDatabase();
    }

    //添加数据
    public void addtuijian(List<Tuijian_bean.DataBean> list) {
        for (int i = 0; i < list.size(); i++) {
            //添加i条数据
            ContentValues values = new ContentValues();
            values.put("title", list.get(i).getTitle());
            values.put("media_name", list.get(i).getSource());
            values.put("commcent_count", list.get(i).getComment_count());
            //如果存在三张图片则添加进数据库
            if (list.get(i).getImage_list() != null && list.get(i).getImage_list().size() != 0) {
                if (list.get(i).getImage_list().size() == 3) {
                    //保存下方的三个图片
                    values.put("bottom_image01", list.get(i).getImage_list().get(0).getUrl());
                    values.put("bottom_image02", list.get(i).getImage_list().get(1).getUrl());
                    values.put("bottom_image03", list.get(i).getImage_list().get(2).getUrl());
                } else {
                    System.out.println("list_new" + "9999999999" + list.get(i).getImage_list().size());
                }
            } else {
                if (list.get(i).getMiddle_image() != null) {
                    //保存右侧的图片
                    values.put("right_image", list.get(i).getMiddle_image().getUrl());
                } else {
                    System.out.println("list_new" + "9999999999" + list.get(i).getImage_list().size());
                }
            }
            db.insert("tuijian", "right_image,bottom_image01,bottom_image02,bottom_image03", values);
        }
    }


    //查询
    public List<Tuijian_bean.DataBean> selecttuijian() {
        //查询全部数据
        Cursor cursor = db.query("tuijian", null, null, null, null, null, null);
        //创建需要返回的集合
        List<Tuijian_bean.DataBean> datalist = new ArrayList<>();
        //便利集合
        while (cursor.moveToNext()) {
            //查询出想要的数据
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String media_name = cursor.getString(cursor.getColumnIndex("media_name"));
            int comment_count = cursor.getInt(cursor.getColumnIndex("commcent_count"));
            String right_image = cursor.getString(cursor.getColumnIndex("right_image"));
            String bottom_image01 = cursor.getString(cursor.getColumnIndex("bottom_image01"));
            String bottom_image02 = cursor.getString(cursor.getColumnIndex("bottom_image02"));
            String bottom_image03 = cursor.getString(cursor.getColumnIndex("bottom_image03"));
//            //输出查询到的数据
//            System.out.println("list_new" + title + media_name + comment_count + right_image + bottom_image01 + bottom_image02 + bottom_image03);
            //创建一个对象
            Tuijian_bean.DataBean bean = new Tuijian_bean.DataBean();
            //查询出数据，添加进集合
            bean.setTitle(title);
            //添加来源
            bean.setSource(media_name);
            bean.setComment_count(comment_count);


            //如果下方的图片不为空，则把图片添加进集合中
            if (bottom_image01 != null && bottom_image02 != null && bottom_image03 != null) {
                //创建集合
                List<Tuijian_bean.DataBean.ImageListBean> bottom_imgage_list = new ArrayList<Tuijian_bean.DataBean.ImageListBean>();
                //创建三个对象,添加三个图片
                Tuijian_bean.DataBean.ImageListBean img01 = new Tuijian_bean.DataBean.ImageListBean();
                Tuijian_bean.DataBean.ImageListBean img02 = new Tuijian_bean.DataBean.ImageListBean();
                Tuijian_bean.DataBean.ImageListBean img03 = new Tuijian_bean.DataBean.ImageListBean();
                //三个对象添加数据
                img01.setUrl(bottom_image01);
                img02.setUrl(bottom_image02);
                img03.setUrl(bottom_image03);
                //将三个对象添加到list集合中
                bottom_imgage_list.add(img01);
                bottom_imgage_list.add(img02);
                bottom_imgage_list.add(img03);

                //将数据添加到bean对象中
                bean.setImage_list(bottom_imgage_list);
            } else {
                //创建一个middleimageBean
                Tuijian_bean.DataBean.MiddleImageBean middleImageBean = new Tuijian_bean.DataBean.MiddleImageBean();
                middleImageBean.setUrl(right_image);
                //添加右边的图片
                bean.setMiddle_image(middleImageBean);
            }
            //添加到list集合
            datalist.add(bean);
        }
        return datalist;
    }
    //删除数据

    public boolean delettuijian() {
        int tuijian = db.delete("tuijian", null, null);
        if (tuijian > 0) {
            return true;
        } else {
            return false;
        }

    }
}
