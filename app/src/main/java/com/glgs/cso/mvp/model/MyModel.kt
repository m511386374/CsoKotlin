package com.glgs.cso.mvp.model

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.glgs.cso.app.utils.Utils

import com.jess.arms.di.scope.FragmentScope
import javax.inject.Inject
import com.glgs.cso.mvp.contract.MyContract
import com.glgs.cso.mvp.model.api.service.MyService
import com.glgs.cso.mvp.model.entity.BaseResponse
import com.glgs.cso.mvp.model.entity.CommonBean
import io.reactivex.Observable

/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 11/11/2019 11:24
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
class MyModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseUiModel(repositoryManager), MyContract.Model {
    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;

    override fun getMyDate(string: String): Observable<BaseResponse<CommonBean>> {
        val hashMap = HashMap<String, Any>()

        return mRepositoryManager.obtainRetrofitService(MyService::class.java).editHeadimg(Utils.instance.getMd5Parameters(putCommonParams(hashMap)))
    }

    override fun onDestroy() {
        super.onDestroy();
    }
}
