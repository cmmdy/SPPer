package com.drop.spper.mvp.model.api.service;


import com.drop.spper.mvp.model.entity.HotMovieBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by 夏夜晚凤 on 2017/5/3.
 */

public interface DouBanService {
    String APP_HOST = "https://api.douban.com/";

    /**
     * 豆瓣热映电影
     */
    @GET("v2/movie/in_theaters")
    rx.Observable<HotMovieBean> getHotMovie();

//    @GET("v2/movie/subject/{id}")
//    rx.Observable<MovieDetailBean> getMovieDetail(@Path("id") String id);

    /**
     * 豆瓣Top250
     * @param start 从多少开始，如从0开始
     * @param count 一次请求的数目，如10条，最多100
     */
    @GET("https://api.douban.com/v2/movie/top250")
    rx.Observable<HotMovieBean> getMovieTop250(@Query("start") int start, @Query("count") int count);
}
