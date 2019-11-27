package com.glgs.cso.app.FastJsonUtil

import com.alibaba.fastjson.JSON

import java.io.IOException
import java.lang.reflect.Type

import okhttp3.ResponseBody
import okio.BufferedSource
import okio.Okio
import retrofit2.Converter

/**
 * 作    者：MingMeng
 * 创建日期：2019/11/2
 * 描    述：
 */
class FastJsonResponseBodyConverter<T>(private val type: Type) : Converter<ResponseBody, T> {

    /*
     * 转换方法
     */
    @Throws(IOException::class)
    override fun convert(value: ResponseBody): T? {
        val bufferedSource = Okio.buffer(value.source())
        val tempStr = bufferedSource.readUtf8()
        bufferedSource.close()
        return JSON.parseObject<T>(tempStr, type)

    }

}
