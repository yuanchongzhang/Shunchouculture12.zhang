package com.shunchou.culture.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.shunchou.culture.R;
import com.zcx.helper.activity.AppPictureActivity;
import com.zcx.helper.bound.BoundView;
import com.zcx.helper.glide.GlideLoader;
import com.zcx.helper.util.UtilSDCard;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/15.
 */
public class TestEditInfoActivity extends AppPictureActivity {


    @InjectView(R.id.picture_image)
    ImageView pictureImage;
    @BoundView(R.id.picture_image)
    private ImageView picture_image;

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_picture_1);
        ButterKnife.inject(this);

        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_STORAGE,
                    1
            );
        }


        picture_image = (ImageView) findViewById(R.id.picture_image);
    }

    /*  public void onClick(View v) {

          new AlertDialog.Builder(this).setTitle("图片").setNegativeButton("拍照", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {

                  startCamera(null);

              }
          }).setPositiveButton("相册", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {

                  startAlbum(null);

              }
          }).show();

      }
  */
    @Override
    protected void resultPhotoPath(ImageView imageView, String s) {

        GlideLoader.getInstance().get(this, s, picture_image);
        Log.d(s, "---------------");

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String getCameraAbsolutePath() {

        return UtilSDCard.getSDCardPath() + "yc/";

    }

//    @Override
//    protected AppCrop getCrop() {
//
//        return new AppCrop().setCrop(true);
//
//    }




    @OnClick(R.id.picture_image)
    public void onClick() {

        new AlertDialog.Builder(this).setTitle("图片").setNegativeButton("拍照", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                startCamera(null);

            }
        }).setPositiveButton("相册", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                startAlbum(null);

            }
        }).show();

    }
}
