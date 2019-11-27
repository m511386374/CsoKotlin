package com.glgs.cso.app

import android.app.Activity
import android.app.Application
import android.os.Bundle

import timber.log.Timber

/**
 * ================================================
 * 展示 [Application.ActivityLifecycleCallbacks] 的用法
 *
 *
 * Created by MVPArmsTemplate on 11/06/2019 14:42
 * [Contact me](mailto:jess.yan.effort@gmail.com)
 * [Follow me](https://github.com/JessYanCoding)
 * ================================================
 */
class ActivityLifecycleCallbacksImpl : Application.ActivityLifecycleCallbacks {

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Timber.i(activity.toString() + " - onActivityCreated")
    }

    override fun onActivityStarted(activity: Activity) {
        Timber.i(activity.toString() + " - onActivityStarted")

    }

    override fun onActivityResumed(activity: Activity) {
        Timber.i(activity.toString() + " - onActivityResumed")
    }

    override fun onActivityPaused(activity: Activity) {
        Timber.i(activity.toString() + " - onActivityPaused")
    }

    override fun onActivityStopped(activity: Activity) {
        Timber.i(activity.toString() + " - onActivityStopped")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Timber.i(activity.toString() + " - onActivitySaveInstanceState")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Timber.i(activity.toString() + " - onActivityDestroyed")
        //横竖屏切换或配置改变时, Activity 会被重新创建实例, 但 Bundle 中的基础数据会被保存下来,移除该数据是为了保证重新创建的实例可以正常工作
        activity.intent.removeExtra("isInitToolbar")
    }
}
