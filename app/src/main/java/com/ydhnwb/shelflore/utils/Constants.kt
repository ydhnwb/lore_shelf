package com.ydhnwb.shelflore.utils

import com.ydhnwb.shelflore.webservices.APIService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Constants {
    companion object {
        const val TOKEN_BOOKS = "AIzaSyBxh4Q26dGTt6cUoKY9L1FaGQq0qHxBQuk"
        const val API_ENDPOINT = "https://www.googleapis.com/books/v1/"
    }
}

class APIClient{
    companion object {
        private var retrofit: Retrofit? = null
        private var okHttpClient = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build()

        fun APIService(): APIService = getClient().create(APIService::class.java)

        private fun getClient(): Retrofit {
            return if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(Constants.API_ENDPOINT).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
                retrofit!!
            } else {
                retrofit!!
            }
        }
    }
}