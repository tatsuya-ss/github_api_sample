package com.example.github_api_sample.github.data.rest

import android.util.Log
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

class CoroutineCallAdapter<T>(
    private val responseType: Type
) : CallAdapter<T, Call<T>> {
    override fun responseType(): Type {
        return responseType
    }

    // callをデリゲートするTのインスタンスを返します。
    override fun adapt(call: Call<T>): Call<T> {
        return HandlerHttpExceptionCall(responseType, call)
    }
}

private class HandlerHttpExceptionCall<T>(
    private val responseType: Type,
    val delegate: Call<T>
) : Call<T> by delegate {
    override fun clone(): Call<T> {
        return HandlerHttpExceptionCall(responseType, delegate.clone())
    }

    // 非同期を行うメソッド
    override fun enqueue(callback: Callback<T>) {
        delegate.enqueue(
            object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    when {
                        response.isSuccessful -> {
                            Log.d("Tatsuyað", "onResponse: ${response}")
                            if (response.code() == 201) {
                                // 201の時にやりたい処理
                            }
                            if (response.code() == 204) {
                                // 204の時にやりたい処理
                            }
                            callback.onResponse(call, response)
                        }
                    }
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    return callback.onFailure(call, t)
                }
            }
        )
    }
}