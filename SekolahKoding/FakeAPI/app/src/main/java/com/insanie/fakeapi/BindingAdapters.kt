package com.insanie.fakeapi

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("showImage")
fun showImage(imgView : ImageView,url: String?){
    Glide.with(imgView.context)
        .load(url)
        .into(imgView);
}
@BindingAdapter("LoadStatus")
fun LoadStatus(textView: TextView,status:String?){
    if (status == "Ok"){
        textView.visibility = View.GONE
    }
}