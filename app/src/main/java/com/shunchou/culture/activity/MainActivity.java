package com.shunchou.culture.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.shunchou.culture.R;
import com.shunchou.culture.adapter.MyGridAdapter;
import com.shunchou.culture.fragment.RightFragment;
import com.shunchou.culture.view.BannerLayout;
import com.shunchou.culture.view.MyGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawer_layout;
    //    private FrameLayout fly_content;
    private View topbar;
    private ImageView btn_right;
    private RightFragment fg_right_menu;

    private FragmentManager fManager;

    private BannerLayout bannerLayout;

    private MyGridView gridview;

    private ImageView btn_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//去掉Activity上面的状态栏
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        fManager = getSupportFragmentManager();
        fg_right_menu = (RightFragment) fManager.findFragmentById(R.id.fg_right_menu);

        initViews();

    }

    private void initViews() {
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        // fly_content = (FrameLayout) findViewById(R.id.fly_content);
        topbar = findViewById(R.id.topbar);
        btn_right = (ImageView) topbar.findViewById(R.id.btn_right);
        btn_right.setOnClickListener(this);
        btn_return = (ImageView) findViewById(R.id.btn_return);
        btn_return.setVisibility(View.GONE);
        //设置右面的侧滑菜单只能通过编程来打开
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
                Gravity.END);

        drawer_layout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View view, float v) {

            }

            @Override
            public void onDrawerOpened(View view) {

            }

            @Override
            public void onDrawerClosed(View view) {
                drawer_layout.setDrawerLockMode(
                        DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.END);
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });

        fg_right_menu.setDrawerLayout(drawer_layout);

        bannerLayout = (BannerLayout) findViewById(R.id.banner2);

        final List<String> urls = new ArrayList<>();
        urls.add("http://img3.imgtn.bdimg.com/it/u=2674591031,2960331950&fm=23&gp=0.jpg");
        urls.add("http://img5.imgtn.bdimg.com/it/u=3639664762,1380171059&fm=23&gp=0.jpg");
        urls.add("http://img0.imgtn.bdimg.com/it/u=1095909580,3513610062&fm=23&gp=0.jpg");
        urls.add("http://img4.imgtn.bdimg.com/it/u=1030604573,1579640549&fm=23&gp=0.jpg");
        urls.add("http://img5.imgtn.bdimg.com/it/u=2583054979,2860372508&fm=23&gp=0.jpg");
        bannerLayout.setViewUrls(urls);

        //添加监听事件
        bannerLayout.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
        gridview = (MyGridView) findViewById(R.id.gridview);
        gridview.setAdapter(new MyGridAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    startActivity(new Intent(MainActivity.this, SaveAnswerActivity.class));
                } else if (i == 1) {
                    startActivity(new Intent(MainActivity.this, FillDataActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    @Override
    public void onClick(View v) {
        drawer_layout.openDrawer(Gravity.END);
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
                Gravity.END);    //解除锁定
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //弹出确定退出对话框
            new AlertDialog.Builder(this)
                    .setTitle("退出")
                    .setMessage("确定退出吗？")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            Intent exit = new Intent(Intent.ACTION_MAIN);
                            exit.addCategory(Intent.CATEGORY_HOME);
                            exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(exit);
                            System.exit(0);
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            dialog.cancel();
                        }
                    })
                    .show();
            //这里不需要执行父类的点击事件，所以直接return
            return true;
        }
        //继续执行父类的其他点击事件
        return super.onKeyDown(keyCode, event);
    }
}
