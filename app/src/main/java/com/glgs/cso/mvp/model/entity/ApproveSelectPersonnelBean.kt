package com.glgs.cso.mvp.model.entity

import java.io.Serializable

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/2
 * 描    述：
 */
class ApproveSelectPersonnelBean : Serializable {

    /**
     * pageNum : 1
     * pageSize : 10
     * total : 4
     * pages : 1
     * list : [{"id":1,"platformcode":"CSO0001","platformName":"","companyName":"","shortName":"","companycode":"GLGL","username":"黄大","showname":"黄大","mobileno":"13310562814","certificateno":"110","level":"1","mail":"","headimg":"","token":""},{"id":3,"platformcode":"CSO0001","platformName":"","companyName":"","shortName":"","companycode":"GLDJK","username":"张三","showname":"张总","mobileno":"13800138001","certificateno":"440304200012126895","level":"0","mail":"13500135001","headimg":"images/heading/iwfiao.png","token":""},{"id":4,"platformcode":"CSO0001","platformName":"","companyName":"","shortName":"","companycode":"GLDJK","username":"明蒙","showname":"明蒙","mobileno":"18588244141","certificateno":"440404040004444444","level":"1","mail":"18588244141","headimg":"images/heading/iwfiao.png","token":""},{"id":5,"platformcode":"CSO0001","platformName":"","companyName":"","shortName":"","companycode":"GLDJK","username":"刘超正","showname":"刘超正","mobileno":"17608426049","certificateno":"444444444444444444","level":"1","mail":"18588244141","headimg":"images/heading/iwfiao.png","token":""}]
     */

    var pageNum: Int = 0
    var pageSize: Int = 0
    var total: Int = 0
    var pages: Int = 0
    var list: List<ListBean>? = null

    class ListBean : Serializable {
        /**
         * id : 1
         * platformcode : CSO0001
         * platformName :
         * companyName :
         * shortName :
         * companycode : GLGL
         * username : 黄大
         * showname : 黄大
         * mobileno : 13310562814
         * certificateno : 110
         * level : 1
         * mail :
         * headimg :
         * token :
         */

        var id: Int = 0
        var platformcode: String? = null
        var platformName: String? = null
        var companyName: String? = null
        var shortName: String? = null
        var companycode: String? = null
        var username: String? = null
        var showname: String? = null
        var mobileno: String? = null
        var certificateno: String? = null
        var level: String? = null
        var mail: String? = null
        var headimg: String? = null
        var token: String? = null
        override fun equals(obj: Any?): Boolean {
            if (obj is ListBean) {
                val u = obj as ListBean?
                return this.id == u!!.id
            }
            return super.equals(obj)
        }

    }
}
