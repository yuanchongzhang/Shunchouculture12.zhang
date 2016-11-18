package com.shunchou.culture.conn;

import com.zcx.helper.http.AsyCallBack;
import com.zcx.helper.http.AsyPost;
import com.zcx.helper.http.note.HttpServer;

/**
 * Created by Administrator on 2015/8/11 0011.
 */
@HttpServer(Conn.SERVICE)
public abstract class ShunchouAsyPost<T> extends AsyPost<T> {

    public ShunchouAsyPost(AsyCallBack<T> asyCallBack) {

        super(asyCallBack);

    }

}
