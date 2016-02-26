package com.example.zhaoting.qiandao.model.novel;

import com.example.zhaoting.qiandao.model.OnListener;

/**
 * Created by zhaoting on 16/2/25.
 */
public interface NovelModel {
    void getNovel(OnListener listener, int limit, int offset,String fields,String ending,String orderby,String sort);
}
