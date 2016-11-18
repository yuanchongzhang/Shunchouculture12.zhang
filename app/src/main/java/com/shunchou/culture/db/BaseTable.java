package com.shunchou.culture.db;

import com.zcx.helper.db.SQLiteTable;
import com.zcx.helper.db.SQLiteTableInit;
import com.zcx.helper.entity.AppEntity;

/**
 * Created by Administrator on 2016/9/7.
 */
@SQLiteTableInit(name = "base", insert_filter = "name", delete_field = "name", query_field = "name", update_field = "name")
public class BaseTable extends SQLiteTable<BaseTable.BaseA> {

    public static class BaseA extends AppEntity {

        public String name, sex, age;

    }

}
