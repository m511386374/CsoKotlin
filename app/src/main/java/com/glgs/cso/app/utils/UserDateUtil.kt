package com.glgs.cso.app.utils

import com.blankj.utilcode.util.SPUtils
import com.glgs.cso.app.config.ConstantConfig
import com.glgs.cso.mvp.model.entity.LoginBean
import com.google.gson.Gson


class UserDateUtil {

    val loginBean: LoginBean?
        get() {
            val dateBean = Gson().fromJson(SPUtils.getInstance().getString(ConstantConfig.USER_LOGIN_DATE_BEAN, ""), LoginBean::class.java)
            if (dateBean != null) {
                try {
                    return dateBean
                } catch (e: Exception) {
                    return null
                }

            }
            return null
        }

    companion object {
        private var utils: UserDateUtil? = null

        val instance: UserDateUtil
            get() {
                if (utils == null) {
                    utils = UserDateUtil()
                }
                return utils!!
            }
    }

}
