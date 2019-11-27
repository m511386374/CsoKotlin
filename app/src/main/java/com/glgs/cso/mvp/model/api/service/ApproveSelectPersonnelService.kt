package com.glgs.cso.mvp.model.api.service

import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.glgs.cso.mvp.model.api.NetMethodApi
import com.glgs.cso.mvp.model.entity.ApproveSelectPersonnelBean
import com.glgs.cso.mvp.model.entity.BaseResponse

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/4
 * 描    述：
 */
interface ApproveSelectPersonnelService {

    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHOD_APPROVEPERSONNEL)
    fun getApprovePersonnelList(@FieldMap map: Map<String, Any>): Observable<BaseResponse<ApproveSelectPersonnelBean>>

}
