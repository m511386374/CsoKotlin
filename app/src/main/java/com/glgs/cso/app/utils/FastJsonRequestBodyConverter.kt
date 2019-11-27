package com.glgs.cso.app.FastJsonUtil

import com.alibaba.fastjson.JSON

import java.io.IOException

import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Converter

/**
 * 作    者：MingMeng
 * 创建日期：2019/11/2
 * 描    述：
 */
class FastJsonRequestBodyConverter<T> : Converter<T, RequestBody> {

    @Throws(IOException::class)
    override fun convert(value: T): RequestBody {
        return RequestBody.create(MEDIA_TYPE, JSON.toJSONBytes(value))
    }

    companion object {
        private val MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8")
    }
}
