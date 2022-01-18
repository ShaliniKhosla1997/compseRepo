package com.example.login

import android.webkit.WebView
import android.app.ProgressDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.example.login.R
import android.webkit.WebSettings
import com.example.login.CustomWebView.WebViewClientimpl
import android.webkit.WebViewClient
import android.webkit.WebResourceRequest
import android.graphics.Bitmap
import android.view.View
import androidx.fragment.app.Fragment

class CustomWebView : Fragment() {
    var mWebView: WebView? = null
    private var progDailog: ProgressDialog? = null
    private var url: String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        url = requireArguments().getString("url")
        progDailog = ProgressDialog.show(activity, "Loading", "Please wait...", true)
        progDailog!!.setCancelable(false)
        mWebView = mWebView!!.findViewById<View>(R.id.webView) as WebView


        // Enable Javascript
        val webSettings = mWebView!!.settings
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        mWebView!!.loadUrl(url!!)
        // Force links and redirects to open in the WebView instead of in a browser
        mWebView!!.webViewClient = WebViewClientimpl()

        return inflater.inflate(R.layout.custom_webview, container, false)
    }

    internal inner class WebViewClientimpl : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            progDailog!!.show()
            view.loadUrl(request.url.toString())
            return true
        }

        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
        }
    }
}