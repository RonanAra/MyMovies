package com.example.mymovies.data.network.interceptor

import com.example.mymovies.BuildConfig
import com.example.mymovies.utils.Constants.API_TOKEN_KEY
import com.example.mymovies.utils.Constants.QUERY_PARAM_LANGUAGE_KEY
import com.example.mymovies.utils.Constants.QUERY_PARAM_LANGUAGE_VALUE
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestUrl = request.url

        val newUrl = requestUrl.newBuilder()
            .addQueryParameter(API_TOKEN_KEY, BuildConfig.API_KEY)
            .addQueryParameter(QUERY_PARAM_LANGUAGE_KEY, QUERY_PARAM_LANGUAGE_VALUE)
            .build()

        return chain.proceed(
            request.newBuilder()
                .url(newUrl)
                .build()
        )
    }
}