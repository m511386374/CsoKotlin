package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/23
 * 描    述：
 */
class MyTaskListBean {
    /**
     * pageNum : 1
     * pageSize : 10
     * total : 1
     * pages : 1
     * list : [{"tasktype":"7","taskcode":"TYRW2019091709201901643","topic":"通用测试","receivelastdate":"2019-09-15","cityname":"","counts":36,"totalcosts":603,"finishdate":"2019-09-17","status":"1","hospitalid":0,"doctorid":0,"content":"几点结束","createtime":"2019-09-17 09:20:19"}]
     */

    var pageNum: Int = 0
    var pageSize: Int = 0
    var total: Int = 0
    var pages: Int = 0
    var list: List<ListBean>? = null

    class ListBean {

        var content: String? = null
        var counts: String? = null
        var finishdate: String? = null
        var nums: String? = null
        var platformcode: String? = null
        var receivelastdate: String? = null
        var status: String? = null
        var taskcode: String? = null
        var tasktype: String? = null
        var topic: String? = null
        var totalcosts: Int = 0
    }
}
