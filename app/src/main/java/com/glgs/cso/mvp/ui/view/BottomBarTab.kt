package com.glgs.cso.mvp.ui.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.glgs.cso.R
import com.glgs.cso.app.config.ConstantConfig

import com.jess.arms.di.component.AppComponent
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.utils.ArmsUtils

/**
 * Created by YoKeyword on 16/6/3.
 */
class BottomBarTab(context: Context, attrs: AttributeSet?, defStyleAttr: Int, map: Map<String, Int>, defaultIcon: String, title: CharSequence, orientation: Int) : FrameLayout(context, attrs, defStyleAttr) {
    private var mIcon: ImageView? = null
    private var mTvTitle: TextView? = null
    private var mContext: Context? = null
    var tabPosition = -1
        set(position) {
            field = position
            if (position == 0) {
                isSelected = true
            }
        }
    internal var selectIcon: String? = null
    internal lateinit var defaultIcon: String
    internal lateinit var lLContainer: LinearLayout
    private val mTvUnreadCount: TextView? = null
    private var mAppComponent: AppComponent? = null
    private val mImageLoader: ImageLoader? = null//用于加载图片的管理类,默认使用 Glide,使用策略模式,可替换框架
    private var map: Map<String, Int>? = null

    /**
     * 获取当前未读数量
     */
    /**
     * 设置未读数量
     */
    var unreadCount: Int
        get() {
            var count = 0
            if (TextUtils.isEmpty(mTvUnreadCount!!.text)) {
                return count
            }
            if (mTvUnreadCount.text.toString() == "99+") {
                return 99
            }
            try {
                count = Integer.valueOf(mTvUnreadCount.text.toString())
            } catch (ignored: Exception) {
            }

            return count
        }
        set(num) = if (num <= 0) {
            mTvUnreadCount!!.text = 0.toString()
            mTvUnreadCount.visibility = View.GONE
        } else {
            mTvUnreadCount!!.visibility = View.VISIBLE
            if (num > 99) {
                mTvUnreadCount.text = "99+"
            } else {
                mTvUnreadCount.text = num.toString()
            }
        }

    constructor(context: Context, map: Map<String, Int>, defaultIcon: String, title: CharSequence, orientation: Int) : this(context, null, map, defaultIcon, title, orientation) {}

    constructor(context: Context, attrs: AttributeSet?, map: Map<String, Int>, defaultIcon: String, title: CharSequence, orientation: Int) : this(context, attrs, 0, map, defaultIcon, title, orientation) {}

    init {
        init(context, map, defaultIcon, title, orientation)
    }

    private fun init(context: Context, map: Map<String, Int>, defaultIcon: String, title: CharSequence, orientation: Int) {

        mContext = context
        this.map = null
        this.map = map
        this.defaultIcon = defaultIcon
        val typedArray = context.obtainStyledAttributes(intArrayOf(R.attr.selectableItemBackgroundBorderless))
        val drawable = typedArray.getDrawable(0)
        setBackgroundDrawable(drawable)
        typedArray.recycle()

        lLContainer = LinearLayout(context)
        lLContainer.orientation = orientation
        lLContainer.gravity = Gravity.CENTER
        val paramsContainer = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        paramsContainer.gravity = Gravity.CENTER
        lLContainer.layoutParams = paramsContainer
        mIcon = ImageView(context)
        val size = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 27f, resources.displayMetrics).toInt()
        val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        map[defaultIcon]?.let { mIcon!!.setImageResource(it) }
        mIcon!!.setColorFilter(Color.parseColor("#333333"), PorterDuff.Mode.SRC_ATOP)
        mIcon!!.layoutParams = params
        lLContainer.addView(mIcon)

        mTvTitle = TextView(context)
        mTvTitle!!.text = title
        val paramsTv = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        if (orientation == LinearLayout.HORIZONTAL) {
            paramsTv.leftMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15f, resources.displayMetrics).toInt()
        }
        mTvTitle!!.textSize = 16f
        mTvTitle!!.setTextColor(ContextCompat.getColor(context, R.color.bottombar_unselect))
        mTvTitle!!.layoutParams = paramsTv
        lLContainer.addView(mTvTitle)
        addView(lLContainer)

    }

    override fun setSelected(selected: Boolean) {
        super.setSelected(selected)
        if (selected) {
            if (mAppComponent == null) {
                mAppComponent = ArmsUtils.obtainAppComponentFromContext(mContext!!)
            }
            map!![defaultIcon]?.let { mIcon!!.setImageResource(it) }
            mIcon!!.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_ATOP)
            mTvTitle!!.setTextColor(ContextCompat.getColor(mContext!!, R.color.bottombar_select))
            lLContainer.setBackgroundColor(Color.parseColor(ConstantConfig.appBean!!.color))
        } else {
            if (mAppComponent == null) {
                mAppComponent = ArmsUtils.obtainAppComponentFromContext(mContext!!)
            }
            map!![defaultIcon]?.let { mIcon!!.setImageResource(it) }
            mIcon!!.setColorFilter(Color.parseColor("#333333"), PorterDuff.Mode.SRC_ATOP)
            mTvTitle!!.setTextColor(ContextCompat.getColor(mContext!!, R.color.bottombar_unselect))
            lLContainer.setBackgroundColor(resources.getColor(R.color.white))

        }
    }

    private fun dip2px(context: Context, dp: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics).toInt()
    }
}
