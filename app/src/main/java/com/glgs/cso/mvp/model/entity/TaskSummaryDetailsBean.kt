package com.glgs.cso.mvp.model.entity

import java.io.Serializable

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/26
 * 描    述：
 */
class TaskSummaryDetailsBean : Serializable {
    /**
     * content : 呵呵呵呵
     * urls : ["http://120.76.244.27:8995/image/other/3d82a67978014cd9b7a521cea9f87b54.jpg,http://120.76.244.27:8995/image/other/2967a226a3f4490697832b0f222d7043.jpg,http://120.76.244.27:8995/image/other/b753b897c9224a669da3e9e39ef0e537.jpg,"]
     * attendanceTaskDetail : {"logintime":"","loginaddress":"","loginlongitude":"","loginlatitude":"","loginStatus":"","logouttime":"","logouaddress":"","logoutlongitude":"","logoutlatitude":"","logoutStatus":"","times":"","attendanceDate":"","hospitalAddress":""}
     */

    var content: String? = null
    var attendanceTaskDetail: AttendanceTaskDetailBean? = null
    var urls: List<String>? = null

    class AttendanceTaskDetailBean : Serializable {
        /**
         * logintime :
         * loginaddress :
         * loginlongitude :
         * loginlatitude :
         * loginStatus :
         * logouttime :
         * logouaddress :
         * logoutlongitude :
         * logoutlatitude :
         * logoutStatus :
         * times :
         * attendanceDate :
         * hospitalAddress :
         */

        var logintime: String? = null
        var loginaddress: String? = null
        var loginlongitude: String? = null
        var loginlatitude: String? = null
        var loginStatus: String? = null
        var logouttime: String? = null
        var logouaddress: String? = null
        var logoutlongitude: String? = null
        var logoutlatitude: String? = null
        var logoutStatus: String? = null
        var times: Any? = null
        var attendanceDate: String? = null
        var hospitalAddress: String? = null
    }

}
