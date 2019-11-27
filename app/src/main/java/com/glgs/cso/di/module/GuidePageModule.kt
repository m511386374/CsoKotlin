package com.glgs.cso.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.glgs.cso.mvp.contract.GuidePageContract
import com.glgs.cso.mvp.model.GuidePageModel


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
@Module
//构建GuidePageModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class GuidePageModule(private val view: GuidePageContract.View) {
    @ActivityScope
    @Provides
    fun provideGuidePageView(): GuidePageContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideGuidePageModel(model: GuidePageModel): GuidePageContract.Model {
        return model
    }
}
