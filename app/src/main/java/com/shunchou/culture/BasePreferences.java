package com.shunchou.culture;

import com.zcx.helper.app.AppApplication;
import com.zcx.helper.app.AppPreferences;

/**
 * Created by Administrator on 2016/9/6.
 */
public class BasePreferences extends AppPreferences {
    public BasePreferences(AppApplication appApplication) {
        super(appApplication, "zhang");
    }



    private String UID = "uid";

    private String IS_FIRST = "is_first";

    private String IS_GUIDE = "is_guide";

    private String CURRENT_SCHOOL_NAME = "current_school_name", CURRENT_SCHOOL_SID = "current_school_sid";

    private String CURRENT_CITY_NAME = "current_city_name", CURRENT_CIT_CID = "current_cit_cid";

    public void saveUid(String uid){

        putString(uid, uid);

    }

    public String readUid(){

        return getString(UID, "");

    }

    public void saveIsGuide(boolean isGuide){

        putBoolean(IS_GUIDE, isGuide);

    }

    public boolean readIsGuide(){

        return getBoolean(IS_GUIDE, false);

    }

    public void saveIsFirst(boolean isFirst){

        putBoolean(IS_FIRST, isFirst);

    }

    public void readIsFirst(){

        getBoolean(IS_FIRST, false);

    }


}
