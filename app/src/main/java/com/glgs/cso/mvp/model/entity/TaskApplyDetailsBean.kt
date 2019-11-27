package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/23
 * 描    述：
 */
class TaskApplyDetailsBean {
    /**
     * tasktype : 0
     * taskcode : XSHY2019091210315782439
     * topic : 呐喊
     * receivelastdate : 2019-09-12
     * cityname : 还是
     * counts : 646
     * totalcosts : 6767676
     * finishdate : 2019-09-12
     * status : 1
     * hospitalid :
     * doctorid :
     * content : 你在哪上就睡觉
     * createtime : 2019-09-12 10:31:57
     * taskclaimList : []
     */

    var tasktype: String? = null
    var taskcode: String? = null
    var topic: String? = null
    var receivelastdate: String? = null
    var cityname: String? = null
    var counts: Int = 0
    var totalcosts: Int = 0
    var finishdate: String? = null
    var status: String? = null
    var hospitalid: Int = 0
    var doctorid: Int = 0
    var content: String? = null
    var createtime: String? = null
    var hospitalName: String? = null
    var doctorName: String? = null
    var bidCompanyNum: String? = null

    var taskclaimList: List<Companyinformation>? = null

    fun getHospitalname(): String? {
        return hospitalName
    }

    fun setHospitalname(hospitalname: String) {
        this.hospitalName = hospitalname
    }

    class Companyinformation {

        var name: String? = null
        var contacts: String? = null
        var contacttel: String? = null
    }
}
