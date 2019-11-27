package com.glgs.cso.mvp.model

import android.app.Application
import com.glgs.cso.BuildConfig
import com.glgs.cso.app.utils.Utils
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.glgs.cso.mvp.contract.LauncherContract
import com.glgs.cso.mvp.model.entity.AppBean
import com.glgs.cso.app.config.ConstantConfig
import com.glgs.cso.mvp.model.api.service.UserLoginService
import com.glgs.cso.mvp.model.entity.BaseResponse
import com.glgs.cso.mvp.model.entity.LoginBean
import io.reactivex.Observable
import java.util.HashMap


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
class LauncherModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseUiModel(repositoryManager), LauncherContract.Model {
    override fun getAppJson(): Observable<BaseResponse<AppBean>> {
        val hashMap = HashMap<String, Any>()
        hashMap["types"] = "0"
        hashMap[ConstantConfig.COMPANYCODE] = BuildConfig.PLAT_FORM_CODE
        hashMap["versrionstatus"] = BuildConfig.VERSRIONSTATUS
        hashMap["packid"] = BuildConfig.MANAGE_ID
        return mRepositoryManager.obtainRetrofitService(UserLoginService::class.java).getAppJson(Utils.instance.getMd5Parameters(putCommonParams(hashMap)))
    }

    override fun getLogin(phone: String, passWord: String): Observable<BaseResponse<LoginBean>> {
        val hashMap = HashMap<String, Any>()
        hashMap[ConstantConfig.COMPANYCODE] = BuildConfig.PLAT_FORM_CODE
        hashMap[ConstantConfig.PHONE] = phone
        hashMap[ConstantConfig.PASSWORD] = passWord
        return mRepositoryManager.obtainRetrofitService(UserLoginService::class.java).getLoginDate(Utils.instance.getMd5Parameters(putCommonParams(hashMap)))
    }


    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
