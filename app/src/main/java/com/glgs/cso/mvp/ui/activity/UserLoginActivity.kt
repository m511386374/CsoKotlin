package com.glgs.cso.mvp.ui.activity

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.opengl.Visibility
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import com.blankj.utilcode.util.RegexUtils
import com.blankj.utilcode.util.SPUtils

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import com.kongzue.dialog.v3.WaitDialog
import com.glgs.cso.mvp.model.entity.CommonBean
import com.glgs.cso.di.component.DaggerUserLoginComponent
import com.glgs.cso.di.module.UserLoginModule
import com.glgs.cso.mvp.contract.UserLoginContract
import com.glgs.cso.mvp.presenter.UserLoginPresenter
import com.glgs.cso.app.base.BaseUiActivity

import com.glgs.cso.R
import com.glgs.cso.app.api.Api
import com.glgs.cso.app.config.ConstantConfig
import com.glgs.cso.mvp.model.entity.LoginBean
import com.google.gson.Gson
import com.hjq.toast.ToastUtils
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.http.imageloader.glide.ImageConfigImpl
import kotlinx.android.synthetic.main.activity_user_login.*


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
class UserLoginActivity : BaseUiActivity<UserLoginPresenter>(), UserLoginContract.View ,View.OnClickListener{

    private var mAppComponent: AppComponent? = null
    private var mImageLoader: ImageLoader? = null//用于加载图片的管理类,默认使用 Glide,使用策略模式,可替换框架
    private var str1: String? = null
    private var str2: String? = null
    private var srt1Length = 0
    private var srt2Length = 0
    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerUserLoginComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .userLoginModule(UserLoginModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_user_login //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        if (ConstantConfig.appBean != null) {
            val gd = mBtLogin!!.background as GradientDrawable
            gd.setColor(Color.parseColor(ConstantConfig.appBean!!.color))
            mForgetPassword!!.setTextColor(Color.parseColor(ConstantConfig.appBean!!.color))
            SPUtils.getInstance().put(ConstantConfig.FIRST_GUIDE_PAGE, true)
            if (ConstantConfig.appBean!!.isshowLogo == 1) {
                if (mAppComponent == null) {
                    mAppComponent = ArmsUtils.obtainAppComponentFromContext(this)
                }
                mImageLoader = mAppComponent!!.imageLoader()
                mImageLoader!!.loadImage(this,
                        ImageConfigImpl
                                .builder()
                                .url(ConstantConfig.appBean!!.loginIcon)
                                .imageView(mIvLoginLogo)
                                .build())
            }else{
                mIvLoginLogo.visibility = View.GONE
            }

            if (ConstantConfig.appBean!!.loginBg != null) {
                if (mAppComponent == null) {
                    mAppComponent = ArmsUtils.obtainAppComponentFromContext(this)
                }
                mImageLoader = mAppComponent!!.imageLoader()
                mImageLoader!!.loadImage(this,
                        ImageConfigImpl
                                .builder()
                                .url(ConstantConfig.appBean!!.loginBg)
                                .imageView(mIvBackground)
                                .build())
            }

        }
        mBtLogin!!.setOnClickListener(this)
        mIvDisplayPassword!!.setOnClickListener(this)
        mForgetPassword!!.setOnClickListener(this)
        val acount = SPUtils.getInstance().getString(ConstantConfig.SP_ACOUNT)
        val password = SPUtils.getInstance().getString(ConstantConfig.SP_PASSWORD)
        mEtPhone!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                srt1Length = s.toString().length
                if (srt1Length == 11 && srt2Length >= 8) {
                    mBtLogin!!.background = ContextCompat.getDrawable(this@UserLoginActivity, R.drawable.common_btn_bg)
                    mBtLogin!!.setOnClickListener(this@UserLoginActivity)
                    mBtLogin!!.isEnabled = true
                } else {
                    mBtLogin!!.isEnabled = false
                    mBtLogin!!.background = ContextCompat.getDrawable(this@UserLoginActivity, R.drawable.common_gray_btn_bg)
                }
            }
        })
        mEtPassword!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                srt2Length = s.toString().length
                if (srt1Length == 11 && srt2Length >= 8) {
                    mBtLogin!!.background = ContextCompat.getDrawable(this@UserLoginActivity, R.drawable.common_btn_bg)
                    mBtLogin!!.isEnabled = true
                } else {
                    mBtLogin!!.isEnabled = false
                    mBtLogin!!.background = ContextCompat.getDrawable(this@UserLoginActivity, R.drawable.common_gray_btn_bg)
                }
            }
        })
        if (!TextUtils.isEmpty(acount)) {
            mEtPhone!!.setText(acount)
        }
        if (!TextUtils.isEmpty(password)) {
            mEtPassword!!.setText(password)
        }
    }
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.mBtLogin -> {
                str1 = this.mEtPhone!!.text.toString().trim { it <= ' ' }
                str2 = this.mEtPassword!!.text.toString().trim { it <= ' ' }
                if (TextUtils.isEmpty(str1)) {
                    ToastUtils.show("请输入手机号!")
                }
                if (!RegexUtils.isMobileSimple(str1)) {
                    ToastUtils.show("请输入正确的手机号!")

                }

                if (TextUtils.isEmpty(str2)) {
                    ToastUtils.show("请输入密码!")
                }
                mPresenter!!.getLogin(str1!!, str2!!)
            }
            R.id.mForgetPassword -> {
//                val intent = Intent(this, ForgetPasswordActivity::class.java)
//                startActivity(intent)
            }
            R.id.mIvDisplayPassword -> if (EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD == mEtPassword!!.inputType) {
                //如果不可见就设置为可见
                mEtPassword!!.inputType = EditorInfo.TYPE_TEXT_VARIATION_PASSWORD
                mEtPassword!!.transformationMethod = PasswordTransformationMethod.getInstance()
                mIvDisplayPassword!!.setImageResource(R.mipmap.display_password_normal_icon)
            } else {
                //如果可见就设置为不可见
                mEtPassword!!.inputType = EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                mEtPassword!!.transformationMethod = HideReturnsTransformationMethod.getInstance()
                mIvDisplayPassword!!.setImageResource(R.mipmap.display_password_press_icon)
            }
        }
    }

    override fun getLoginSuccess(loginBean: LoginBean) {
        SPUtils.getInstance().put(ConstantConfig.USER_LOGIN_DATE_BEAN, Gson().toJson(loginBean))
        SPUtils.getInstance().put(ConstantConfig.SP_ACOUNT, str1)
        SPUtils.getInstance().put(ConstantConfig.SP_PASSWORD, str2)
        SPUtils.getInstance().put(ConstantConfig.SP_ACCESTOKEN, loginBean.token)
        Api.ACCESTOKEN = loginBean.token!!
        launchActivity(Intent(this, MainActivity::class.java))
        killMyself()
    }

    override fun showLoading() {
        val customView = LayoutInflater.from(this).inflate(R.layout.dialog_wait, null)
        WaitDialog.show(this, "加载中").bindView(customView)
    }

    override fun hideLoading() {
        WaitDialog.dismiss()
    }

    override fun showTitleBar(): Boolean {
        return false
    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun showContent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }
}
