package com.alaaeddinalbarghoth.simplelistapp.di

import com.alaaeddinalbarghoth.simplelistapp.BuildConfig
import com.alaaeddinalbarghoth.simplelistapp.data.remote.FeedApiService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // https://api.rss2json.com/v1/api.json?rss_url=https://mars.nasa.gov/rss/blogs.cfm
    // edijs.gorbunovs@testdevlab.com

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        with(OkHttpClient.Builder()) {
            if (BuildConfig.DEBUG) addInterceptor(httpLoggingInterceptor)
            build()
        }

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://localhost/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideFeedAPItRetrofit(retrofit: Retrofit): FeedApiService =
        retrofit.create(FeedApiService::class.java)
}