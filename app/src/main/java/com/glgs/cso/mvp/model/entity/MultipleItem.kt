package com.glgs.cso.mvp.model.entity

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * 作    者：MingMeng
 * 创建日期：2019/9/11
 * 描    述：
 */
class MultipleItem(private val itemType: Int, var bean: BuildingApproveBean.ListBean?) : MultiItemEntity {

    override fun getItemType(): Int {
        return itemType
    }

    companion object {
        val TYPE_0 = 0
        val TYPE_1 = 1
        val TYPE_2 = 2
        val TYPE_3 = 3
    }
}

