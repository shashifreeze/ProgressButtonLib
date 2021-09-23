package com.shashifreeze.progressbutton

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.animation.AnimationUtils
import com.google.android.material.card.MaterialCardView

class ProgressLoadingButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    MaterialCardView(context, attrs, defStyleAttr) {

    private var buttonTextView:TextView? = null
    private var buttonProgressbar:ProgressBar? = null
    //private var buttonCardViewLayout:MaterialCardView? = null

    /**
     * Button attributes
     */
    private var progressColor = 0
    private var beforeProgressText = "Button"
    private var afterProgressText = "Done"
    private var btnTextSize = 0f
    private var textGravity = 0
    private var btnTextColor = Color.WHITE
    private var startProgressBgColor = Color.BLUE

    init {

        LayoutInflater.from(getContext()).inflate(R.layout.progress_loading_button_layout, this, true)
        buttonTextView = findViewById(R.id.buttonText)
        buttonProgressbar = findViewById(R.id.buttonProgress)
       // buttonCardViewLayout = findViewById(R.id.buttonCardViewLayout)

        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ProgressLoadingButtonAttr,
            defStyleAttr,
            defStyleAttr
        )

        typedArray.getString(R.styleable.ProgressLoadingButtonAttr_plb_before_progress_text)?.let {
            beforeProgressText = it
        }

        typedArray.getString(R.styleable.ProgressLoadingButtonAttr_plb_after_progress_text)?.let {
            afterProgressText = it
        }

        typedArray.getDimension(R.styleable.ProgressLoadingButtonAttr_plb_text_size,20f).let {
            btnTextSize = it
        }

        typedArray.getDimension(R.styleable.ProgressLoadingButtonAttr_plb_text_size,20f).let {
            btnTextSize = it
        }

        typedArray.getInteger(R.styleable.ProgressLoadingButtonAttr_plb_text_gravity,Gravity.CENTER).let {
            textGravity = it
        }

        typedArray.getColor(R.styleable.ProgressLoadingButtonAttr_plb_start_bg_color,Color.BLUE).let {
            startProgressBgColor = it
        }

        typedArray.getColor(R.styleable.ProgressLoadingButtonAttr_plb_progress_color,Color.WHITE).let {
            progressColor = it
        }

         btnTextColor = typedArray.getColor(
            R.styleable.ProgressLoadingButtonAttr_plb_text_color,
            Color.WHITE
        )

        initButtonAttrs()

    }

    private fun initButtonAttrs() {
        //set button text
        buttonTextView?.apply {
            text = beforeProgressText
            textSize = btnTextSize
            gravity = textGravity
            setTextColor(btnTextColor)
        }
        buttonProgressbar?.indeterminateTintList = ColorStateList.valueOf(progressColor)

    }

     fun startProgress( bgColor:Int =startProgressBgColor   ) {

        buttonTextView?.visibility = View.GONE
        buttonProgressbar?.visibility =  View.VISIBLE
        isEnabled = false
         setCardBackgroundColor(bgColor)
         startAnimation()
    }

     fun stopProgress(afterText:String = afterProgressText, bgColor:Int = Color.GREEN ) {

        buttonTextView?.text = afterText
         buttonTextView?.visibility = View.VISIBLE
        buttonProgressbar?.visibility =  View.GONE
        isEnabled = true
         setCardBackgroundColor(bgColor)
         stopAnimation()
    }

    private fun startAnimation()
    {
        val anim = android.view.animation.AnimationUtils.loadAnimation(context,R.anim.fade_in)
        buttonProgressbar?.animation = anim
    }


    private fun stopAnimation()
    {
        val anim = android.view.animation.AnimationUtils.loadAnimation(context,R.anim.fade_out)
        buttonProgressbar?.animation = anim
    }

}