package com.glgs.cso.mvp.ui.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Message
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.blankj.utilcode.util.ScreenUtils
import com.blankj.utilcode.util.SizeUtils
import com.bumptech.glide.Glide

import com.jess.arms.base.BaseFragment
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.glgs.cso.di.component.DaggerManagementCenterComponent
import com.glgs.cso.di.module.ManagementCenterModule
import com.glgs.cso.mvp.contract.ManagementCenterContract
import com.glgs.cso.mvp.presenter.ManagementCenterPresenter

import com.glgs.cso.R
import com.glgs.cso.app.base.BaseUiFragment
import com.glgs.cso.app.config.ConstantConfig
import com.glgs.cso.app.utils.Utils
import com.glgs.cso.mvp.model.entity.AppBean
import com.glgs.cso.mvp.model.entity.CommonBean
import com.glgs.cso.mvp.model.entity.ManagementCenterBannerBean
import kotlinx.android.synthetic.main.fragment_management_center.*
import java.util.HashMap


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
/**
 * 如果没presenter
 * 你可以这样写
 *
 * @FragmentScope(請注意命名空間) class NullObjectPresenterByFragment
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */
class ManagementCenterFragment : BaseUiFragment<ManagementCenterPresenter>(), ManagementCenterContract.View, View.OnClickListener  {

    private var widthRate: Float? = null
    private var iconMap: Map<String, Int>? = null
    private val homeImage: Map<String, Int>
        get() {
            val iconMap = HashMap<String, Int>()
            iconMap["approve_icon1"] = R.mipmap.approve_icon1
            iconMap["attendance_icon1"] = R.mipmap.attendance_icon1
            iconMap["invoice_icon1"] = R.mipmap.invoice_icon1
            iconMap["knowledge_icon1"] = R.mipmap.knowledge_icon1
            iconMap["notice_icon1"] = R.mipmap.notice_icon1
            iconMap["task_icon1"] = R.mipmap.task_icon1
            iconMap["task_publish_icon1"] = R.mipmap.task_publish_icon1

            iconMap["approve_icon2"] = R.mipmap.approve_icon2
            iconMap["attendance_icon2"] = R.mipmap.attendance_icon2
            iconMap["invoice_icon2"] = R.mipmap.invoice_icon2
            iconMap["knowledge_icon2"] = R.mipmap.knowledge_icon2
            iconMap["notice_icon2"] = R.mipmap.notice_icon2
            iconMap["task_icon2"] = R.mipmap.task_icon2
            iconMap["task_publish_icon2"] = R.mipmap.task_publish_icon2

            iconMap["approve_icon3"] = R.mipmap.approve_icon3
            iconMap["attendance_icon3"] = R.mipmap.attendance_icon3
            iconMap["invoice_icon3"] = R.mipmap.invoice_icon3
            iconMap["knowledge_icon3"] = R.mipmap.knowledge_icon3
            iconMap["notice_icon3"] = R.mipmap.notice_icon3
            iconMap["task_icon3"] = R.mipmap.task_icon3
            iconMap["task_publish_icon3"] = R.mipmap.task_publish_icon3

            iconMap["approve_icon4"] = R.mipmap.approve_icon4
            iconMap["attendance_icon4"] = R.mipmap.attendance_icon4
            iconMap["invoice_icon4"] = R.mipmap.invoice_icon4
            iconMap["knowledge_icon4"] = R.mipmap.knowledge_icon4
            iconMap["notice_icon4"] = R.mipmap.notice_icon4
            iconMap["task_icon4"] = R.mipmap.task_icon4
            iconMap["task_publish_icon4"] = R.mipmap.task_publish_icon4

            iconMap["approve_icon5"] = R.mipmap.approve_icon5
            iconMap["attendance_icon5"] = R.mipmap.attendance_icon5
            iconMap["invoice_icon5"] = R.mipmap.invoice_icon5
            iconMap["knowledge_icon5"] = R.mipmap.knowledge_icon5
            iconMap["notice_icon5"] = R.mipmap.notice_icon5
            iconMap["task_icon5"] = R.mipmap.task_icon5
            iconMap["task_publish_icon5"] = R.mipmap.task_publish_icon5
            return iconMap
        }

    companion object {
        fun newInstance(): ManagementCenterFragment {
            val fragment = ManagementCenterFragment()
            return fragment
        }
    }


    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerManagementCenterComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .managementCenterModule(ManagementCenterModule(this))
                .build()
                .inject(this)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_management_center, container, false);
    }

    override fun initData(savedInstanceState: Bundle?) {
        iconMap = homeImage
        mTitlebar!!.setBackgroundColor(Color.parseColor(ConstantConfig.appBean!!.color))
        if (ConstantConfig.appBean != null && ConstantConfig.appBean!!.pageLabel != null) {
            mTitlebar!!.centerTextView.text = ConstantConfig.appBean!!.pageLabel!!.homePageName
        }
        initBanner()
        initNetwork()
        widthRate = SizeUtils.px2dp(ScreenUtils.getScreenWidth().toFloat()).toFloat() / ConstantConfig.AppWidth.toFloat()
        mBtTaskApply.setOnClickListener(this)
        mBtMyTask!!.setOnClickListener(this)
        mBtApproval!!.setOnClickListener(this)
        mBtAttendance!!.setOnClickListener(this)
        mBtKnowledgeAssessment!!.setOnClickListener(this)
        mBtInvoiceManagement!!.setOnClickListener(this)
        mBtNoticeManagement!!.setOnClickListener(this)
        val appBean = Utils.instance.appBean
        val moduleListBean = HashMap<String?, AppBean.ConsolePageBean.ModuleListBean>()
        if (appBean!!.consolePage!!.moduleList != null && appBean!!.consolePage!!.moduleList!!.size > 1) {
            for (bean in appBean.consolePage!!.moduleList!!) {
                moduleListBean[bean.moduleCode] = bean
            }
        }
        if (appBean.consolePage!!.bannarPage!!.speed != "") {
            mBanner!!.setDelayTime(Integer.parseInt(appBean.consolePage!!.bannarPage!!.speed))
        }

        mBanner!!.isAutoPlay(if (appBean!!.consolePage!!.bannarPage!!.isAutoPlay === 0) false else true)
        val params = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, SizeUtils.dp2px(Utils.instance.appBean!!.consolePage!!.bannarPage!!.height!! * widthRate!!))
        mBanner!!.layoutParams = params
        if (moduleListBean["0002"] != null) {
            val layout = RelativeLayout.LayoutParams(SizeUtils.dp2px(moduleListBean["0002"]!!.wide!! * widthRate!!), SizeUtils.dp2px(moduleListBean["0002"]!!.height!! * widthRate!!))
            layout.setMargins(SizeUtils.dp2px(moduleListBean["0002"]!!.xAxle!! * widthRate!!), SizeUtils.dp2px(moduleListBean["0002"]!!.yAxle!! * widthRate!!), 0, 0)
            mBtTaskApply!!.layoutParams = layout
            mBtTaskApply!!.text = moduleListBean["0002"]!!.name
            mBtTaskApply!!.setCompoundDrawables(null, changeBtnTop(iconMap!!.get(moduleListBean["0002"]!!.iconUrl)!!), null, null)
            mBtTaskApply!!.compoundDrawables[1].setColorFilter(Color.parseColor(moduleListBean["0002"]!!.color), PorterDuff.Mode.SRC_ATOP)
        } else {
            mBtTaskApply!!.visibility = View.GONE
        }
        if (moduleListBean["0003"] != null) {
            val layout1 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            layout1.setMargins(SizeUtils.dp2px(moduleListBean["0003"]!!.xAxle!! * widthRate!!), SizeUtils.dp2px(moduleListBean["0003"]!!.yAxle!! * widthRate!!), 0, 0)
            layout1.height = SizeUtils.dp2px(moduleListBean["0003"]!!.height!! * widthRate!!)
            layout1.width = SizeUtils.dp2px(moduleListBean["0003"]!!.wide!! * widthRate!!)
            mBtMyTask!!.layoutParams = layout1
            mBtMyTask!!.text = moduleListBean["0003"]!!.name
            mBtMyTask!!.setCompoundDrawables(null, changeBtnTop(iconMap!!.get(moduleListBean["0003"]!!.iconUrl)!!), null, null)
            mBtMyTask!!.compoundDrawables[1].setColorFilter(Color.parseColor(moduleListBean["0003"]!!.color), PorterDuff.Mode.SRC_ATOP)
        } else {
            mBtMyTask!!.visibility = View.GONE
        }
        if (moduleListBean["0004"] != null) {
            val layout2 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            layout2.setMargins(SizeUtils.dp2px(moduleListBean["0004"]!!.xAxle!! * widthRate!!), SizeUtils.dp2px(moduleListBean["0004"]!!.yAxle!! * widthRate!!), 0, 0)
            layout2.height = SizeUtils.dp2px(moduleListBean["0004"]!!.height!! * widthRate!!)
            layout2.width = SizeUtils.dp2px(moduleListBean["0004"]!!.wide!! * widthRate!!)
            mBtAttendance!!.layoutParams = layout2
            mBtAttendance!!.text = moduleListBean["0004"]!!.name
            mBtAttendance!!.setCompoundDrawables(null, changeBtnTop(iconMap!!.get(moduleListBean["0004"]!!.iconUrl)!!), null, null)
            mBtAttendance!!.compoundDrawables[1].setColorFilter(Color.parseColor(moduleListBean["0004"]!!.color), PorterDuff.Mode.SRC_ATOP)
        } else {
            mBtAttendance!!.visibility = View.GONE
        }
        if (moduleListBean["0005"] != null) {
            val layout3 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            layout3.setMargins(SizeUtils.dp2px(moduleListBean["0005"]!!.xAxle!! * widthRate!!), SizeUtils.dp2px(moduleListBean["0005"]!!.yAxle!! * widthRate!!), 0, 0)
            layout3.height = SizeUtils.dp2px(moduleListBean["0005"]!!.height!! * widthRate!!)
            layout3.width = SizeUtils.dp2px(moduleListBean["0005"]!!.wide!! * widthRate!!)
            mBtApproval!!.layoutParams = layout3
            mBtApproval!!.text = moduleListBean["0005"]!!.name
            mBtApproval!!.setCompoundDrawables(null, changeBtnTop(iconMap!!.get(moduleListBean["0005"]!!.iconUrl)!!), null, null)
            mBtApproval!!.compoundDrawables[1].setColorFilter(Color.parseColor(moduleListBean["0005"]!!.color), PorterDuff.Mode.SRC_ATOP)
        } else {
            mBtApproval!!.visibility = View.GONE
        }
        if (moduleListBean["0006"] != null) {
            val layout4 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            layout4.setMargins(SizeUtils.dp2px(moduleListBean["0006"]!!.xAxle!! * widthRate!!), SizeUtils.dp2px(moduleListBean["0006"]!!.yAxle!! * widthRate!!), 0, 0)
            layout4.height = SizeUtils.dp2px(moduleListBean["0006"]!!.height!! * widthRate!!)
            layout4.width = SizeUtils.dp2px(moduleListBean["0006"]!!.wide!! * widthRate!!)
            mBtKnowledgeAssessment!!.layoutParams = layout4
            mBtKnowledgeAssessment!!.text = moduleListBean["0006"]!!.name
            mBtKnowledgeAssessment!!.setCompoundDrawables(null, changeBtnTop(iconMap!!.get(moduleListBean["0006"]!!.iconUrl)!!), null, null)
            mBtKnowledgeAssessment!!.compoundDrawables[1].setColorFilter(Color.parseColor(moduleListBean["0006"]!!.color), PorterDuff.Mode.SRC_ATOP)
        } else {
            mBtKnowledgeAssessment!!.visibility = View.GONE
        }
        if (moduleListBean["0007"] != null) {
            val layout5 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            layout5.setMargins(SizeUtils.dp2px(moduleListBean["0007"]!!.xAxle!! * widthRate!!), SizeUtils.dp2px(moduleListBean["0007"]!!.yAxle!! * widthRate!!), 0, 0)
            layout5.height = SizeUtils.dp2px(moduleListBean["0007"]!!.height!! * widthRate!!)
            layout5.width = SizeUtils.dp2px(moduleListBean["0007"]!!.wide!! * widthRate!!)
            mBtInvoiceManagement!!.layoutParams = layout5
            mBtInvoiceManagement!!.text = moduleListBean["0007"]!!.name
            mBtInvoiceManagement!!.setCompoundDrawables(null, changeBtnTop(iconMap!!.get(moduleListBean["0007"]!!.iconUrl)!!), null, null)
            mBtInvoiceManagement!!.compoundDrawables[1].setColorFilter(Color.parseColor(moduleListBean["0007"]!!.color), PorterDuff.Mode.SRC_ATOP)
        } else {
            mBtInvoiceManagement!!.visibility = View.GONE
        }
        if (moduleListBean["0008"] != null) {
            val layout6 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            layout6.setMargins(SizeUtils.dp2px(moduleListBean["0008"]!!.xAxle!! * widthRate!!), SizeUtils.dp2px(moduleListBean["0008"]!!.yAxle!! * widthRate!!), 0, 0)
            layout6.height = SizeUtils.dp2px(moduleListBean["0008"]!!.height!! * widthRate!!)
            layout6.width = SizeUtils.dp2px(moduleListBean["0008"]!!.wide!! * widthRate!!)
            mBtNoticeManagement!!.layoutParams = layout6
            mBtNoticeManagement!!.text = moduleListBean["0008"]!!.name
            mBtNoticeManagement!!.setCompoundDrawables(null, changeBtnTop(iconMap!!.get(moduleListBean["0008"]!!.iconUrl)!!), null, null)
            mBtNoticeManagement!!.compoundDrawables[1].setColorFilter(Color.parseColor(moduleListBean["0008"]!!.color), PorterDuff.Mode.SRC_ATOP)
        } else {
            mBtNoticeManagement!!.visibility = View.GONE
        }
    }
    private fun initBanner() {
        mBanner!!.setImageLoader(object : com.youth.banner.loader.ImageLoader() {
            override fun displayImage(context: Context, path: Any, imageView: ImageView) {
                Glide.with(context).load(path).into(imageView)
            }
        })

    }
    private fun changeBtnTop(id: Int): Drawable {
        val drawableTop = resources.getDrawable(id)
        drawableTop.setBounds(0, 0, drawableTop.minimumWidth, drawableTop.minimumHeight)
        return drawableTop
    }
    private fun initNetwork() {
        mPresenter!!.getBanner()
    }
    override fun onClick(v: View?) {
        when (v!!.id) {
//            R.id.mBtTaskApply -> {
//                if (!UserDateUtil.getInstance().getLoginBean().getLevel().equals("0")) {
//                    ToastUtils.show("权限不足！")
//                    return
//                }
//                launchActivity(Intent(getActivity(), TaskApplyActivity::class.java))
//            }
//            R.id.mBtMyTask -> launchActivity(Intent(getActivity(), MyTaskActivity::class.java))
//            R.id.mBtAttendance -> launchActivity(Intent(getActivity(), ApproveActivity::class.java))
//            R.id.mBtApproval -> launchActivity(Intent(getActivity(), KnowledgeAssessmentActivity::class.java))
//            R.id.mBtKnowledgeAssessment -> launchActivity(Intent(getActivity(), AttendanceActivity::class.java))
//            R.id.mBtInvoiceManagement -> launchActivity(Intent(getActivity(), InvoiceManagementActivity::class.java))
//            R.id.mBtNoticeManagement -> launchActivity(Intent(getActivity(), NotificationManagementActivity::class.java))
        }
    }

    override val activity: Activity
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun showContent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBannerSuccess(lists: List<ManagementCenterBannerBean>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * 通过此方法可以使 Fragment 能够与外界做一些交互和通信, 比如说外部的 Activity 想让自己持有的某个 Fragment 对象执行一些方法,
     * 建议在有多个需要与外界交互的方法时, 统一传 {@link Message}, 通过 what 字段来区分不同的方法, 在 {@link #setData(Object)}
     * 方法中就可以 {@code switch} 做不同的操作, 这样就可以用统一的入口方法做多个不同的操作, 可以起到分发的作用
     * <p>
     * 调用此方法时请注意调用时 Fragment 的生命周期, 如果调用 {@link #setData(Object)} 方法时 {@link Fragment#onCreate(Bundle)} 还没执行
     * 但在 {@link #setData(Object)} 里却调用了 Presenter 的方法, 是会报空的, 因为 Dagger 注入是在 {@link Fragment#onCreate(Bundle)} 方法中执行的
     * 然后才创建的 Presenter, 如果要做一些初始化操作,可以不必让外部调用 {@link #setData(Object)}, 在 {@link #initData(Bundle)} 中初始化就可以了
     * <p>
     * Example usage:
     * <pre>
     *fun setData(data:Any) {
     *   if(data is Message){
     *       when (data.what) {
     *           0-> {
     *               //根据what 做你想做的事情
     *           }
     *           else -> {
     *           }
     *       }
     *   }
     *}
     *
     *
     *
     *
     *
     * // call setData(Object):
     * val data = Message();
     * data.what = 0;
     * data.arg1 = 1;
     * fragment.setData(data);
     * </pre>
     *
     * @param data 当不需要参数时 {@code data} 可以为 {@code null}
     */
    override fun setData(data: Any?) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {

    }
}
