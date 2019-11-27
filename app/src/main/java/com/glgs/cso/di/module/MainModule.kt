package com.glgs.cso.di.module

import android.support.v4.app.FragmentActivity
import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.glgs.cso.mvp.contract.MainContract
import com.glgs.cso.mvp.model.MainModel
import com.tbruyelle.rxpermissions2.RxPermissions


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/11/2019 11:08
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
//构建MainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MainModule(private val view: MainContract.View) {
    @ActivityScope
    @Provides
    fun provideMainView(): MainContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMainModel(model: MainModel): MainContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    internal fun provideRxPermissions(): RxPermissions {
        return RxPermissions(view.activity as FragmentActivity)
    }
}
