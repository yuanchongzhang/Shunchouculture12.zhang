package com.shunchou.culture.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shunchou.culture.R;
import com.shunchou.culture.viewholder.BaseViewHolder;

/**
 * Created by Administrator on 2016/11/16.
 */
public class AnswerQuestionAdapter extends BaseAdapter {
    private Context mContext;
    public String[] img_text = { "1", "2", "3", "4", "5" };
    public AnswerQuestionAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return img_text.length;
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
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(
                    R.layout.adapter_list, viewGroup, false);
        }
        TextView tv = BaseViewHolder.get(view, R.id.tv_num);
        ImageView iv = BaseViewHolder.get(view, R.id.iv_item);
       // iv.setBackgroundResource(imgs[position]);

        tv.setText(img_text[i]);
        return view;
    }

}
