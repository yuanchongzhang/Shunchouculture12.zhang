package com.shunchou.culture.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.shunchou.culture.R;
import com.shunchou.culture.conn.LoginJsonData;
import com.zcx.helper.activity.AppActivity;
import com.zcx.helper.http.AsyCallBack;
import com.zcx.helper.util.UtilMD5;
import com.zcx.helper.util.UtilToast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/14.
 */
public class LoginActivity extends AppActivity {
    @InjectView(R.id.edittext_email)
    EditText edittextEmail;
    @InjectView(R.id.edittext_pwd)
    EditText edittextPwd;
    @InjectView(R.id.login_btn)
    TextView loginBtn;
    @InjectView(R.id.register_btn)
    TextView registerBtn;
    @InjectView(R.id.forget_pwd)
    TextView forgetPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.edittext_email, R.id.edittext_pwd, R.id.login_btn, R.id.register_btn, R.id.forget_pwd})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edittext_email:
                break;
            case R.id.edittext_pwd:
                break;
            case R.id.login_btn:
                String username=edittextEmail.getText().toString();
                String password=edittextPwd.getText().toString();

                if (username.equals("")) {

                    UtilToast.show(this, "请输入用户名");

                    return;

                } else if (password.equals("")) {

                    UtilToast.show(this, "密码不能为空");

                    return;

                }else {

                    String str = UtilMD5.MD5Encode(UtilMD5.MD5Encode(password, "UTF-8"), "UTF-8");

                    new LoginJsonData(username, str, new AsyCallBack<String>() {

                        @Override
                        public void onSuccess(String toast, int type, String s) throws Exception {

//                            BaseApplication.basePreferences.saveUid(s);

                            finish();

                        }

                        @Override
                        public void onEnd(String toast, int type) throws Exception {

                            UtilToast.show(LoginActivity.this, toast);

                        }

                    }).execute(this);
                }





                break;
            case R.id.register_btn:
                startActivity(new Intent(this,RegisterActivity.class));


                break;
            case R.id.forget_pwd:
                startActivity(new Intent(this,RetrievePwdActivity.class));

                break;
        }
    }
}
