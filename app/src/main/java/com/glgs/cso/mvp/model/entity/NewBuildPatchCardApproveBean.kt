package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/10
 * 描    述：
 */
class NewBuildPatchCardApproveBean {

    /**
     * approveridList : [{"userid":1,"sort":0},{"userid":2,"sort":1}]
     * attetype : 1
     * menddate : 补卡时间
     * content : 审批内容
     * copyidList : 1,22,3
     * originatorname : 审批发起人姓名
     * pictureList : [{"indexs":0,"imageurl":"xxx/xxx.jpg"},{"indexs":1,"imageurl":"yyy/yyy.jpg"}]
     */

    var attetype: String? = null
    var menddate: String? = null
    var content: String? = null
    var copyidList: String? = null
    var originatorname: String? = null
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
