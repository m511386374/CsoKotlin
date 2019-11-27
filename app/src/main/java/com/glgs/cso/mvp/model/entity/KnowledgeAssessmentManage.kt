package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/24
 * 描    述：
 */
class KnowledgeAssessmentManage {

    /**
     * pageNum : 1
     * pageSize : 10
     * total : 1
     * pages : 1
     * list : [{"intro":"考题","introduce":"考个100分","starttime":"","isread":"1","id":9}]
     */

    var pageNum: Int = 0
    var pageSize: Int = 0
    var total: Int = 0
    var pages: Int = 0
    var list: List<ListBean>? = null

    class ListBean {
        /**
         * intro : 考题
         * introduce : 考个100分
         * starttime :
         * isread : 1
         * id : 9
         */

        var intro: String? = null
        var introduce: String? = null
        var starttime: String? = null
        var isread: String? = null
        var id: Int = 0

    }
}
