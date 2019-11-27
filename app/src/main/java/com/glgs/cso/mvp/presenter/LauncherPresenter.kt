package com.glgs.cso.mvp.presenter

import android.app.Application

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.glgs.cso.mvp.contract.LauncherContract
import com.glgs.cso.mvp.model.entity.AppBean
import com.glgs.cso.mvp.model.entity.BaseResponse
import com.glgs.cso.mvp.model.entity.LoginBean
import com.jess.arms.utils.RxLifecycleUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber


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
class LauncherPresenter
@Inject
constructor(model: LauncherContract.Model, rootView: LauncherContract.View) :
        BasePresenter<LauncherContract.Model, LauncherContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager

    fun getLogin(phone: String, passWord: String) {
        mModel.getLogin(phone, passWord)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { disposable ->
                    mRootView.showLoading() }
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally {
                    mRootView.hideLoading() }
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(object : ErrorHandleSubscriber<BaseResponse<LoginBean>>(mErrorHandler!!) {
                    override fun onNext(baseResponse: BaseResponse<LoginBean>) {
                        if (baseResponse.isSuccess!!) {
                            mRootView.loginSuccess(baseResponse.data!!)
                        } else {
                            mRootView.showMessage(baseResponse.message!!)
                            mRootView.intentLogin()
                        }
                    }
                    override fun onError(t: Throwable) {
                        super.onError(t)
                        mRootView.hideLoading()
                    }
                })
    }

    fun getAppJson() {
        mModel.getAppJson()
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                .subscribe(object : ErrorHandleSubscriber<BaseResponse<AppBean>>(mErrorHandler!!) {
                    override fun onNext(baseResponse: BaseResponse<AppBean>) {
                        if (baseResponse.isSuccess!!) {
                            mRootView.getAppJsonSuccess(baseResponse.data!!)
                        }
                    }
                    override fun onError(t: Throwable) {
                        super.onError(t)
                        mRootView.hideLoading()
                    }
                })
    }

}
