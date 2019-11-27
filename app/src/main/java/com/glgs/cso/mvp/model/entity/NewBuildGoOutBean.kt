package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/10
 * 描    述：
 */
class NewBuildGoOutBean {

    /**
     * approveridList : [{"userid":1,"sort":0},{"userid":2,"sort":1}]
     * stime : 开始时间
     * content : 审批内容
     * times : 3
     * copyidList : 1,22,3
     * originatorname : 审批发起人姓名
     * etime : 结束时间
     * pictureList : [{"indexs":0,"imageurl":"xxx/xxx.jpg"},{"indexs":1,"imageurl":"yyy/yyy.jpg"}]
     */

    var stime: String? = null
    var content: String? = null
    var times: Int = 0
    var copyidList: String? = null
    var originatorname: String? = null
    var etime: String? = null
    var approveridList: List<ApproveridListBean>? = null
    var pictureList: List<PictureListBean>? = null

    class ApproveridListBean {
        /**
         * userid : 1
         * sort : 0
         */

        var userid: Int = 0
        var sort: Int = 0
    }

    class PictureListBean {
        /**
         * indexs : 0
         * imageurl : xxx/xxx.jpg
         */

        var indexs: Int = 0
        var imageurl: String? = null
    }
}
