package com.glgs.cso.mvp.model

import com.blankj.utilcode.util.DeviceUtils
import com.blankj.utilcode.util.TimeUtils
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import java.util.HashMap

/**
 * 作    者：MingMeng
 * 创建日期：2019/2/21
 * 描    述：
 */
open class BaseUiModel(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager) {
    fun putCommonParams(hashMap: HashMap<String, Any>): HashMap<String, Any> {
        val params = HashMap<String, Any>()
        params["skey"] = DeviceUtils.getMacAddress()
        params["v"] = "1.0.0"
        params["timestamp"] = TimeUtils.getNowString()
        params["appType"] = "1"
        params.putAll(hashMap)
        return params
    }

}
