package com.glgs.cso.mvp.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.Button

/**
 * 作    者：MingMeng
 * 创建日期：2019/10/18
 * 描    述：
 */
@SuppressLint("AppCompatCustomView")
class DrawableVerticalButton(context: Context, attrs: AttributeSet) : Button(context, attrs) {

    override fun onDraw(canvas: Canvas) {
        var canvas = canvas
        canvas = getTopCanvas(canvas)
        super.onDraw(canvas)
    }

    private fun getTopCanvas(canvas: Canvas): Canvas {
        val drawables = compoundDrawables ?: return canvas
        var drawable: Drawable? = drawables[1]// 上面的drawable
        if (drawable == null) {
            drawable = drawables[3]// 下面的drawable
        }

        val textSize = paint.textSize
        val drawHeight = drawable!!.intrinsicHeight
        val drawPadding = compoundDrawablePadding
        val contentHeight = textSize + drawHeight.toFloat() + drawPadding.toFloat()
        val topPadding = (height - contentHeight).toInt()
        setPadding(0, topPadding, 0, 0)
        val dy = (contentHeight - height) / 2
        canvas.translate(0f, dy)
        return canvas
    }
}

