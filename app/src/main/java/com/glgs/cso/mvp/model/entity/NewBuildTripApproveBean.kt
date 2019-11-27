package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/10
 * 描    述：
 */
class NewBuildTripApproveBean {

    /**
     * approveridList : [{"userid":1,"sort":0},{"userid":2,"sort":1}]
     * copyidList : 1,22,3
     * originatorname : 审批发起人姓名
     * evectiontripList : [{"endtime":"结束时间","site":"出差地点","sort":0,"starttime":"开始时间"}]
     * days : 3
     * pictureList : [{"indexs":0,"imageurl":"xxx/xxx.jpg"},{"indexs":1,"imageurl":"yyy/yyy.jpg"}]
     * content : 审批内容
     */

    var copyidList: String? = null
    var originatorname: String? = null
    var days: Int = 0
    var content: String? = null
    var approveridList: List<ApproveridListBean>? = null
    var evectiontripList: List<EvectiontripListBean>? = null
    var pictureList: List<PictureListBean>? = null

    class ApproveridListBean {
        /**
         * userid : 1
         * sort : 0
         */

        var userid: Int = 0
        var sort: Int = 0
    }

    class EvectiontripListBean(
            /**
             * endtime : 结束时间
             * site : 出差地点
             * sort : 0
             * starttime : 开始时间
             */

            var endtime: String?, var site: String?, var sort: Int, var starttime: String?) {

        override fun toString(): String {
            return "EvectiontripListBean{" +
                    "endtime='" + endtime + '\''.toString() +
                    ", site='" + site + '\''.toString() +
                    ", sort=" + sort +
                    ", starttime='" + starttime + '\''.toString() +
                    '}'.toString()
        }
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
