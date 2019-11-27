package com.glgs.cso.mvp.model.api.service

import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.glgs.cso.mvp.model.api.NetMethodApi
import com.glgs.cso.mvp.model.entity.BaseResponse
import com.glgs.cso.mvp.model.entity.CommonBean
import com.glgs.cso.mvp.model.entity.MakeKnowledgeAssessmentBean

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/4
 * 描    述：
 */
interface MakeKnowledgeAssessmentService {

    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHOD_MAKEKNOWLEDGEASSESSMENT)
    fun getMakeKnowledgeAssessmentlList(@FieldMap map: Map<String, Any>): Observable<BaseResponse<List<MakeKnowledgeAssessmentBean>>>

    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHOD_SUBMITANSWERS)
    fun submitAnswers(@FieldMap map: Map<String, Any>): Observable<BaseResponse<CommonBean>>

}
