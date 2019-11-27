package com.glgs.cso.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.glgs.cso.di.module.GuidePageModule

import com.jess.arms.di.scope.ActivityScope
import com.glgs.cso.mvp.ui.activity.GuidePageActivity


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/11/2019 09:20
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(GuidePageModule::class), dependencies = arrayOf(AppComponent::class))
interface GuidePageComponent {
    fun inject(activity: GuidePageActivity)
}
