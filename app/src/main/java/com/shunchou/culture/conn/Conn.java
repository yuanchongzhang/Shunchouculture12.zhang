package com.shunchou.culture.conn;

/**
 * Created by Administrator on 2015/8/24 0024.
 */
public interface Conn {

    String SERVICE = "http://vhost108.zihaistar.com/";

    String REGISTER = "api/reg.php?act=reg";

    String LOGIN = "api/login.php?act=login";

    String MODIFYPASSWORD = "resetPwd";
    String RESETPASSWORD = "pwdModify";
    String CHANGEHEAD ="resetData";

    String CHANGE_REALNAME="cnnameModify";

    String REQUEST_API="question";

}
