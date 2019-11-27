package com.glgs.cso.mvp.model.entity

import java.io.Serializable

class BaseResponse<T> : Serializable {

    var data: T? = null
    var message: String? = null
    var code: String? = null
    var result: Int = 0

    val isSuccess: Boolean?
        get() = if (result == 0 && code == "0000") {
            true
        } else
            false

    override fun toString(): String {
        return "BaseResponse{" +
                "data=" + data +
                ", message='" + message + '\''.toString() +
                ", code='" + code + '\''.toString() +
                ", result=" + result +
                '}'.toString()
    }

    companion object {

        private const val serialVersionUID = 5213230387175987834L
    }
    /**
     * result : 0
     * code : 0000
     * message : 0000
     * data : {"platformcode":"CSO0001","platformName":"谷粒医疗","companyName":"谷粒大健康管理有限公司","shortName":"","companycode":"GLDJK","username":"张三","showname":"张总","mobileno":"13800138001","certificateno":"440304200012126895","level":"0","mail":"13500135001","headimg":"images/heading/iwfiao.png","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb21wYW55Y29kZSI6IkdMREpLIiwiaXNzIjoiZ29vZHljb21fY3NvX3VzZXIiLCJpZCI6IjMiLCJtb2JpbGVubyI6IjEzODAwMTM4MDAxIiwicGxhdGZvcm1pZCI6IjEiLCJleHAiOjE1Njc2NTQzNTUsInBsYXRmb3JtY29kZSI6IkNTTzAwMDEiLCJjb21wbWF5aWQiOiIxIn0.heqDX5YdtjmG6-ut1x44uy7BqOOSG2iPrKVwJnxmfOQ"}
     */


}