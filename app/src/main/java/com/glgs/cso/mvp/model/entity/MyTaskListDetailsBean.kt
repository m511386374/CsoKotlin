package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/24
 * 描    述：
 */
class MyTaskListDetailsBean {

    /**
     * tasktype : 4
     * taskcode : TYRW2019091616480501243
     * topic : 哈哈哈滚滚滚滚
     * content :
     * receivelastdate : 2019-09-16
     * cityname :
     * counts : 55
     * totalcosts : 888
     * finishdate : 2019-09-21
     * status : 5
     * hospitalid : 0
     * doctorid : 0
     * taskclaimid : 4
     * generaltasksummaryList : [{"id":2,"username":"张三","mobileno":"13800138001","createtime":"2019-09-24"},{"id":1,"username":"张三","mobileno":"13800138001","createtime":"2019-09-18"}]
     * noPassSummary : {"reason":"结单审批意见表结单审批意见表结单审批意见表结单审批意见表结单审批意见表","noPassList":[{"id":2,"username":"张三","mobileno":"13800138001","createtime":"2019-09-24"}]}
     * attendancetaskdetailList : [{"id":2,"name":"","mobileNo":"","attendanceDate":"2019-09-19"},{"id":1,"name":"","mobileNo":"","attendanceDate":"2019-09-20"}]
     */

    var tasktype: String? = null
    var taskcode: String? = null
    var topic: String? = null
    var content: String? = null
    var receivelastdate: String? = null
    var cityname: String? = null
    var counts: Int = 0
    var totalcosts: Int = 0
    var finishdate: String? = null
    var status: String? = null
    var hospitalid: Int = 0
    var doctorid: Int = 0
    var taskclaimid: Int = 0
    var hospname: String? = null
    var hospitalAddress: String? = null
    var doctorName: String? = null
    var id: Int = 0
    var attendanceType: String? = null
    var ranges: Any? = null
    var longitude: String? = null
    var latitude: String? = null
    var worklocation: String? = null

    var noPassSummary: NoPassSummaryBean? = null
    var generaltasksummaryList: List<GeneraltasksummaryListBean>? = null
    var attendancetaskdetailList: List<AttendancetaskdetailListBean>? = null

    class NoPassSummaryBean {
        /**
         * reason : 结单审批意见表结单审批意见表结单审批意见表结单审批意见表结单审批意见表
         * noPassList : [{"id":2,"username":"张三","mobileno":"13800138001","createtime":"2019-09-24"}]
         */

        var reason: String? = null
        var noPassList: List<NoPassListBean>? = null

        class NoPassListBean {
            /**
             * id : 2
             * username : 张三
             * mobileno : 13800138001
             * createtime : 2019-09-24
             */

            var id: Int = 0
            var username: String? = null
            var mobileno: String? = null
            var createtime: String? = null
        }
    }

    class GeneraltasksummaryListBean {
        /**
         * id : 2
         * username : 张三
         * mobileno : 13800138001
         * createtime : 2019-09-24
         */

        var id: Int = 0
        var username: String? = null
        var mobileno: String? = null
        var createtime: String? = null
    }

    class AttendancetaskdetailListBean {
        /**
         * id : 2
         * name :
         * mobileNo :
         * attendanceDate : 2019-09-19
         */

        var id: Int = 0
        var name: String? = null
        var mobileNo: String? = null
        var attendanceDate: String? = null
        var generaltasksummaryid: Int = 0
        var attendanceType: String? = null
    }
}
