package com.glgs.cso.mvp.presenter

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.glgs.cso.mvp.contract.ManagementCenterContract
import com.glgs.cso.mvp.model.entity.BaseResponse
import com.glgs.cso.mvp.model.entity.CommonBean
import com.glgs.cso.mvp.model.entity.ManagementCenterBannerBean
import com.jess.arms.utils.RxLifecycleUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber

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

class ManagementCenterPresenter
@Inject
constructor(model: ManagementCenterContract.Model, rootView: ManagementCenterContract.View) :
        BasePresenter<ManagementCenterContract.Model, ManagementCenterContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager
    fun getBanner() {
        mModel.getBanner()
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(object : ErrorHandleSubscriber<BaseResponse<List<ManagementCenterBannerBean>>>(mErrorHandler!!) {
                    override fun onNext(baseResponse: BaseResponse<List<ManagementCenterBannerBean>>) {
                        if (baseResponse.isSuccess!!) {
                            mRootView.getBannerSuccess(baseResponse.data!!)
                        } else {
                            mRootView.showMessage(baseResponse.message!!)
                        }

                    }
                })
    }
    override fun onDestroy() {
        super.onDestroy();
    }
}
