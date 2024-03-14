package com.example.wakuwakuapp.interceptor

import android.content.Context
import com.example.wakuwakuapp.jwt.TokenManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = TokenManager.getToken(context)

        val request = chain.request().newBuilder()
            .addHeader("Authorization", "$token")
            .build()

        return chain.proceed(request)
    }
}