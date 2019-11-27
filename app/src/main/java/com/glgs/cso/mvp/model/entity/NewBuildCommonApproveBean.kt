package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/9
 * 描    述：
 */
class NewBuildCommonApproveBean {

    /**
     * approveridList : [{"userid":1,"sort":0},{"userid":2,"sort":1}]
     * copyidList : 1,22,3
     * originatorname : 审批发起人姓名
     * pictureList : [{"indexs":0,"imageurl":"tongyong/shenpi.jpg"},{"indexs":1,"imageurl":"shenpi/tongyong.jpg"}]
     * content : 审批内容
     */

    var copyidList: String? = null
    var originatorname: String? = null
    var content: String? = null
    var subject: String? = null
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
         * imageurl : tongyong/shenpi.jpg
         */

        var indexs: Int = 0
        var imageurl: String? = null
    }
}
