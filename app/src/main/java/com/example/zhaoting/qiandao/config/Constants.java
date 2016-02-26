package com.example.zhaoting.qiandao.config;

/**
 * Created by zhaoting on 15/11/10.
 * Use for 写网络请求的静态地址
 */
public class Constants {
    //headers
    public static final String APP_KEY="2015042402";
    public static final String APP_SECRET="4d162e4d7740196701ea";

    //base url
    public static final  String BASE_URL="http://api.tmtpost.com/v1";

    //base posts
    public static final String POSTS_BASE_URL=BASE_URL+"/posts";
    //获取24小时最新文章数
    public static final String getLatestPostsNum(){
        return POSTS_BASE_URL+"/latest/count";
    }
    //获取话题列表
    public static final String getAuctionList(){
        return BASE_URL+"/auctions/list";
    }
    //获取外部作者列表
    public static final String getOutSideList(){
        return BASE_URL+"/users/list/verified";
    }
    //获取小说列表
    public static final String getNovelList(){return BASE_URL+"/novels/list";}
}
