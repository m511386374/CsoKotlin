package com.glgs.cso.di.module

import com.jess.arms.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

import com.glgs.cso.mvp.contract.ManagementCenterContract
import com.glgs.cso.mvp.model.ManagementCenterModel


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
@Module
//构建ManagementCenterModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class ManagementCenterModule(private val view: ManagementCenterContract.View) {
    @FragmentScope
    @Provides
    fun provideManagementCenterView(): ManagementCenterContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideManagementCenterModel(model: ManagementCenterModel): ManagementCenterContract.Model {
        return model
    }
}
