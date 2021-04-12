package com.example.onlinestore.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Shader
import android.graphics.drawable.*
import android.graphics.drawable.shapes.RoundRectShape
import android.graphics.drawable.shapes.Shape
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.graphics.drawable.DrawableWrapper
import androidx.appcompat.widget.AppCompatRatingBar
import com.example.onlinestore.R

class RatingBarSvg @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.ratingBarStyle
) : AppCompatRatingBar(context, attrs, defStyleAttr) {

    private var mSampleTile: Bitmap? = null
    private var gap = 1

    private val drawableShape: Shape
        get() {
            val roundedCorners = floatArrayOf(5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f)
            return RoundRectShape(roundedCorners, null, null)
        }

    init {
        init(context, attrs)
        val drawable = tileify(progressDrawable, false) as LayerDrawable
        progressDrawable = drawable
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.RatingBarSvg)
            gap =
                typedArray.getDimensionPixelSize(R.styleable.RatingBarSvg_drawablePaddingRight, 1)
            typedArray.recycle()
        }
    }

    @SuppressLint("RestrictedApi")
    private fun tileify(drawable: Drawable, clip: Boolean): Drawable {
        if (drawable is DrawableWrapper) {
            var inner: Drawable? = drawable.wrappedDrawable
            if (inner != null) {
                inner = tileify(inner, clip)
                drawable.wrappedDrawable = inner
            }
        } else if (drawable is LayerDrawable) {
            val numberOfLayers = drawable.numberOfLayers
            val outDrawables = arrayOfNulls<Drawable>(numberOfLayers)

            for (i in 0 until numberOfLayers) {
                val id = drawable.getId(i)
                outDrawables[i] = tileify(
                    drawable.getDrawable(i),
                    id == android.R.id.progress || id == android.R.id.secondaryProgress
                )
            }

            val newBg = LayerDrawable(outDrawables)

            for (i in 0 until numberOfLayers) {
                newBg.setId(i, drawable.getId(i))
            }

            return newBg

        } else if (drawable is BitmapDrawable) {
            val tileBitmap = drawable.bitmap
            if (mSampleTile == null) {
                mSampleTile = tileBitmap
            }

            val shapeDrawable = ShapeDrawable(drawableShape)
            val bitmapShader = BitmapShader(
                tileBitmap,
                Shader.TileMode.REPEAT, Shader.TileMode.CLAMP
            )
            shapeDrawable.paint.shader = bitmapShader
            shapeDrawable.paint.colorFilter = drawable.paint.colorFilter
            return if (clip)
                ClipDrawable(
                    shapeDrawable, Gravity.LEFT,
                    ClipDrawable.HORIZONTAL
                )
            else
                shapeDrawable
        } else {
            return tileify(getBitmapDrawableFromVectorDrawable(drawable), clip)
        }

        return drawable
    }

    private fun getBitmapDrawableFromVectorDrawable(drawable: Drawable): BitmapDrawable {
        val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth + (gap),
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
        drawable.draw(canvas)

        return BitmapDrawable(resources, bitmap)
    }

    @Synchronized
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (mSampleTile != null) {
            val width = mSampleTile!!.width * numStars
            setMeasuredDimension(
                resolveSizeAndState(width, widthMeasureSpec, 0),
                measuredHeight
            )
        }
    }
}
