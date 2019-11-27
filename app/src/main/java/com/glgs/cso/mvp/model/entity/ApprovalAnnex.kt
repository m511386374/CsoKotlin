package com.glgs.cso.mvp.model.entity

import com.yzs.imageshowpickerview.ImageShowPickerBean

/**
 * 作    者：MingMeng
 * 创建日期：2019/8/20
 * 描    述：
 */
class ApprovalAnnex : ImageShowPickerBean {

    private val url: String

    private val resId: Int

    constructor(url: String, resId: Int) {
        this.url = url
        this.resId = resId
    }

    constructor(resId: Int, url: String) {
        this.resId = resId
        this.url = url
    }


    override fun setImageShowPickerUrl(): String {
        return url
    }

    override fun setImageShowPickerDelRes(): Int {
        return resId
    }
}
