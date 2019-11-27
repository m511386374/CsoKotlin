package com.glgs.cso.mvp.model.api.service

import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.glgs.cso.mvp.model.api.NetMethodApi
import com.glgs.cso.mvp.model.entity.BaseResponse
import com.glgs.cso.mvp.model.entity.CommonBean

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/4
 * 描    述：
 */
interface ForgetPasswordService {

    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHOD_VERIFICATION_PHONE)
    fun verificationPhone(@FieldMap map: Map<String, Any>): Observable<BaseResponse<CommonBean>>

    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHOD_GET_VERIFICATIONCODE)
    fun getVerificationCode(@FieldMap map: Map<String, Any>): Observable<BaseResponse<CommonBean>>

    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHOD_FINDVERIFICATIONCODE)
    fun findVerificationCode(@FieldMap map: Map<String, Any>): Observable<BaseResponse<CommonBean>>
}
