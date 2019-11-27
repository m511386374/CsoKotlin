package com.glgs.cso.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.blankj.utilcode.util.SPUtils

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.glgs.cso.di.component.DaggerLauncherComponent
import com.glgs.cso.di.module.LauncherModule
import com.glgs.cso.mvp.contract.LauncherContract
import com.glgs.cso.mvp.presenter.LauncherPresenter

import com.glgs.cso.R
import com.glgs.cso.app.api.Api
import com.glgs.cso.mvp.model.entity.AppBean
import com.glgs.cso.app.base.BaseUiActivity
import com.glgs.cso.app.config.ConstantConfig
import com.glgs.cso.mvp.model.entity.LoginBean
import com.google.gson.Gson
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
/**
 * 如果没presenter
 * 你可以这样写
 *
 * @ActivityScope(請注意命名空間) class NullObjectPresenterByActivity
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */
class LauncherActivity : BaseUiActivity<LauncherPresenter>(), LauncherContract.View {
    private var isFirst: Boolean? = null
    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerLauncherComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .launcherModule(LauncherModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_launcher //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        mPresenter!!.getAppJson()
    }
    override fun intentLogin() {
        launchActivity(Intent(this, UserLoginActivity::class.java))
        killMyself()
    }

    override fun loginSuccess(loginBean: LoginBean) {
        launchActivity(Intent(this, MainActivity::class.java))
        killMyself()
    }
    override fun getAppJsonSuccess(appBean: AppBean) {
        SPUtils.getInstance().put(ConstantConfig.USER_APP_DATE_BEAN, Gson().toJson(appBean))
        val moduleListBean = HashMap<String?, AppBean.ConsolePageBean.ModuleListBean>()
        if (appBean != null && appBean.consolePage != null && appBean.consolePage!!.moduleList != null && appBean.consolePage!!.moduleList!!.size > 1) {
            for (bean in appBean.consolePage!!.moduleList!!) {
                moduleListBean[bean.moduleCode] = bean
            }
            ConstantConfig.moduleListBean = moduleListBean

        }
        ConstantConfig.appBean = appBean
        isFirst = SPUtils.getInstance().getBoolean(ConstantConfig.FIRST_GUIDE_PAGE)
        val acount = SPUtils.getInstance().getString(ConstantConfig.SP_ACOUNT, "")
        val passWord = SPUtils.getInstance().getString(ConstantConfig.SP_PASSWORD, "")
        if (isFirst!!) {
            if (TextUtils.isEmpty(acount) || TextUtils.isEmpty(passWord)) {
                val intent = Intent(this, UserLoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                mPresenter!!.getLogin(acount, passWord)
            }
        } else {
            val intent = Intent(this, GuidePageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }
    override fun showTitleBar(): Boolean {
        return false
    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }
}
