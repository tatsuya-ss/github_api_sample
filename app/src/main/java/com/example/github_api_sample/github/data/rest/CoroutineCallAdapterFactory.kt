package com.example.github_api_sample.github.data.rest

import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class CoroutineCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        require(returnType is ParameterizedType) { "resource must be parameterized" }

        val responseType = getParameterUpperBound(0, returnType)
        return CoroutineCallAdapter<Any>(responseType)
    }
}