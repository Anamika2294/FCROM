package com.fcrom.library.Content;

import android.util.Log;

import com.fcrom.library.Constant.API_urls;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by anamika.chavan on 10-11-2017.
 */

abstract class NetworkingAbstract {

    Interceptor interceptor=new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original =chain.request();
            Request.Builder request = original.newBuilder();
            request.addHeader("X-OAPI-Auth-Header", API_urls.headerTokenn);
            request.addHeader("X-OAPI-Node-Id", API_urls.headerNodeID);
            return chain.proceed(request.build());
        }
    };

    HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();




    Retrofit adapter = new Retrofit.Builder()
            .baseUrl(API_urls.BaseURL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    Retrofit adapter_custome = new Retrofit.Builder()
            .baseUrl(API_urls.baseUrl)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    private OkHttpClient getOkHttpClient() {

        // Install the all-trusting trust manager
        //  final SSLContext sslContext;
        try {

            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
            HttpLoggingInterceptor loggingInceptor = new HttpLoggingInterceptor();
            loggingInceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient.addInterceptor(loggingInceptor);
            okHttpClient.addInterceptor(interceptor);
            okHttpClient.connectTimeout(getResponseTimeOut(), TimeUnit.SECONDS);
            okHttpClient.readTimeout(getResponseTimeOut(), TimeUnit.SECONDS);
            okHttpClient.writeTimeout(getResponseTimeOut(), TimeUnit.SECONDS);
            okHttpClient.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });

//            okHttpClient.setConnectTimeout(getResponseTimeOut(), TimeUnit.SECONDS);
//            okHttpClient.setReadTimeout(getResponseTimeOut(), TimeUnit.SECONDS);
//            okHttpClient.setWriteTimeout(getResponseTimeOut(), TimeUnit.SECONDS);
//            okHttpClient.setHostnameVerifier(new HostnameVerifier() {
//                @Override
//                public boolean verify(String hostname, SSLSession session) {
//                    return true;
//                }
//            });


            return okHttpClient.build();
            //neeraja - Generic exceptions should never be thrown
        } catch (Exception e) {
            Log.e("NetworkAbstract", e.getMessage(), e);
            return null;
        }
    }

    private int getResponseTimeOut() {

        return 150;
    }
}
