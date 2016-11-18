package com.shunchou.culture.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shunchou.culture.R;
import com.shunchou.culture.adapter.AnswerQuestionAdapter;
import com.zcx.helper.activity.AppActivity;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/15.
 */
public class FillDataActivity extends AppActivity {
    @InjectView(R.id.btn_return)
    ImageView btnReturn;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.btn_right)
    ImageView btnRight;
    @InjectView(R.id.text_requesttime)
    TextView textRequesttime;
    @InjectView(R.id.text_searchtime)
    TextView textSearchtime;
    @InjectView(R.id.text_hechatime)
    TextView textHechatime;
    @InjectView(R.id.RadioA)
    RadioButton RadioA;
    @InjectView(R.id.RadioB)
    RadioButton RadioB;
    @InjectView(R.id.RadioC)
    RadioButton RadioC;
    @InjectView(R.id.mRadioGroup)
    RadioGroup mRadioGroup;
    @InjectView(R.id.text_province)
    TextView textProvince;
    @InjectView(R.id.datafill_layout)
    RelativeLayout datafillLayout;
    @InjectView(R.id.text_city)
    TextView textCity;
    @InjectView(R.id.datafillcity_layout)
    RelativeLayout datafillcityLayout;
    @InjectView(R.id.edittext_city)
    EditText edittextCity;
    @InjectView(R.id.county_layout)
    RelativeLayout countyLayout;
    @InjectView(R.id.edittext_street)
    EditText edittextStreet;
    @InjectView(R.id.street_layout)
    RelativeLayout streetLayout;
    @InjectView(R.id.edittext_neighborhood)
    EditText edittextNeighborhood;
    @InjectView(R.id.neighborhood_layout)
    RelativeLayout neighborhoodLayout;


    private ArrayList<String> list = new ArrayList<>();
    private AnswerQuestionAdapter myAdapter;

    private PopupWindow popLeft;
    private View layoutLeft;

    // 左中右三个ListView控件（弹出窗口里）
    private ListView menulistLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filldata);
        ButterKnife.inject(this);

        initData();
    }

    private void initData() {
        datafillLayout = (RelativeLayout) this.findViewById(R.id.datafill_layout);
        // datafillLayout.setOnClickListener(myListener);
        for (int i = 0; i < 15; i++) {
            list.add(1 + i + "");
        }

    }

    @OnClick({R.id.btn_return, R.id.title_text, R.id.btn_right, R.id.text_requesttime, R.id.text_searchtime, R.id.text_hechatime, R.id.RadioA, R.id.RadioB, R.id.RadioC, R.id.mRadioGroup, R.id.text_province, R.id.datafill_layout, R.id.text_city, R.id.datafillcity_layout, R.id.edittext_city, R.id.county_layout, R.id.edittext_street, R.id.street_layout, R.id.edittext_neighborhood, R.id.neighborhood_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_return:
                break;
            case R.id.title_text:
                break;
            case R.id.btn_right:
                break;
            case R.id.text_requesttime:
                break;
            case R.id.text_searchtime:
                break;
            case R.id.text_hechatime:
                break;
            case R.id.RadioA:
                break;
            case R.id.RadioB:
                break;
            case R.id.RadioC:
                break;
            case R.id.mRadioGroup:
                break;
            case R.id.text_province:
                break;
            case R.id.datafill_layout:
                getpullProviceData();
                break;
            case R.id.text_city:
                break;
            case R.id.datafillcity_layout:
                getCitaData();
                break;
            case R.id.edittext_city:
                break;
            case R.id.county_layout:
                break;
            case R.id.edittext_street:
                break;
            case R.id.street_layout:
                break;
            case R.id.edittext_neighborhood:
                break;
            case R.id.neighborhood_layout:
                break;
        }
    }

    public void getpullProviceData() {
        if (popLeft != null && popLeft.isShowing()) {
            popLeft.dismiss();
        } else {
            layoutLeft = getLayoutInflater().inflate(
                    R.layout.pop_menulist, null);
            menulistLeft = (ListView) layoutLeft
                    .findViewById(R.id.menulist);

            myAdapter = new AnswerQuestionAdapter(FillDataActivity.this);
            menulistLeft.setAdapter(myAdapter);


            menulistLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    textProvince.setText(list.get(position));
                    // popupWindow.dismiss();
                    popLeft.dismiss();
                }
            });
            popLeft = new PopupWindow(layoutLeft, datafillLayout.getWidth(),
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

            ColorDrawable cd = new ColorDrawable(-0000);
            popLeft.setBackgroundDrawable(cd);
            popLeft.setAnimationStyle(R.style.PopupAnimation);
            popLeft.update();
            popLeft.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
            popLeft.setTouchable(true); // 设置popupwindow可点击
            popLeft.setOutsideTouchable(true); // 设置popupwindow外部可点击
            popLeft.setFocusable(true); // 获取焦点

            // 设置popupwindow的位置（相对tvLeft的位置）
            //  int topBarHeight = rlTopBar.getBottom();
//                        popLeft.showAsDropDown(tvLeft, 0,
//                                (topBarHeight - tvLeft.getHeight()) / 2);
            popLeft.showAsDropDown(datafillLayout, 0, 0);
            popLeft.setTouchInterceptor(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // 如果点击了popupwindow的外部，popupwindow也会消失
                    if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                        popLeft.dismiss();
                        return true;
                    }
                    return false;
                }
            });

        }
    }


    public void getCitaData() {
        if (popLeft != null && popLeft.isShowing()) {
            popLeft.dismiss();
        } else {
            layoutLeft = getLayoutInflater().inflate(
                    R.layout.pop_menulist, null);
            menulistLeft = (ListView) layoutLeft
                    .findViewById(R.id.menulist);

            myAdapter = new AnswerQuestionAdapter(FillDataActivity.this);
            menulistLeft.setAdapter(myAdapter);


            menulistLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    textCity.setText(list.get(position));
                    // popupWindow.dismiss();
                    popLeft.dismiss();
                }
            });
            popLeft = new PopupWindow(layoutLeft, datafillcityLayout.getWidth(),
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

            ColorDrawable cd = new ColorDrawable(-0000);
            popLeft.setBackgroundDrawable(cd);
            popLeft.setAnimationStyle(R.style.PopupAnimation);
            popLeft.update();
            popLeft.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
            popLeft.setTouchable(true); // 设置popupwindow可点击
            popLeft.setOutsideTouchable(true); // 设置popupwindow外部可点击
            popLeft.setFocusable(true); // 获取焦点

            // 设置popupwindow的位置（相对tvLeft的位置）
            //  int topBarHeight = rlTopBar.getBottom();
//                        popLeft.showAsDropDown(tvLeft, 0,
//                                (topBarHeight - tvLeft.getHeight()) / 2);
            popLeft.showAsDropDown(datafillcityLayout, 0, 0);
            popLeft.setTouchInterceptor(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // 如果点击了popupwindow的外部，popupwindow也会消失
                    if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                        popLeft.dismiss();
                        return true;
                    }
                    return false;
                }
            });

        }
    }


}
