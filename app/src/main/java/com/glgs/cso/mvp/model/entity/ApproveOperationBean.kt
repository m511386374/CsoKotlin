package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/11
 * 描    述：
 */
class ApproveOperationBean {

    /**
     * applopinion : 审批同意你的补卡
     * attachmentUrlList : [{"indexs":0,"imageurl":"xxx/xxx.jpg"},{"indexs":1,"imageurl":"yyy/yyy.jpg"}]
     * approvalid : 5
     * state : 0
     * approvaltype : 3
     * userid : 1
     */

    var applopinion: String? = null
    var approvalid: Int = 0
    var state: String? = null
    var approvaltype: String? = null
    var userid: Int = 0
    var attachmentUrlList: List<AttachmentUrlListBean>? = null

    class AttachmentUrlListBean(
            /**
             * indexs : 0
             * imageurl : xxx/xxx.jpg
             */

            var indexs: Int, var imageurl: String?)
}
