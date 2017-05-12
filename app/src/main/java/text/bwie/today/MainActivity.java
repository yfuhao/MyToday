package text.bwie.today;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import java.util.ArrayList;
import java.util.List;

import text.bwie.today.fragments.LeftFragment;
import text.bwie.today.fragments.RightFragment;
import text.bwie.today.fragments.mainfragments.BeijingFragment;
import text.bwie.today.fragments.mainfragments.DingyueFragment;
import text.bwie.today.fragments.mainfragments.RedianFragment;
import text.bwie.today.fragments.mainfragments.ShehuiFragment;
import text.bwie.today.fragments.mainfragments.ShipinFragment;
import text.bwie.today.fragments.mainfragments.TuijiandianFragment;

public class MainActivity extends SlidingFragmentActivity {

    private SlidingMenu slidingMenu;
    private List<Fragment> fragments=new ArrayList<>();
    private RadioGroup rg;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLeftFragment();

    }

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
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}