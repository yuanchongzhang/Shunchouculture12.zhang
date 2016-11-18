package com.shunchou.culture.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.shunchou.culture.R;
import com.shunchou.culture.adapter.MsaveAnswerAdapter;
import com.zcx.helper.activity.AppActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/15.
 */
public class SaveAnswerActivity extends AppActivity {

    private static final String[] strs = new String[]{
            "first", "second", "third", "fourth", "fifth"
    };


    @InjectView(R.id.btn_return)
    ImageView btnReturn;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.btn_right)
    ImageView btnRight;

    ListView saveanswerList;

    MsaveAnswerAdapter saveAnswerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saveanswer);
        saveanswerList = (ListView) findViewById(R.id.saveanswer_list);

        saveAnswerAdapter = new MsaveAnswerAdapter(this, getData());
        saveanswerList.setAdapter(saveAnswerAdapter);

    }

    @OnClick({R.id.btn_return, R.id.title_text, R.id.btn_right, R.id.saveanswer_list})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_return:
                finish();
                break;
            case R.id.title_text:
                titleText.setText("保存的试题");
                break;
            case R.id.btn_right:
                break;
            case R.id.saveanswer_list:
                break;
        }
    }


    private List<String> getData() {

        List<String> data = new ArrayList<String>();
        data.add("Apple");
        data.add("Banana");
        data.add("Grape");
        data.add("Watermelon");
        data.add("Apple");
        data.add("Banana");
        data.add("Grape");
        data.add("Watermelon");
        return data;
    }


}
