package ru.easycode.zerotoheroandroidtdd

import android.util.Log

interface Repository {

    suspend fun load() : SimpleResponse

    class Base(private val service: SimpleService, private val url: String) : Repository {
        override suspend fun load(): SimpleResponse {
            Log.d("wut", "repo used url - $url")
            return service.fetch(url)
        }
    }
}
