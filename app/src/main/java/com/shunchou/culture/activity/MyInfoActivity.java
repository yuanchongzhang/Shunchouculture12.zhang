package com.shunchou.culture.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.shunchou.culture.R;
import com.zcx.helper.activity.AppActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/14.
 */
public class MyInfoActivity extends AppActivity {


    @InjectView(R.id.btn_return)
    ImageView btnReturn;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.btn_right)
    ImageView btnRight;
    @InjectView(R.id.img_default)
    ImageView imgDefault;
    @InjectView(R.id.text_name)
    TextView textName;
    @InjectView(R.id.text_number)
    TextView textNumber;
    @InjectView(R.id.text_bianji)
    Button textBianji;
    @InjectView(R.id.btn_save)
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);
        ButterKnife.inject(this);

    }

    @OnClick({R.id.btn_return, R.id.title_text, R.id.btn_right, R.id.img_default, R.id.text_name, R.id.text_number, R.id.text_bianji, R.id.btn_save})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_return:
                finish();
                break;
            case R.id.title_text:
                break;
            case R.id.btn_right:
                break;
            case R.id.img_default:
                break;
            case R.id.text_name:
                break;
            case R.id.text_number:
                break;
            case R.id.text_bianji:
                startActivity(new Intent(this,EditInfoActivity.class));

                break;
            case R.id.btn_save:
                break;
        }
    }
}
