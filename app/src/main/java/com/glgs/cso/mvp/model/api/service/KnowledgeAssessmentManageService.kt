/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.glgs.cso.mvp.model.api.service

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.glgs.cso.mvp.model.api.NetMethodApi
import com.glgs.cso.mvp.model.entity.BaseResponse
import com.glgs.cso.mvp.model.entity.KnowledgeAssessmentManage

/**
 * ================================================
 * 展示 [Retrofit.create] 中需要传入的 ApiService 的使用方式
 * 存放关于用户的一些 API
 *
 *
 * Created by JessYan on 08/05/2016 12:05
 * [Contact me](mailto:jess.yan.effort@gmail.com)
 * [Follow me](https://github.com/JessYanCoding)
 * ================================================
 */
interface KnowledgeAssessmentManageService {
    @FormUrlEncoded
    @POST(NetMethodApi.NET_METHOD_KNOWLEDGEASSESSMENTLIST)
    fun getKnowledgeAssessmentManage(@FieldMap map: Map<String, Any>): Observable<BaseResponse<KnowledgeAssessmentManage>>

}
