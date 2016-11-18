package com.shunchou.culture.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

/**
 * Created by Administrator on 2016/11/14.
 */
public class AnswerQuestionActivity extends AppActivity implements View.OnClickListener {

    @InjectView(R.id.btn_return)
    ImageView btnReturn;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.btn_right)
    ImageView btnRight;
    @InjectView(R.id.first_text)
    TextView firstText;

    @InjectView(R.id.iv_select)
    ImageView ivSelect;
    @InjectView(R.id.xiala_layout)
    LinearLayout xialaLayout;
    @InjectView(R.id.text_ticount)
    TextView textTicount;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.RadioA)
    RadioButton RadioA;
    @InjectView(R.id.RadioB)
    RadioButton RadioB;
    @InjectView(R.id.RadioC)
    RadioButton RadioC;
    @InjectView(R.id.RadioD)
    RadioButton RadioD;
    @InjectView(R.id.tv_result)
    TextView tvResult;
    @InjectView(R.id.mRadioGroup)
    RadioGroup mRadioGroup;
    @InjectView(R.id.first_next_btn)
    Button firstNextBtn;
    @InjectView(R.id.panduan_firstlayout)
    LinearLayout panduanFirstlayout;
    @InjectView(R.id.btn_up)
    Button btnUp;
    @InjectView(R.id.btn_down)
    Button btnDown;
    @InjectView(R.id.btn_up_lastbtn)
    Button btnUpLastbtn;
    @InjectView(R.id.request_btn)
    Button requestBtn;
    @InjectView(R.id.save_questionbtn)
    Button saveQuestionbtn;
    @InjectView(R.id.tv_left)
    TextView tvLeft;

    private ArrayList<String> list = new ArrayList<>();

    private AnswerQuestionAdapter myAdapter;


    private PopupWindow popLeft;

    private View layoutLeft;

    // 左中右三个ListView控件（弹出窗口里）
    private ListView menulistLeft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answerquestion);
        ButterKnife.inject(this);

        initData();
    }

    private void initData() {
        //tvLeft = (TextView) this.findViewById(R.id.tv_left);
        //tvLeft.setOnClickListener(myListener);
        for (int i = 0; i < 15; i++) {
            list.add(1 + i + "");
        }
        xialaLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_return:
                break;
            case R.id.title_text:
                break;
            case R.id.btn_right:
                break;
            case R.id.first_text:
                break;

            case R.id.iv_select:
                break;
            case R.id.xiala_layout:
                getpullData();
                break;
            case R.id.text_ticount:
                break;
            case R.id.tv_title:
                break;
            case R.id.RadioA:
                break;
            case R.id.RadioB:
                break;
            case R.id.RadioC:
                break;
            case R.id.RadioD:
                break;
            case R.id.tv_result:
                break;
            case R.id.mRadioGroup:
                break;
            case R.id.first_next_btn:
                break;
            case R.id.panduan_firstlayout:
                break;
            case R.id.btn_up:
                break;
            case R.id.btn_down:
                break;
            case R.id.btn_up_lastbtn:
                break;
            case R.id.request_btn:
                break;
            case R.id.save_questionbtn:
                break;
        }


    }


    public void getpullData() {
        if (popLeft != null && popLeft.isShowing()) {
            popLeft.dismiss();
        } else {
            layoutLeft = getLayoutInflater().inflate(
                    R.layout.pop_menulist, null);
            menulistLeft = (ListView) layoutLeft
                    .findViewById(R.id.menulist);

            myAdapter = new AnswerQuestionAdapter(AnswerQuestionActivity.this);
            menulistLeft.setAdapter(myAdapter);


            menulistLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    tvLeft.setText(list.get(position));
                    // popupWindow.dismiss();
                    popLeft.dismiss();
                }
            });
            popLeft = new PopupWindow(layoutLeft, xialaLayout.getWidth(),
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
            popLeft.showAsDropDown(xialaLayout, 0, 0);
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
