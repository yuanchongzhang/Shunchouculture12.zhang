package com.shunchou.culture.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shunchou.culture.R;
import com.shunchou.culture.dialog.ActionSheetDialog;
import com.zcx.helper.activity.AppPictureActivity;
import com.zcx.helper.entity.AppCrop;
import com.zcx.helper.glide.GlideLoader;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/14.
 */
public class EditInfoActivity extends AppPictureActivity implements View.OnClickListener {
    @InjectView(R.id.btn_return)
    ImageView btnReturn;
    @InjectView(R.id.title_text)
    TextView titleText;
    @InjectView(R.id.btn_right)
    ImageView btnRight;
    @InjectView(R.id.title_layout)
    RelativeLayout titleLayout;
    @InjectView(R.id.view_lines)
    View viewLines;
    @InjectView(R.id.name_text)
    TextView nameText;
    @InjectView(R.id.name_layout)
    RelativeLayout nameLayout;
    @InjectView(R.id.count_text)
    TextView countText;
    @InjectView(R.id.count_layout)
    RelativeLayout countLayout;
    @InjectView(R.id.edit_info_img)
    ImageView editInfoImg;
    @InjectView(R.id.edit_info_text)
    TextView editInfoText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editinfo);
        ButterKnife.inject(this);
    }


    @OnClick({R.id.btn_return, R.id.title_text, R.id.btn_right, R.id.edit_info_img, R.id.edit_info_text, R.id.title_layout, R.id.view_lines, R.id.name_text, R.id.name_layout, R.id.count_text, R.id.count_layout
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_return:
                finish();
                break;
            case R.id.title_text:
                break;
            case R.id.btn_right:
                break;
            case R.id.edit_info_img:
                showDialog();
                break;

            case R.id.edit_info_text:


                break;
            case R.id.title_layout:
                break;
            case R.id.view_lines:
                break;
            case R.id.name_text:
                break;
            case R.id.name_layout:
                startActivity(new Intent(EditInfoActivity.this, TestEditInfoActivity.class));

                break;
            case R.id.count_text:
                break;
            case R.id.count_layout:
                break;

        }

    }


    public void showDialog(){
        new ActionSheetDialog(context)
                .builder()
                .setCancelable(false)
                .setCanceledOnTouchOutside(false)
                .addSheetItem("拍照", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                startCamera(null);
                            }
                        })

                .addSheetItem("从相册选择", ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                startAlbum(null);
                            }
                        })
                .show();
    }


    @Override
    protected void resultPhotoPath(ImageView imageView, String s) {
        GlideLoader.getInstance().get(this, s, editInfoImg);
    }


    @Override
    protected AppCrop getCrop() {

        return new AppCrop().setCrop(true);

    }
}
