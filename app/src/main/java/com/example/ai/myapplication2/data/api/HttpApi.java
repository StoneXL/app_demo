package com.example.ai.myapplication2.data.api;



import com.example.ai.myapplication2.entity.AppLogin;
import com.example.ai.myapplication2.entity.Host;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import static com.example.ai.myapplication2.data.api.API.URL_GET_ALL_LOGIN;
import static com.example.ai.myapplication2.data.api.API.ZHUJI_LIEBIAO;


/**
 * Created by hu on 2017/5/16.
 */

public interface HttpApi {
    //主机列表

    @GET(URL_GET_ALL_LOGIN)
    Observable<AppLogin> Login(@QueryMap Map<String, RequestBody> params);
    @GET(ZHUJI_LIEBIAO)
    Observable<Host> getHost(@QueryMap Map<String,RequestBody> params);


}
