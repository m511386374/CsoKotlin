package com.glgs.cso.mvp.model.api.service

import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.glgs.cso.mvp.model.api.NetMethodApi
import com.glgs.cso.mvp.model.entity.BaseResponse
import com.glgs.cso.mvp.model.entity.CommonBean
import com.glgs.cso.mvp.model.entity.TaskApplyDetailsBean

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/4
 * 描    述：
 */
interface TaskApplyDetilService {

    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHOD_TASKAPPLYDETAIL)
    fun TaskApplyDetil(@FieldMap map: Map<String, Any>): Observable<BaseResponse<TaskApplyDetailsBean>>

    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHOD_TASKAPPLY)
    fun taskApply(@FieldMap map: Map<String, Any>): Observable<BaseResponse<CommonBean>>

}
