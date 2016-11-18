package com.shunchou.culture.util;

/**
 * Created by Administrator on 2015/9/4 0004.
 */
public class UtilRegular {

    private UtilRegular(){}

    public static boolean mobile(String string){

        return string.matches("[1][358]\\d{9}");

    }

}
