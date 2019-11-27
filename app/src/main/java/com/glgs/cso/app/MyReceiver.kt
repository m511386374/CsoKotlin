package com.glgs.cso.app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils

import com.blankj.utilcode.util.LogUtils
import com.google.gson.Gson

import org.json.JSONException
import org.json.JSONObject

import cn.jpush.android.api.JPushInterface
import com.glgs.cso.mvp.model.entity.JumpMyReceiverBean

/**
 * 自定义接收器
 *
 * 如果不定义这个 Receiver，则：
 * 1) 默认用户会打开主界面
 * 2) 接收不到自定义消息
 */
class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        try {
            val bundle = intent.extras
            LogUtils.d("[MyReceiver] onReceive - " + intent.action + ", extras: " + printBundle(bundle!!))
            if (JPushInterface.ACTION_REGISTRATION_ID == intent.action) {
                val regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID)
                LogUtils.d(TAG, "[MyReceiver] 接收Registration Id : " + regId!!)
                //send the Registration Id to your server...

            } else if (JPushInterface.ACTION_MESSAGE_RECEIVED == intent.action) {
                LogUtils.d(TAG, "[MyReceiver] 接收到推送下来的自定义消息: " + bundle.getString(JPushInterface.EXTRA_MESSAGE)!!)

            } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED == intent.action) {
                LogUtils.d(TAG, "[MyReceiver] 接收到推送下来的通知")
                val notifactionId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID)
                LogUtils.d(TAG, "[MyReceiver] 接收到推送下来的通知的ID: $notifactionId")

            } else if (JPushInterface.ACTION_NOTIFICATION_OPENED == intent.action) {
                LogUtils.d(TAG, "[MyReceiver] 用户点击打开了通知")
                openNotification(context, bundle)

            } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK == intent.action) {
                LogUtils.d(TAG, "[MyReceiver] 用户收到到RICH PUSH CALLBACK: " + bundle.getString(JPushInterface.EXTRA_EXTRA)!!)
                //在这里根据 JPushInterface.EXTRA_EXTRA 的内容处理代码，比如打开新的Activity， 打开一个网页等..

            } else if (JPushInterface.ACTION_CONNECTION_CHANGE == intent.action) {
                val connected = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false)
                LogUtils.w(TAG, "[MyReceiver]" + intent.action + " connected state change to " + connected)
            } else {
                LogUtils.d(TAG, "[MyReceiver] Unhandled intent - " + intent.action!!)
            }
        } catch (e: Exception) {

        }

    }

    private fun openNotification(context: Context, bundle: Bundle) {
        val extras = bundle.getString(JPushInterface.EXTRA_EXTRA)
        var json: JSONObject? = null
        try {
            json = JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA))
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        val msgContent = json!!.optString("msgcontent")
        var jumpMyReceiverBean: JumpMyReceiverBean? = null
        try {
            val jumpMyReceiverGson = Gson()
            jumpMyReceiverBean = jumpMyReceiverGson.fromJson(msgContent, JumpMyReceiverBean::class.java)
        } catch (e: Exception) {
            LogUtils.e("解析失败")
            return
        }

        var paramsBean: JumpMyReceiverBean.ParamsBean? = null
        try {
            val jumpMyReceiverGson = Gson()
            paramsBean = jumpMyReceiverGson.fromJson(jumpMyReceiverBean!!.params, JumpMyReceiverBean.ParamsBean::class.java)
        } catch (e: Exception) {
            LogUtils.e("解析失败")
            return
        }

//        if (jumpMyReceiverBean.modulecode == "0001") {
//            val intent = Intent(context, TaskApplyDetailsActivity::class.java)
//            intent.putExtra(ConstantConfig.KEY_CODE_0, paramsBean!!.taskstatus.toString() + "")
//            intent.putExtra(ConstantConfig.KEY_CODE_1, paramsBean.taskcode)
//            context.startActivity(intent)
//        } else if (jumpMyReceiverBean.modulecode == "0002") {
//            val intent = Intent(context, MyTaskListDetailsActivity::class.java)
//            intent.putExtra(ConstantConfig.KEY_CODE_1, paramsBean!!.taskcode)
//            context.startActivity(intent)
//        } else if (jumpMyReceiverBean.modulecode == "0003") {
//            var type = ""
//            val intent = Intent(context, MyPendingApproveDetailsActivity::class.java)
//            if (paramsBean!!.businesstype == 0) {
//                if (paramsBean.bustatus == 0) {
//                    type = ConstantConfig.KEY_CODE_0
//                } else {
//                    type = ConstantConfig.KEY_CODE_1
//                }
//            } else if (paramsBean.businesstype == 1) {
//                type = ConstantConfig.KEY_CODE_2
//            } else if (paramsBean.businesstype == 2) {
//                type = ConstantConfig.KEY_CODE_1
//            }
//            intent.putExtra(ConstantConfig.INTENT_WHERE, type)
//            intent.putExtra("approvalid", paramsBean.approvalid)
//            intent.putExtra("approvaltype", paramsBean.approvaltype.toString() + "")
//            context.startActivity(intent)
//        }

    }

    companion object {
        private val TAG = "JIGUANG-Example"

        // 打印所有的 intent extra 数据
        private fun printBundle(bundle: Bundle): String {
            val sb = StringBuilder()
            for (key in bundle.keySet()) {
                if (key == JPushInterface.EXTRA_NOTIFICATION_ID) {
                    sb.append("\nkey:" + key + ", value:" + bundle.getInt(key))
                } else if (key == JPushInterface.EXTRA_CONNECTION_CHANGE) {
                    sb.append("\nkey:" + key + ", value:" + bundle.getBoolean(key))
                } else if (key == JPushInterface.EXTRA_EXTRA) {
                    if (TextUtils.isEmpty(bundle.getString(JPushInterface.EXTRA_EXTRA))) {
                        LogUtils.i(TAG, "This message has no Extra data")
                        continue
                    }

                    try {
                        val json = JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA))
                        val it = json.keys()

                        while (it.hasNext()) {
                            val myKey = it.next()
                            sb.append("\nkey:" + key + ", value: [" +
                                    myKey + " - " + json.optString(myKey) + "]")
                        }
                    } catch (e: JSONException) {
                        LogUtils.e(TAG, "Get message extra JSON error!")
                    }

                } else {
                    sb.append("\nkey:" + key + ", value:" + bundle.get(key))
                }
            }
            return sb.toString()
        }
    }

}
