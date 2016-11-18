package com.shunchou.culture.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.shunchou.culture.R;
import com.shunchou.culture.code.Code;
import com.shunchou.culture.conn.RegisterJsonData;
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
public class RegisterActivity extends AppActivity {
    public static final String TAG = RegisterActivity.class.getName();
    @InjectView(R.id.edittext_email)
    EditText edittextEmail;
    @InjectView(R.id.edittext_pwd)
    EditText edittextPwd;
    @InjectView(R.id.edittext_quedingpwd)
    EditText edittextQuedingpwd;
    @InjectView(R.id.edittext_inputemail)
    EditText edittextInputemail;
    @InjectView(R.id.edittext_inputcode)
    EditText edittextInputcode;
    @InjectView(R.id.iv_showCode)
    ImageView ivShowCode;
    @InjectView(R.id.register_btn)
    Button registerBtn;

    //产生的验证码
    private String realCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.inject(this);
        getCodeData();
    }

    public void getCodeData() {
        ivShowCode.setImageBitmap(Code.getInstance().createBitmap());
        realCode = Code.getInstance().getCode().toLowerCase();

    }


    @OnClick({R.id.edittext_email, R.id.edittext_pwd, R.id.edittext_quedingpwd, R.id.edittext_inputemail, R.id.edittext_inputcode, R.id.iv_showCode, R.id.register_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edittext_email:
                break;
            case R.id.edittext_pwd:
                break;
            case R.id.edittext_quedingpwd:
                break;
            case R.id.edittext_inputemail:
                break;
            case R.id.edittext_inputcode:
                break;
            case R.id.iv_showCode:
                ivShowCode.setImageBitmap(Code.getInstance().createBitmap());
                realCode = Code.getInstance().getCode().toLowerCase();
                Log.v(TAG, "realCode" + realCode);

                break;

            case R.id.register_btn:

                String username = edittextEmail.getText().toString();

                String password = edittextPwd.getText().toString();

                String repassword = edittextQuedingpwd.getText().toString();

                String email = edittextInputemail.getText().toString();

                String phoneCode = edittextInputcode.getText().toString().toLowerCase();


                if (username.equals("")) {

                    UtilToast.show(this, "请输入用户名");

                    return;

                } else if (password.equals("")) {

                    UtilToast.show(this, "密码不能为空");

                    return;

                } else if (repassword.equals("")) {

                    UtilToast.show(this, "请重新输入密码");

                    return;

                } else if (email.equals("")) {

                    UtilToast.show(this, "邮箱不能为空");

                    return;

                } else if (phoneCode.equals("")) {
                    UtilToast.show(this, "验证码不能为空");
                } else if (!password.equals(repassword)) {
                    UtilToast.show(this, "两次输入密码不一致");
                } else {

                    String str = UtilMD5.MD5Encode(UtilMD5.MD5Encode(password, "UTF-8"), "UTF-8");

                    new RegisterJsonData(username, str, email, new AsyCallBack<String>() {

                        @Override
                        public void onSuccess(String toast, int type, String s) throws Exception {

//                            BaseApplication.basePreferences.saveUid(s);

                            finish();

                        }

                        @Override
                        public void onEnd(String toast, int type) throws Exception {

                            UtilToast.show(RegisterActivity.this, toast);

                        }

                    }).execute(this);
                }

                break;
        }
    }

}
