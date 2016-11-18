package com.shunchou.culture.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shunchou.culture.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
public class FragmentIndexAdapter extends  RecyclerView.Adapter<FragmentIndexAdapter.ViewHolder>   {

    private LayoutInflater mInflater;
    private List<Integer> mDatas;

    public FragmentIndexAdapter(Context context, List<Integer> datats)
    {
        mInflater = LayoutInflater.from(context);
        mDatas = datats;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(View arg0)
        {
            super(arg0);
        }

        ImageView mImg;
        TextView mTxt;
    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = mInflater.inflate(R.layout.item_index,
                viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mImg = (ImageView) view.findViewById(R.id.id_index_gallery_item_image);

        return viewHolder;

    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i)
    {
        viewHolder.mImg.setImageResource(mDatas.get(i));
    }
}
