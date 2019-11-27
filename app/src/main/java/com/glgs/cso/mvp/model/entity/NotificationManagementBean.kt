package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/8/14
 * 描    述：
 */
class NotificationManagementBean {

    /**
     * pageNum : 1
     * pageSize : 10
     * total : 7
     * pages : 1
     * list : [{"id":4,"platformid":1,"platformcode":"CSO0001","topic":"星期二","createtime":"2019-09-07","operator":1,"content":"你好"},{"id":5,"platformid":1,"platformcode":"CSO0001","topic":"32135去51","createtime":"2019-09-09","operator":5,"content":"4125213512"},{"id":6,"platformid":1,"platformcode":"CSO0001","topic":"一直以为是因为自己喜欢自己想太复杂啦\u2026\u2026这些东西也可以了\u2026\u2026不过这样也好了不少麻烦","createtime":"2019-09-09","operator":5,"content":"发滚滚滚滚滚 v 滚滚滚滚红尘，不想去\u2026\u2026在线"},{"id":7,"platformid":1,"platformcode":"CSO0001","topic":"死死死死","createtime":"2019-09-09","operator":5,"content":"杀姐姐就是今生今世"},{"id":8,"platformid":1,"platformcode":"CSO0001","topic":"傻里傻气的","createtime":"2019-09-09","operator":1,"content":"俺看看扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩扩"},{"id":9,"platformid":1,"platformcode":"CSO0001","topic":"阿达","createtime":"2019-09-09","operator":1,"content":"啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊"},{"id":10,"platformid":1,"platformcode":"CSO0001","topic":"啊","createtime":"2019-09-09","operator":1,"content":"啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊斤斤计较军军军军"}]
     */

    var pageNum: Int = 0
    var pageSize: Int = 0
    var total: Int = 0
    var pages: Int = 0
    var list: List<ListBean>? = null

    class ListBean {
        /**
         * id : 4
         * platformid : 1
         * platformcode : CSO0001
         * topic : 星期二
         * createtime : 2019-09-07
         * operator : 1
         * content : 你好
         */

        var id: Int = 0
        var platformid: Int = 0
        var platformcode: String? = null
        var topic: String? = null
        var createtime: String? = null
        var operator: Int = 0
        var content: String? = null
    }
}
