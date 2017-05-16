package text.bwie.today;

import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import text.bwie.today.events.MainActivityEvent;
import text.bwie.today.fragments.LeftFragment;
import text.bwie.today.fragments.RightFragment;
import text.bwie.today.fragments.mainfragments.BeijingFragment;
import text.bwie.today.fragments.mainfragments.DingyueFragment;
import text.bwie.today.fragments.mainfragments.RedianFragment;
import text.bwie.today.fragments.mainfragments.ShehuiFragment;
import text.bwie.today.fragments.mainfragments.ShipinFragment;
import text.bwie.today.fragments.mainfragments.TuijiandianFragment;

public class MainActivity extends SlidingFragmentActivity {

    private List<Fragment> list = new ArrayList<Fragment>();
    private SlidingMenu slidingMenu;
    private List<Fragment> fragments=new ArrayList<>();
    private RadioGroup rg;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLeftFragment();

        initGrayBackgroud();

        //如果当前页面 已经注册了  则不需要注册
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }

    }

    //
    //添加滑动效果
    private void initLeftFragment() {
        //左滑
        Fragment leftFragment=new LeftFragment();
        setBehindContentView(R.layout.left_frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.left_frame,leftFragment).commit();

        slidingMenu = getSlidingMenu();

        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);

        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);

        slidingMenu.setShadowDrawable(R.drawable.shadow);

        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);

        slidingMenu.setFadeDegree(0.35f);
        //右滑
        Fragment rightFragment=new RightFragment();
        slidingMenu.setSecondaryMenu(R.layout.right_frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.right_frame, rightFragment).commit();

        AddFragment();

    }

    private void AddFragment() {
        rg = (RadioGroup) findViewById(R.id.main_radioGroup);
        viewPager = (ViewPager) findViewById(R.id.main_vp);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment=null;
                switch (position){
                    case 0:
                        fragment=new TuijiandianFragment();
                        break;
                    case 1:
                        fragment=new RedianFragment();
                        break;
                    case 2:
                        fragment=new ShipinFragment();
                        break;
                    case 3:
                        fragment=new BeijingFragment();
                        break;
                    case 4:
                        fragment=new ShehuiFragment();
                        break;
                    case 5:
                        fragment=new DingyueFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 6;
            }
        });
        //radiogroup点击监听
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                for(int i=0;i<6;i++){
                    if(rg.getChildAt(i).getId()==checkedId){
                        viewPager.setCurrentItem(i);
                    }
                }
            }
        });

        //viewpager滑动
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    WindowManager windowManager ;
    WindowManager.LayoutParams layoutParams ;
    View view ;

    public void initGrayBackgroud() {
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

//        应用程序窗口。 WindowManager.LayoutParams.TYPE_APPLICATION
//        所有程序窗口的“基地”窗口，其他应用程序窗口都显示在它上面。
//        普通应用功能程序窗口。token必须设置为Activity的token，以指出该窗口属谁。

//        后面的view获得焦点
        layoutParams = new WindowManager.LayoutParams
                (WindowManager.LayoutParams.TYPE_APPLICATION,WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        PixelFormat.TRANSPARENT);
        view = new View(this);

        view.setBackgroundResource(R.color.color_window);

    }

    // 日 夜切换
// 日 夜切换
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainActivityEvent(MainActivityEvent event){
        System.out.println("isChecked = " + event.isWhite());

        if(event.isWhite()){
            // 日
            windowManager.removeViewImmediate(view);
        } else  {
            // true 夜
            windowManager.addView(view, layoutParams);

        }
        //对所有的控件取出,设置对应的图片
        setView();
        //更改字体颜色
        switchTextViewColor((ViewGroup) getWindow().getDecorView(),event.isWhite());


        /*LeftFragment leftFragment = (LeftFragment) list.get(0);
        leftFragment.changeMode(event.isWhite());*/


    }
    // 更改 控件 背景
    private   void setView(){


    }
    /**
     * 遍历出所有的textView设置对应的颜色
     * @param view
     */
    public void switchTextViewColor(ViewGroup view,boolean white) {
//        getChildCount 获取ViewGroup下view的个数
//        view.getChildAt(i) 根据下标获取对应的子view
        for (int i = 0; i < view.getChildCount(); i++) {
            if (view.getChildAt(i) instanceof ViewGroup) {
                switchTextViewColor((ViewGroup) view.getChildAt(i),white);
            } else if (view.getChildAt(i) instanceof TextView) {
                //设置颜色
                int resouseId ;
                TextView textView = (TextView) view.getChildAt(i);
                if(white){
                    resouseId = Color.BLACK;
                }else {
                    resouseId = Color.WHITE;
                }
                textView.setTextColor(resouseId);
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}