package com.shunchou.culture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.shunchou.culture.R;
import com.zcx.helper.glide.GlideLoader;
import com.zcx.helper.pager.CarouselChild;
import com.zcx.helper.scale.ScaleScreenHelperFactory;

/**
 * Created by Administrator on 2016/9/5.
 */
public class ADView extends CarouselChild<String> {

    public ADView(Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    @Override
    protected boolean isPlay() {

        return true;

    }

    @Override
    protected View getView(String s) {

        ImageView imageView = new ImageView(getContext());

        GlideLoader.getInstance().get(getContext(), s, imageView, GlideLoader.TYPE_IMAGE_FUZZY);

        return imageView;

    }

    @Override
    protected View indicatorLayout(LinearLayout indicatorLayout) {

        int temp = ScaleScreenHelperFactory.getInstance().getWidthHeight(15);

        indicatorLayout.setGravity(Gravity.CENTER);

        indicatorLayout.setPadding(temp, temp, temp, temp);

        return indicatorLayout;

    }

    @Override
    protected View indicator(View indicator) {

        indicator = ScaleScreenHelperFactory.getInstance().loadViewWidthHeight(indicator, 18, 18);

        return ScaleScreenHelperFactory.getInstance().loadViewMargin(indicator, 10, 0, 0, 0);

    }

    @Override
    protected int indicatorOff() {

        return R.drawable.shape_radius_solid_blue_blue;

    }

    @Override
    protected int indicatorOn() {

        return R.drawable.shape_radius_solid_blue_white;

    }

}
