package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/18
 * 描    述：
 */
class TestBean {

    /**
     * result : 0
     * code : 0000
     * message :
     * data : {}
     */

    var result: Int = 0
    var code: String? = null
    var message: String? = null
    var data: DataBean? = null

    class DataBean

    override fun toString(): String {
        return "TestBean{" +
                "result=" + result +
                ", code='" + code + '\''.toString() +
                ", message='" + message + '\''.toString() +
                ", data=" + data +
                '}'.toString()
    }
}
