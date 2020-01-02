package com.timgeldof.gustfinder.screens.news

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient

import com.timgeldof.gustfinder.databinding.FragmentNewsBinding

/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : Fragment() {

    private val SURF_URL = "https://www.worldsurfleague.com/"
    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentNewsBinding.inflate(inflater, container, false)
        webView = binding.surfNews
        setUpWebView(webView)
        return binding.root
    }

    /**
     *  Sets up the webview for surfing through the surfline news website
     *  It also overrides the default keyevent for the back button to go back in the webview instead of going back in the back stack
     *  In a main activity we can simply override OnBackPressed, however we are dealing with a Fragment context
     *
     *  @param webView the [WebView] of the news binding object
     */
    private fun setUpWebView(webView: WebView) {
        webView.webViewClient = WebViewClient()
        webView.loadUrl(SURF_URL)
        webView.settings.domStorageEnabled = true
        webView.settings.javaScriptEnabled = true

        webView.setOnKeyListener(View.OnKeyListener() { _: View, keyCode: Int, event: KeyEvent ->
            var returnValue = false
            if (event.getAction() != KeyEvent.ACTION_DOWN)
                returnValue = true
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    activity!!.onBackPressed()
                }
                returnValue = true
            }
            returnValue
        })
    }
}
