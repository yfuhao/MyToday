package text.bwie.today;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import text.bwie.today.fragments.LeftFragment;
import text.bwie.today.fragments.RightFragment;

public class MainActivity extends SlidingFragmentActivity {

    private SlidingMenu slidingMenu;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLeftFragment();
        // asodifjasodiofjoasidjf
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

    }
}
