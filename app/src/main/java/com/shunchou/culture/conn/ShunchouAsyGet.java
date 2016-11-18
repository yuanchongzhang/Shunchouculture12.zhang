package com.shunchou.culture.conn;

import com.zcx.helper.http.AsyCallBack;
import com.zcx.helper.http.AsyGet;
import com.zcx.helper.http.note.HttpServer;

/**
 * Created by Administrator on 2015/8/11 0011.
 */
@HttpServer(Conn.SERVICE)
public abstract class ShunchouAsyGet<T> extends AsyGet<T> {

    public ShunchouAsyGet(AsyCallBack<T> asyCallBack) {

        super(asyCallBack);

    }

}
