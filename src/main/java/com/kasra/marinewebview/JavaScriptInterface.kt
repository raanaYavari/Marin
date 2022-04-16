package com.kasra.marinewebview

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast


class JavaScriptInterface constructor(private val callback: (String?) -> Unit) {

    @JavascriptInterface
    fun showToast(s: String?) {
        this.callback(s)
    }
}