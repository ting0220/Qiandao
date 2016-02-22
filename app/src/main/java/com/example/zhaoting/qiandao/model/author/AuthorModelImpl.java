package com.example.zhaoting.qiandao.model.author;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.zhaoting.qiandao.config.Constants;
import com.example.zhaoting.qiandao.model.OnListener;
import com.example.zhaoting.qiandao.utils.volley.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoting on 16/1/5.
 */
public class AuthorModelImpl implements AuthorModel {


    public AuthorModelImpl() {

    }

    @Override
    public void getAuthor(final OnListener listener, int limit, int offset) {
        Map<String, String> map = new HashMap<>();
        map.put("limit", String.valueOf(limit));
        map.put("offset", String.valueOf(offset));
        map.put("fields", "avatar;signature;avatar");
        map.put("avatar_size", "[\"120_120\"]");
        map.put("type_of_verification", "outside");
        Volley.get(Constants.getOutSideList(), map, new Response.Listener<String>() {
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
