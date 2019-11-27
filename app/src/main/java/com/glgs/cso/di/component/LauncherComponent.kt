package com.glgs.cso.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.glgs.cso.di.module.LauncherModule

import com.jess.arms.di.scope.ActivityScope
import com.glgs.cso.mvp.ui.activity.LauncherActivity


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/08/2019 11:00
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(LauncherModule::class), dependencies = arrayOf(AppComponent::class))
interface LauncherComponent {
    fun inject(activity: LauncherActivity)
}
