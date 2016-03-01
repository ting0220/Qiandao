package com.example.zhaoting.qiandao.model.novel;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.zhaoting.qiandao.config.Constants;
import com.example.zhaoting.qiandao.model.OnListener;
import com.example.zhaoting.qiandao.utils.volley.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoting on 16/2/25.
 */
public class NovelModelImpl implements NovelModel {
    public NovelModelImpl() {
    }

    /**
     * @param listener
     * @param limit
     * @param offset
     * @param fields   指定获取小说的属性，用英文;连接
     * @param ending
     * @param orderby  可选desc和asc，默认desc
     * @param sort
     * @param banner_size 需要请求的图片的尺寸
     */
    @Override
    public void getNovel(final OnListener listener, int limit, int offset,String banner_size, String fields, String ending, String orderby, String sort) {
        Map<String, String> map = new HashMap<>();
        map.put("limit", String.valueOf(limit));
        map.put("offset", String.valueOf(offset));
        map.put("fields", fields);
        map.put("ending", ending);
        map.put("orderby", orderby);
        map.put("sort", sort);
        map.put("banner_size",banner_size);

        Volley.get(Constants.getNovelList(), map, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                listener.onSuccess(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.onError();
            }
        }, "");
    }
}
