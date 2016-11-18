package com.shunchou.culture.conn;

import com.zcx.helper.http.AsyCallBack;
import com.zcx.helper.http.note.HttpInlet;

import org.json.JSONObject;

/**
 * Created by Administrator on 2016/11/18.
 */

@HttpInlet(Conn.LOGIN)
public class LoginJsonData extends ShunchouAsyPost<String> {


    public String username, password;

    public LoginJsonData(String username, String password, AsyCallBack<String> asyCallBack) {
        super(asyCallBack);
        this.username = username;
        this.password = password;
    }


    @Override
    public String parser(JSONObject object) {

        if (object.optString("status").equals("1")) {
            TOAST = "登陆";
            return object.optString("uid");

        } else {
            TOAST = "登陆失败";
        }

        return null;
    }


}
