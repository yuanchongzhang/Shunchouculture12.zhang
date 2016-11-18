package com.shunchou.culture.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shunchou.culture.R;
import com.shunchou.culture.activity.LoginActivity;
import com.shunchou.culture.activity.MyInfoActivity;
import com.shunchou.culture.activity.SaveAnswerActivity;
import com.shunchou.culture.activity.SaveQuestionActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Jay on 2015/10/9 0009.
 */
public class RightFragment extends Fragment {


    @InjectView(R.id.close_img)
    ImageView closeImg;
    @InjectView(R.id.mydata)
    TextView mydata;
    @InjectView(R.id.text_save)
    TextView textSave;
    @InjectView(R.id.text_login)
    TextView textLogin;
    @InjectView(R.id.text_exit)
    TextView textExit;
    private DrawerLayout drawer_layout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_right, container, false);


        ButterKnife.inject(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.close_img, R.id.mydata, R.id.text_save, R.id.text_login, R.id.text_exit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close_img:
              //  startActivity(new Intent(getActivity(), MyInfoActivity.class));
                drawer_layout.closeDrawer(Gravity.END);
                break;
            case R.id.mydata:
                startActivity(new Intent(getActivity(), MyInfoActivity.class));
                drawer_layout.closeDrawer(Gravity.END);
                break;
            case R.id.text_save:
                startActivity(new Intent(getActivity(), SaveAnswerActivity.class));
                drawer_layout.closeDrawer(Gravity.END);
                break;
            case R.id.text_login:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                drawer_layout.closeDrawer(Gravity.END);
                break;
            case R.id.text_exit:
             //   startActivity(new Intent(getActivity(), SaveQuestionActivity.class));

                //弹出确定退出对话框
                new AlertDialog.Builder(getActivity())
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


                drawer_layout.closeDrawer(Gravity.END);
                break;
        }
    }

    public void setDrawerLayout(DrawerLayout drawer_layout){
        this.drawer_layout = drawer_layout;
    }


}
