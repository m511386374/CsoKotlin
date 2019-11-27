package com.glgs.cso.mvp.model.entity

/**
 * 作    者：MingMeng
 * 创建日期：2019/8/21
 * 描    述：
 */
class TravelDetailsBean(var starttime: String?, var endtime: String?, var address: String?) {

    override fun toString(): String {
        return "TravelDetailsBean{" +
                "starttime='" + starttime + '\''.toString() +
                ", endtime='" + endtime + '\''.toString() +
                ", address='" + address + '\''.toString() +
                '}'.toString()
    }
}
