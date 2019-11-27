package com.glgs.cso.app.utils

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Color
import android.util.Log
import com.blankj.utilcode.util.SPUtils
import com.google.gson.Gson
import java.util.ArrayList
import java.util.Arrays
import cn.carbs.android.avatarimageview.library.AvatarImageView
import com.blankj.utilcode.util.EncryptUtils
import com.glgs.cso.mvp.model.entity.AppBean
import com.glgs.cso.app.api.Api
import com.glgs.cso.app.config.ConstantConfig

class Utils {
    val appBean: AppBean?
        get() {
            val dateBean = Gson().fromJson(SPUtils.getInstance().getString(ConstantConfig.USER_APP_DATE_BEAN, ""), AppBean::class.java)
            if (dateBean != null) {
                try {
                    return dateBean
                } catch (e: Exception) {
                    return null
                }

            }
            return null
        }

    fun getMd5Parameters(map: HashMap<String, Any>): HashMap<String, Any> {
        val secret = Api.SECRET
        val mapSet = map.keys
        val keyList = ArrayList<String>()
        val itor = mapSet.iterator()//获取key的Iterator便利
        while (itor.hasNext()) {//存在下一个值
            val key = itor.next()//当前key值
            keyList.add(key)
        }
        val data = keyList.toTypedArray()
        Arrays.sort(data)
        val stringBuilder = StringBuilder()
        stringBuilder.append(secret)
        for (i in data.indices) {
            if (map[data[i]] != null && (map[data[i]].toString() + "").trim { it <= ' ' }.length > 0) {
                stringBuilder.append(data[i]).append((map[data[i]].toString() + "").trim { it <= ' ' })
            }
        }
        stringBuilder.append(secret)
        val strTemp = EncryptUtils.encryptMD5ToString(stringBuilder.toString())
        val sign = EncryptUtils.encryptMD5ToString(strTemp + map["timestamp"])
        map["sign"] = sign
        return map
    }

    fun setTextImage(image: AvatarImageView, name: String, context: Context) {
        var name = name
        if (name.length > 2) {
            name = name.substring(name.length - 2, name.length)
            image.setTextAndColor(name, Color.parseColor(ConstantConfig.appBean!!.color))
        } else {
            image.setTextAndColor(name, Color.parseColor(ConstantConfig.appBean!!.color))
        }

    }
    companion object {
        private var utils: Utils? = null

        val instance: Utils
            get() {
                if (utils == null) {
                    utils = Utils()
                }
                return utils!!
            }

        fun <B> modelA2B(modelA: Any, bClass: Class<B>): B? {
            try {
                val gson = Gson()
                val gsonA = gson.toJson(modelA)
                val instanceB = gson.fromJson(gsonA, bClass)

                Log.d("TAG", "modelA2B A=" + modelA.javaClass + " B=" + bClass + " 转换后=" + instanceB)
                return instanceB
            } catch (e: Exception) {
                Log.e("TAG", "modelA2B Exception=" + modelA.javaClass + " " + bClass + " " + e.message)
                return null
            }

        }
    }
}
