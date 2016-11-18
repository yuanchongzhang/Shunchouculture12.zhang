package com.shunchou.culture;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

import com.shunchou.culture.db.BaseDB;
import com.zcx.helper.app.AppApplication;
import com.zcx.helper.app.AppInit;
import com.zcx.helper.glide.GlideLoader;
import com.zcx.helper.http.Http;

/**
 * name 项目名称
 * log 是否打印
 * initialize 是否网络初始化
 * width 适配宽度
 * scale 适配字体倍数
 */
@AppInit(name = "shunchouculture", log = true, initialize = false, width =  720, scale = 1f)
public class BaseApplication extends AppApplication {

    public static BasePreferences basePreferences;

    public static BaseDB baseDB;

    @Override
    public void onCreate() {

        super.onCreate();

        //网络请求等待框，可自定义
        Http.getInstance().setOnStartEndCreateDialog(new Http.OnStartEndCreateDialog() {

            @Override
            public Dialog onCreate(Context context) {

                return new ProgressDialog(context);

            }

            @Override
            public void show(Dialog dialog) {

                dialog.show();

            }

            @Override
            public void dismiss(Dialog dialog) {

                dialog.dismiss();

            }

        });

        //初始化GLide图片加载框架
        GlideLoader.getInstance().init(R.id.def_id, R.mipmap.ic_launcher);

        //初始化自定首选项
        basePreferences = new BasePreferences(this);

        //初始化自定义数据库
        baseDB = new BaseDB(this);








    }

}
