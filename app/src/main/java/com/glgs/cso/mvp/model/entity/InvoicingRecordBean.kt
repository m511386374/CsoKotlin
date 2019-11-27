package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/25
 * 描    述：
 */
class InvoicingRecordBean {
    /**
     * pageNum : 1
     * pageSize : 10
     * total : 1
     * pages : 1
     * list : [{"tasktype":"0","taskcode":"XSHY2019092915404694608","topic":"9月29","receivelastdate":"2019-09-29","cityname":"测试","counts":3,"totalcosts":6,"finishdate":"2019-09-29","status":"6","hospitalid":0,"doctorid":0,"content":"","createtime":"2019-09-29 15:40:46","taskclaimid":48,"companyName":""}]
     */

    var pageNum: Int = 0
    var pageSize: Int = 0
    var total: Int = 0
    var pages: Int = 0
    var list: List<ListBean>? = null

    class ListBean {
        /**
         * tasktype : 0
         * taskcode : XSHY2019092915404694608
         * topic : 9月29
         * receivelastdate : 2019-09-29
         * cityname : 测试
         * counts : 3
         * totalcosts : 6.0
         * finishdate : 2019-09-29
         * status : 6
         * hospitalid : 0
         * doctorid : 0
         * content :
         * createtime : 2019-09-29 15:40:46
         * taskclaimid : 48
         * companyName :
         */

        var tasktype: String? = null
        var taskcode: String? = null
        var topic: String? = null
        var receivelastdate: String? = null
        var cityname: String? = null
        var counts: Int = 0
        var totalcosts: Double = 0.toDouble()
        var finishdate: String? = null
        var status: String? = null
        var hospitalid: Int = 0
        var doctorid: Int = 0
        var content: String? = null
        var createtime: String? = null
        var taskclaimid: Int = 0
        var companyName: String? = null
    }

}
