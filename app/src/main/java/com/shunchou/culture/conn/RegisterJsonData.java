package com.shunchou.culture.conn;

import com.zcx.helper.http.AsyCallBack;
import com.zcx.helper.http.note.HttpInlet;

import org.json.JSONObject;

/**
 * Created by Administrator on 2016/11/18.
 */
@HttpInlet(Conn.REGISTER)
public class RegisterJsonData extends ShunchouAsyPost<String>{

    public String username, password, email;

    public RegisterJsonData(String username,String password,String email,AsyCallBack<String> asyCallBack) {
        super(asyCallBack);

        this.username=username;
        this.password=password;
        this.email=email;

    }
    @Override
    public String parser(JSONObject object) {

//        if(object.optString("tips").equals("1")){
//
//            TOAST = "注册成功";
//
//            return object.optString("Uid");
//
//        }else if(object.optString("tips").equals("0")){
//
//            TOAST = "此用户已存在";
//
//            return null;
//
//        }

        return TOAST = object.optString("tips");

    }


}
