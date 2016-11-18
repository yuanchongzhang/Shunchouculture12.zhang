package com.shunchou.culture.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.shunchou.culture.R;
import com.shunchou.culture.viewholder.BaseViewHolder;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/11/17.
 */
public class SaveAnswerAdapter extends BaseAdapter {
    private Context mContext;


    public String[] img_text = {"1", "2", "3", "4", "5"};
    List<String> listData;
    private LayoutInflater mInflater;

    public SaveAnswerAdapter(Context mContext, List<String> listData) {
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
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(
                    R.layout.item_saveanswer, viewGroup, false);
        }
        TextView tv = BaseViewHolder.get(view, R.id.content_text);

        Button btn_startrequest = BaseViewHolder.get(view, R.id.btn_startrequest);

        tv.setText(listData.get(i));
        return view;

/*
        if(view == null){

        //    view = BoundViewHelper.boundView(viewHolder = new ViewHolder(), LayoutInflater.from(mContext).inflate(R.layout.item_saveanswer, null));
            viewHolder=new ViewHolder;

            view =mInflater.inflate(R.layout.item_saveanswer,viewGroup);
            view.setTag(viewHolder);

        }else{

            viewHolder = (ViewHolder) view.getTag();

        }*/


    }


    public class ViewHolder {
        @InjectView(R.id.title_text)
        TextView titleText;
        @InjectView(R.id.content_text)
        TextView contentText;
        @InjectView(R.id.btn_startrequest)
        Button btnStartrequest;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
