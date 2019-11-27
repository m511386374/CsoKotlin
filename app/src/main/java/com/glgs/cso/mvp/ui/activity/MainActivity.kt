package com.glgs.cso.mvp.ui.activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import cn.jpush.android.api.JPushInterface
import cn.jpush.android.api.TagAliasCallback
import com.blankj.utilcode.util.SPUtils
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import com.kongzue.dialog.v3.WaitDialog
import com.glgs.cso.mvp.model.entity.CommonBean
import com.glgs.cso.di.component.DaggerMainComponent
import com.glgs.cso.di.module.MainModule
import com.glgs.cso.mvp.contract.MainContract
import com.glgs.cso.mvp.presenter.MainPresenter
import com.glgs.cso.app.base.BaseUiActivity

import com.glgs.cso.R
import com.glgs.cso.app.config.ConstantConfig
import com.glgs.cso.app.config.ConstantConfig.appBean
import com.glgs.cso.app.utils.UserDateUtil
import com.glgs.cso.mvp.ui.fragment.ManagementCenterFragment
import com.glgs.cso.mvp.ui.fragment.MyFragment
import com.glgs.cso.mvp.ui.view.BottomBar
import com.glgs.cso.mvp.ui.view.BottomBarTab
import com.jess.arms.utils.PermissionUtil
import com.tbruyelle.rxpermissions2.RxPermissions
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import me.yokeyword.fragmentation.ISupportFragment
import java.util.HashMap
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*

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
class MainActivity : BaseUiActivity<MainPresenter>(), MainContract.View {
    private val mFragments = arrayListOf<ISupportFragment>()

    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mRxPermissions: RxPermissions

    val FIRST = 0
    val SECOND = 1
    private val MSG_SET_ALIAS = 1001
    private val mainImage: Map<String, Int>
        get() {
            val iconMap = HashMap<String, Int>()
            iconMap["management_center_icon1"] = R.mipmap.management_center_icon1
            iconMap["personal_center_icon1"] = R.mipmap.personal_center_icon1
            iconMap["management_center_icon2"] = R.mipmap.management_center_icon2
            iconMap["personal_center_icon2"] = R.mipmap.personal_center_icon2
            iconMap["management_center_icon3"] = R.mipmap.management_center_icon3
            iconMap["personal_center_icon3"] = R.mipmap.personal_center_icon3
            iconMap["management_center_icon4"] = R.mipmap.management_center_icon4
            iconMap["personal_center_icon4"] = R.mipmap.personal_center_icon4
            iconMap["management_center_icon5"] = R.mipmap.management_center_icon5
            iconMap["personal_center_icon5"] = R.mipmap.personal_center_icon5

            return iconMap
        }

    override val activity: Activity
        get() = this

    private var mAliasCallback: TagAliasCallback? = TagAliasCallback { code, alias, tags ->
        val logs: String
        when (code) {
            0 -> {
                logs = "Set tag and alias success"
                SPUtils.getInstance().put(ConstantConfig.JPUSH_DATE, 1)
                Log.i(TAG, logs)
            }
            6002 -> {
                logs = "Failed to set alias and tags due to timeout. Try again after 60s."
                Log.i(TAG, logs)
                // 延迟 60 秒来调用 Handler 设置别名
                mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG_SET_ALIAS, alias), (1000 * 60).toLong())
            }
            else -> {
                logs = "Failed with errorCode = $code"
                Log.e(TAG, logs)
            }
        }// 建议这里往 SharePreference 里写一个成功设置的状态。成功设置一次后，以后不必再次设置了。
    }
    private val mHandler = object : Handler() {
        override fun handleMessage(msg: android.os.Message) {
            super.handleMessage(msg)
            when (msg.what) {
                MSG_SET_ALIAS -> {
                    Log.d(TAG, "Set alias in handler.")
                    // 调用 JPush 接口来设置别名。
                    JPushInterface.setAliasAndTags(applicationContext,
                            msg.obj as String,
                            null,
                            mAliasCallback)
                }
                else -> Log.i(TAG, "Unhandled msg - " + msg.what)
            }
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(MainModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        initBottomBar()
        requestPermission(this)
        mHandler.sendMessage(mHandler.obtainMessage(MSG_SET_ALIAS, UserDateUtil.instance.loginBean!!.id.toString()))

    }
    fun initBottomBar() {

        val firstFragment = findFragment(ManagementCenterFragment::class.java)
        if (firstFragment == null) {
            mFragments[FIRST] = ManagementCenterFragment.newInstance()
            mFragments[SECOND] = MyFragment.newInstance()
            loadMultipleRootFragment(R.id.mMainFrame, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND]
            )
        } else {
            mFragments[FIRST] = firstFragment
            mFragments[SECOND] = findFragment(MyFragment::class.java)
        }
        if (appBean != null && appBean!!.pageLabel != null && appBean!!.pageLabel!!.homePageIconUrl != null && appBean!!.pageLabel!!.homePageIconUrl != "") {
            mBottomBar!!.addItem(BottomBarTab(this, mainImage, appBean!!.pageLabel!!.homePageIconUrl!!, appBean!!.pageLabel!!.homePageName!!, LinearLayout.HORIZONTAL))
                    .addItem(BottomBarTab(this, mainImage, appBean!!.pageLabel!!.personalIconUrl!!, appBean!!.pageLabel!!.personalCenterName!!, LinearLayout.HORIZONTAL))
        } else {
            mMainFrame.visibility = View.GONE

        }
        mBottomBar.setOnTabSelectedListener(object : BottomBar.OnTabSelectedListener {
            override fun onTabSelected(position: Int, prePosition: Int) {
                showHideFragment(mFragments[position], mFragments[prePosition])
            }

            override fun onTabUnselected(position: Int) {

            }

            override fun onTabReselected(position: Int) {

            }
        })

    }
    fun requestPermission(activity: Activity) {
        //请求外部存储权限用于适配android6.0的权限管理机制
        PermissionUtil.requestPermission(object : PermissionUtil.RequestPermission {
            override fun onRequestPermissionSuccess() {
                //                UpDateUtil.upDate(activity);
            }
            override fun onRequestPermissionFailure(permissions: List<String>) {}
            override fun onRequestPermissionFailureWithAskNeverAgain(permissions: List<String>) {

            }
        }, mRxPermissions, mErrorHandler, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    override fun showLoading() {
        val customView = LayoutInflater.from(this).inflate(R.layout.dialog_wait, null)
        WaitDialog.show(this, "加载中").bindView(customView)
    }

    override fun hideLoading() {
        WaitDialog.dismiss()
    }

    override fun showTitleBar(): Boolean {
        return true
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
