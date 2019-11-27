package com.glgs.cso.mvp.model.api.service

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.glgs.cso.mvp.model.api.NetMethodApi
import com.glgs.cso.mvp.model.entity.ApproveDetailsBean
import com.glgs.cso.mvp.model.entity.BaseResponse
import com.glgs.cso.mvp.model.entity.CommonBean

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/4
 * 描    述：
 */
interface ApproveDetailsService {

    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHOD_APPROVEDETAILS)
    fun getApproveDetails(@FieldMap map: Map<String, Any>): Observable<BaseResponse<ApproveDetailsBean>>

    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHOD_REVOKEAPPROVE)
    fun revokeApprove(@FieldMap map: Map<String, Any>): Observable<BaseResponse<CommonBean>>
}
