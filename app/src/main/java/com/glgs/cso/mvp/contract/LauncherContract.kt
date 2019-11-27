package com.glgs.cso.mvp.contract

import com.glgs.cso.mvp.model.entity.AppBean
import com.glgs.cso.mvp.model.entity.BaseResponse
import com.glgs.cso.mvp.model.entity.LoginBean
import com.jess.arms.mvp.IView
import com.jess.arms.mvp.IModel
import io.reactivex.Observable


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
interface LauncherContract {
    interface View : IView {
        fun loginSuccess(loginBean: LoginBean)
        fun getAppJsonSuccess(appBean: AppBean)
        fun intentLogin()
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model : IModel {
        fun getAppJson(): Observable<BaseResponse<AppBean>>
        fun getLogin(phone: String, passWord: String):Observable<BaseResponse<LoginBean>>
    }
}
