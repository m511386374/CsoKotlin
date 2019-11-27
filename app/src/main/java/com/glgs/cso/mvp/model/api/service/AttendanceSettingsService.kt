package com.glgs.cso.mvp.model.api.service

import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.glgs.cso.mvp.model.api.NetMethodApi
import com.glgs.cso.mvp.model.entity.AttendanceSettingsBean
import com.glgs.cso.mvp.model.entity.BaseResponse
import com.glgs.cso.mvp.model.entity.CommonBean

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/4
 * 描    述：
 */
interface AttendanceSettingsService {

    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHODCREATEATTENDANCE)
    fun createAttendance(@FieldMap map: Map<String, Any>): Observable<BaseResponse<CommonBean>>

    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHODEDITATTENDANCE)
    fun editAttendance(@FieldMap map: Map<String, Any>): Observable<BaseResponse<CommonBean>>

    @POST(NetMethodApi.NET_METHODGETATTENDANCERULE)
    fun getAttendanceRule(@FieldMap map: Map<String, Any>): Observable<BaseResponse<AttendanceSettingsBean>>
}
