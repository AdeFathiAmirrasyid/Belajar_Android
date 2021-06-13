package com.fathi.wisatacirebon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class PortalWisata : AppCompatActivity() {

    lateinit var Webview : WebView
    lateinit var swipe : SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portal_wisata)

        swipe   = findViewById(R.id.swipe) as SwipeRefreshLayout

        swipe.setOnRefreshListener {
            WebAction()
        }
    }

fun  WebAction(){
    Webview = findViewById(R.id.webview) as WebView
    Webview.loadUrl("http://www.jejakpiknik.com")
    swipe.isRefreshing = true

    Webview.webViewClient = object : WebViewClient(){
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            swipe.isRefreshing = false
        }
    }
}
}
