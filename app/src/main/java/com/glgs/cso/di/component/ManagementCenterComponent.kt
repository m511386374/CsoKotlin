package com.glgs.cso.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.glgs.cso.di.module.ManagementCenterModule

import com.jess.arms.di.scope.FragmentScope
import com.glgs.cso.mvp.ui.fragment.ManagementCenterFragment


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/11/2019 11:23
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = arrayOf(ManagementCenterModule::class), dependencies = arrayOf(AppComponent::class))
interface ManagementCenterComponent {
    fun inject(fragment: ManagementCenterFragment)
}
