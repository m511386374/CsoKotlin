package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/8/22
 * 描    述：
 */
class InvoiceManagementBean {

    /**
     * pageNum : 1
     * pageSize : 10
     * total : 3
     * pages : 1
     * list : [{"id":3,"subject":"服务费","makecompany":"谷粒大健康管理有限公司","amount":4000,"createtime":"2019-09-18","status":"已开票"},{"id":2,"subject":"服务费","makecompany":"谷粒大健康管理有限公司","amount":3000,"createtime":"2019-09-18","status":"已开票"},{"id":1,"subject":"服务费","makecompany":"谷粒大健康管理有限公司","amount":2000,"createtime":"2019-09-18","status":"已开票"}]
     */

    var pageNum: Int = 0
    var pageSize: Int = 0
    var total: Int = 0
    var pages: Int = 0
    var list: List<ListBean>? = null

    class ListBean {
        /**
         * id : 3
         * subject : 服务费
         * makecompany : 谷粒大健康管理有限公司
         * amount : 4000
         * createtime : 2019-09-18
         * status : 已开票
         */

        var id: Int = 0
        var subject: String? = null
        var makecompany: String? = null
        var amount: Int = 0
        var createtime: String? = null
        var status: String? = null
    }

}
