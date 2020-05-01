package com.example.ramdantraining.custom

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.ramdantraining.R

class CustomImageWithTitle(context: Context, attrs: AttributeSet): ConstraintLayout(context, attrs) {

    init {
        inflate(context, R.layout.custom_image_with_title, this)

//        val imageView: ImageView = findViewById(R.id.iv_camera)
//        val textView: TextView = findViewById(R.id.tv_btnTitle)
//
//        val attributes = context.obtainStyledAttributes(attrs, R.styleable.custom_view)
//        imageView.setImageDrawable(attributes.getDrawable(R.styleable.custom_view_image))
//        textView.text = attributes.getString(R.styleable.custom_view_text)
//        attributes.recycle()

    }
}