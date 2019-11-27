package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/10/15
 * 描    述：
 */
class JumpMyReceiverBean {

    /**
     * modulecode : 0003
     * apptype : 0
     * id : 392
     * params : {"approvalid":175,"approvaltype":0}
     */

    var modulecode: String? = null
    var apptype: String? = null
    var id: String? = null
    var params: String? = null

    class ParamsBean {
        /**
         * approvalid : 175
         * approvaltype : 0
         */

        var approvalid: Int = 0
        var approvaltype: Int = 0
        var businesstype: Int = 0
        var bustatus: Int = 0
        var taskcode: String? = null
        var taskstatus: Int = 0
    }
}
