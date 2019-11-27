package com.glgs.cso.mvp.model.api.service

import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.glgs.cso.mvp.model.api.NetMethodApi
import com.glgs.cso.mvp.model.entity.BaseResponse
import com.glgs.cso.mvp.model.entity.CommonBean
import com.glgs.cso.mvp.model.entity.NotificationManagementBean

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/4
 * 描    述：
 */
interface NotificationManagementService {

    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHOD_NOTIFICATIONMANAGEMENTLIST)
    fun notificationManagementList(@FieldMap map: Map<String, Any>): Observable<BaseResponse<NotificationManagementBean>>

    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHOD_DELETENOTIFICATIONMANAGEMENT)
    fun deleteNotificationManagement(@FieldMap map: Map<String, Any>): Observable<BaseResponse<CommonBean>>


}
