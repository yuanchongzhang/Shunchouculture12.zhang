package com.shunchou.culture.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shunchou.culture.R;
import com.shunchou.culture.activity.AnswerQuestionActivity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/11/18.
 */
public class MsaveAnswerAdapter extends BaseAdapter {

    private Context mContext;


    public String[] img_text = {"1", "2", "3", "4", "5"};
    List<String> listData;
    private LayoutInflater mInflater;

    public MsaveAnswerAdapter(Context mContext, List<String> listData) {
        super();
        this.mContext = mContext;
        this.listData = listData;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        if (view == null) {
//            view = LayoutInflater.from(mContext).inflate(
//                    R.layout.item_saveanswer, viewGroup, false);
//        }
//        TextView tv = BaseViewHolder.get(view, R.id.content_text);
//
//
//        tv.setText(listData.get(i));
//        return view;
        ViewHolder holder = null;
        if (view == null) {
            view = mInflater.inflate(R.layout.item_saveanswer, null);
            holder = new ViewHolder(view);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.contentText.setText(listData.get(i));

        holder.btnStartrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(mContext, AnswerQuestionActivity.class);

                mContext.startActivity(intent);
            }
        });
        return view;

    }


    public class ViewHolder {
        @InjectView(R.id.title_text)
        TextView titleText;
        @InjectView(R.id.content_text)
        TextView contentText;
        @InjectView(R.id.btn_startrequest)
        ImageView btnStartrequest;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
