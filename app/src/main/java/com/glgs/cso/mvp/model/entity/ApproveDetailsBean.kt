package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/9
 * 描    述：
 */
class ApproveDetailsBean {

    /**
     * approve : {"id":12,"originatorid":1,"originatorname":"黄大","originatorUrl":"images/heading/iwfiao2.png","approveType":"","leavetype":"","days":3,"starttime":"","endtime":"","menddate":"","status":"1","createtime":"2019-09-09 17:58","evList":[{"site":"出差地点","starttime":"","endtime":"","sort":0}]}
     * approvalpeopleList : [{"username":"黄大","headimg":"images/heading/iwfiao2.png","sort":"","state":"6","opinion":"","approvedate":""},{"username":"黄大","headimg":"images/heading/iwfiao2.png","sort":0,"state":"1","opinion":"审批同意你的补卡","attachmentUrlList":[{"attachmenttype":"1","imageurl":"xxx/xxx.jpg","indexs":0},{"attachmenttype":"1","imageurl":"yyy/yyy.jpg","indexs":1},{"attachmenttype":"1","imageurl":"xxx/xxx.jpg","indexs":0},{"attachmenttype":"1","imageurl":"yyy/yyy.jpg","indexs":1}],"approvedate":"2019-09-10 09:46"},{"username":"叶秋","headimg":"","sort":1,"state":"0","opinion":"","attachmentUrlList":[],"approvedate":""}]
     * attachmentUrlList : [{"attachmenttype":"0","imageurl":"xxx/xxx.jpg","indexs":0},{"attachmenttype":"0","imageurl":"yyy/yyy.jpg","indexs":1}]
     * copyUsersList : [{"copyname":"黄大","copyimgUrl":"images/heading/iwfiao2.png"},{"copyname":"张三","copyimgUrl":"images/heading/iwfiao.png"}]
     */

    var approve: ApproveBean? = null
    var approvalpeopleList: List<ApprovalpeopleListBean>? = null
    var attachmentUrlList: List<AttachmentUrlListBeanX>? = null
    var copyUsersList: List<CopyUsersListBean>? = null

    class ApproveBean {
        /**
         * id : 12
         * originatorid : 1
         * originatorname : 黄大
         * originatorUrl : images/heading/iwfiao2.png
         * approveType :
         * leavetype :
         * days : 3
         * starttime :
         * endtime :
         * menddate :
         * status : 1
         * createtime : 2019-09-09 17:58
         * evList : [{"site":"出差地点","starttime":"","endtime":"","sort":0}]
         */

        var id: Int = 0
        var originatorid: Int = 0
        var originatorname: String? = null
        var originatorUrl: String? = null
        var approveType: String? = null
        var leavetype: String? = null
        var days: Int = 0
        var starttime: String? = null
        var endtime: String? = null
        var menddate: String? = null
        var status: String? = null
        var createtime: String? = null
        var content: String? = null
        var attetype: String? = null

        var evList: List<EvListBean>? = null

        class EvListBean {
            /**
             * site : 出差地点
             * starttime :
             * endtime :
             * sort : 0
             */

            var site: String? = null
            var starttime: String? = null
            var endtime: String? = null
            var sort: Int = 0
        }
    }

    class ApprovalpeopleListBean {
        /**
         * username : 黄大
         * headimg : images/heading/iwfiao2.png
         * sort :
         * state : 6
         * opinion :
         * approvedate :
         * attachmentUrlList : [{"attachmenttype":"1","imageurl":"xxx/xxx.jpg","indexs":0},{"attachmenttype":"1","imageurl":"yyy/yyy.jpg","indexs":1},{"attachmenttype":"1","imageurl":"xxx/xxx.jpg","indexs":0},{"attachmenttype":"1","imageurl":"yyy/yyy.jpg","indexs":1}]
         */

        var username: String? = null
        var headimg: String? = null
        var sort: String? = null
        var state: String? = null
        var opinion: String? = null
        var approvedate: String? = null
        var attachmentUrlList: List<AttachmentUrlListBean>? = null

        class AttachmentUrlListBean {
            /**
             * attachmenttype : 1
             * imageurl : xxx/xxx.jpg
             * indexs : 0
             */

            var attachmenttype: String? = null
            var imageurl: String? = null
            var indexs: Int = 0
        }
    }

    class AttachmentUrlListBeanX {
        /**
         * attachmenttype : 0
         * imageurl : xxx/xxx.jpg
         * indexs : 0
         */

        var attachmenttype: String? = null
        var imageurl: String? = null
        var indexs: Int = 0
    }

    class CopyUsersListBean {
        /**
         * copyname : 黄大
         * copyimgUrl : images/heading/iwfiao2.png
         */

        var copyname: String? = null
        var copyimgUrl: String? = null
    }
}
