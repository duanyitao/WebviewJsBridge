package com.fcbox.webviewjs

import android.os.Bundle
import android.webkit.JavascriptInterface
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webview.settings.javaScriptEnabled = true
        webview.addJavascriptInterface(this, "interface")
        webview.loadUrl("file:///android_asset/index.html")

        bt.setOnClickListener {
            webview.loadUrl("javascript:if(window.remote){window.remote('${et.text}')}")
        }
    }

    @JavascriptInterface
    fun setValue(value: String) {
        runOnUiThread { tv.text = value }
    }
}
