package com.shashifreeze.progressbutton

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.card.MaterialCardView

class ProgressButton @JvmOverloads constructor(
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
    private var onProgressText = "Please wait..."
    private var afterProgressText = "Done"
    private var btnTextSize = 0f
    private var textGravity = 0
    private var btnTextColor = Color.WHITE
    private var startProgressBgColor = Color.BLUE

    init {

        LayoutInflater.from(getContext()).inflate(R.layout.progress_button_layout, this, true)
        buttonTextView = findViewById(R.id.buttonText)
        buttonProgressbar = findViewById(R.id.buttonProgress)
       // buttonCardViewLayout = findViewById(R.id.buttonCardViewLayout)

        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ProgressButtonAttr,
            defStyleAttr,
            defStyleAttr
        )

        typedArray.getString(R.styleable.ProgressButtonAttr_pb_before_progress_text)?.let {
            beforeProgressText = it
        }

        typedArray.getString(R.styleable.ProgressButtonAttr_pb_after_progress_text)?.let {
            afterProgressText = it
        }

        typedArray.getString(R.styleable.ProgressButtonAttr_pb_on_progress_text)?.let {
            onProgressText = it
        }

        typedArray.getDimension(R.styleable.ProgressButtonAttr_pb_text_size,20f).let {
            btnTextSize = it
        }

        typedArray.getDimension(R.styleable.ProgressButtonAttr_pb_text_size,20f).let {
            btnTextSize = it
        }

        typedArray.getInteger(R.styleable.ProgressButtonAttr_pb_text_gravity,Gravity.CENTER).let {
            textGravity = it
        }

        typedArray.getColor(R.styleable.ProgressButtonAttr_pb_start_bg_color,Color.BLUE).let {
            startProgressBgColor = it
        }

        typedArray.getColor(R.styleable.ProgressButtonAttr_pb_progress_color,Color.WHITE).let {
            progressColor = it
        }

         btnTextColor = typedArray.getColor(
            R.styleable.ProgressButtonAttr_pb_text_color,
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

     fun startProgress(progressText:String = onProgressText, bgColor:Int =startProgressBgColor   ) {

        buttonTextView?.text = progressText
        buttonProgressbar?.visibility =  View.VISIBLE
        isEnabled = false
         setCardBackgroundColor(bgColor)
    }

     fun stopProgress(afterText:String = afterProgressText, bgColor:Int = Color.GREEN ) {

        buttonTextView?.text = afterText
        buttonProgressbar?.visibility =  View.GONE
        isEnabled = true
         setCardBackgroundColor(bgColor)

    }

}