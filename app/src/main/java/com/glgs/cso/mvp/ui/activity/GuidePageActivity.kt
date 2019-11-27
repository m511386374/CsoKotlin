package com.glgs.cso.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import com.kongzue.dialog.v3.WaitDialog
import com.glgs.cso.mvp.model.entity.CommonBean
import com.glgs.cso.di.component.DaggerGuidePageComponent
import com.glgs.cso.di.module.GuidePageModule
import com.glgs.cso.mvp.contract.GuidePageContract
import com.glgs.cso.mvp.presenter.GuidePagePresenter
import com.glgs.cso.app.base.BaseUiActivity

import com.glgs.cso.R
import com.glgs.cso.app.utils.Utils
import com.jess.arms.http.imageloader.glide.ImageConfigImpl
import kotlinx.android.synthetic.main.activity_guide_page.*
import java.util.ArrayList


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
class GuidePageActivity : BaseUiActivity<GuidePagePresenter>(), GuidePageContract.View {
    private var mList: List<String>? = null

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerGuidePageComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .guidePageModule(GuidePageModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_guide_page //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        val mViewList = ArrayList<View>()
        val appBean = Utils.instance.appBean
        mList = appBean!!.guidePage
        if (mList!!.size > 0) {
            for (iamge in mList!!) {
                val imageView = ImageView(this)
                val layout = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                imageView.layoutParams = layout
                ArmsUtils.obtainAppComponentFromContext(this).imageLoader().loadImage(this,
                        ImageConfigImpl
                                .builder()
                                .errorPic(R.mipmap.bg_default2_1)
                                .url(iamge)
                                .imageView(imageView)
                                .build())
                mViewList.add(imageView)
            }
            mViewPager!!.adapter = ViewPagerAdatper(mViewList)
            mViewPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    if (position == mList!!.size - 1) {
                        val intent = Intent(this@GuidePageActivity, UserLoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
                override fun onPageSelected(position: Int) {}

                override fun onPageScrollStateChanged(state: Int) {}
            })
        } else {
            val intent = Intent(this@GuidePageActivity, UserLoginActivity::class.java)
            startActivity(intent)
            finish()
        }

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

    internal class ViewPagerAdatper(private val mViewList: List<View>) : PagerAdapter() {

        override fun getCount(): Int {
            return mViewList.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            container.addView(mViewList[position])
            return mViewList[position]
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(mViewList[position])
        }
    }
}
