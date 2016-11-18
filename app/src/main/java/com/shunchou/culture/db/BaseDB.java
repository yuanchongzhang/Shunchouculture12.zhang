package com.shunchou.culture.db;

import com.zcx.helper.app.AppApplication;
import com.zcx.helper.db.SQLite;
import com.zcx.helper.db.SQLiteInit;
import com.zcx.helper.db.SQLiteTable;

/**
 * Created by Administrator on 2016/9/7.
 */
@SQLiteInit(name = "super", version = 2)
public class BaseDB extends SQLite {

    public static BaseTable baseTable = new BaseTable();

    public BaseDB(AppApplication appApplication) {

        super(appApplication);

    }

    @Override
    protected SQLiteTable[] createSQLiteTables() {

        return new SQLiteTable[]{baseTable};

    }

}
