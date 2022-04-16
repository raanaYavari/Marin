package com.kasra.marinewebview

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.core.content.ContextCompat

@SuppressLint("SetJavaScriptEnabled")
class MarineWebView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {
    private val webView = WebView(context)

    var callback: (String?) -> Unit = {}

    init {
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        addView(
            webView,
            LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        )
        webView.addJavascriptInterface(JavaScriptInterface(callback = { s ->
            callback(s)
        }), "AndroidFunction");
    }


    fun loadUrl(url: String) {
        webView.loadUrl(url)
    }

    fun callFunction(functionName: String) {
        webView.loadUrl(functionName)
    }


}