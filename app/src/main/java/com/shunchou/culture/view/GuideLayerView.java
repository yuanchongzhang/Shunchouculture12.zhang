package com.shunchou.culture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.zcx.helper.pager.GuideLayer;
import com.zcx.helper.scale.ScaleScreenHelperFactory;

/**
 * Created by Administrator on 2016/9/5.
 */
public class GuideLayerView extends GuideLayer {

    public GuideLayerView(Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    @Override
    protected boolean slideEnd() {

        return true;

    }

    @Override
    protected View getView(View view) {

        return ScaleScreenHelperFactory.getInstance().loadView((ViewGroup) view);

    }

}
