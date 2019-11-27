package com.glgs.cso.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.glgs.cso.mvp.contract.UserLoginContract
import com.glgs.cso.mvp.model.UserLoginModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/08/2019 17:40
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
//构建UserLoginModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class UserLoginModule(private val view: UserLoginContract.View) {
    @ActivityScope
    @Provides
    fun provideUserLoginView(): UserLoginContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideUserLoginModel(model: UserLoginModel): UserLoginContract.Model {
        return model
    }
}
