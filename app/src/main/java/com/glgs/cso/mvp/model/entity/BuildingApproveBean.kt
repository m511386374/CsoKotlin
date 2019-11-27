package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/8/19
 * 描    述：
 */
class BuildingApproveBean {
    var pageNum: Int = 0
    var pageSize: Int = 0
    var total: Int = 0
    var pages: Int = 0
    var list: List<ListBean>? = null

    class ListBean {
        /**
         * businesstype : 0
         * approvaltype : 0
         * leavetype :
         * approvalid : 20
         * userid : 3
         * name : 张三
         * headimg : images/heading/iwfiao.png
         * subject : 关于张三的请假审批
         * applcreatetime : 2019-09-04 20:43:35
         * endtime : 2019-10-11 00:00
         * starttime : 2019-10-08 00:00
         * status : 1
         */

        var businesstype: String? = null
        var approvaltype: String? = null
        var leavetype: String? = null
        var approvalid: Int = 0
        var userid: Int = 0
        var name: String? = null
        var headimg: String? = null
        var subject: String? = null
        var applcreatetime: String? = null
        var endtime: String? = null
        var starttime: String? = null
        var status: String? = null

    }
}
