package org.ttnmapper.phonesurveyor.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.webkit.*
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_ttn_login.*
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.aggregates.TtnLoginAggregate
import kotlin.concurrent.thread


class TtnLoginActivity : AppCompatActivity() {
    private val TAG = TtnLoginActivity::class.java.getName()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ttn_login)

        if (intent.getBooleanExtra("SHOULD_LOGOUT", false)) {
            clearCookies(this)
        }

        loadLoginPage()
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun loadLoginPage() {
        textViewStatus.visibility = View.GONE
        buttonRetry.visibility = View.GONE
        progressBarLogin.visibility = View.GONE

        TtnLoginAggregate.secretState = java.util.UUID.randomUUID().toString()

        webview_ttn_login.settings.javaScriptEnabled = true


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            webview_ttn_login.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                    val uri = request.url
                    val url = uri.toString()

                    if (url.startsWith(TtnLoginAggregate.redirectURI) == true) {
                        setStatusMessage("Logged in")
                        webview_ttn_login.loadUrl("about:blank")
                        checkCallbackURL(url)
                    } else {
                        view.loadUrl(url)
                    }
                    return false
                }
            }

        } else {

            webview_ttn_login.webViewClient = object : WebViewClient() {
                @Suppress("OverridingDeprecatedMember")
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {

                    if (url.startsWith(TtnLoginAggregate.redirectURI) == true) {
                        setStatusMessage("Logged in")
                        webview_ttn_login.loadUrl("about:blank")
                        checkCallbackURL(url)
                    } else {
                        view.loadUrl(url)
                    }
                    return false
                }
            }

        }

        webview_ttn_login.loadUrl(TtnLoginAggregate.authorizationUrl + "&state=" + TtnLoginAggregate.secretState)
    }

    fun clearCookies(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            CookieManager.getInstance().removeAllCookies(null)
            CookieManager.getInstance().flush()
        } else {
            val cookieSyncMngr = CookieSyncManager.createInstance(context)
            cookieSyncMngr.startSync()
            val cookieManager = CookieManager.getInstance()
            cookieManager.removeAllCookie()
            cookieManager.removeSessionCookie()
            cookieSyncMngr.stopSync()
            cookieSyncMngr.sync()
        }
    }

    fun checkCallbackURL(url: String) {
        //hide web view, show progress norification
        Log.d(TAG, "Redirected: $url")
        webview_ttn_login.visibility = View.GONE

        val textView = findViewById(R.id.textViewStatus) as TextView
        textView.visibility = View.VISIBLE
        textView.text = "Redirected back from TTN login page"

        progressBarLogin.visibility = View.VISIBLE

        val urlAsUri = Uri.parse(url)

        if (urlAsUri.getQueryParameter("state") == null) {
            Log.d(TAG, "Response does not contain a secret state. Please try again.")
            textView.text = "Response does not contain a secret state. Please try again."
            progressBarLogin.visibility = View.GONE
            enableRetryButton()
        } else if (urlAsUri.getQueryParameter("state")?.equals(TtnLoginAggregate.secretState) == false) {
            Log.d(TAG, "Secret state does not match. " + urlAsUri.getQueryParameter("state") + " != " + TtnLoginAggregate.secretState)
            textView.text = "Secret state does not match. Please try again."
            progressBarLogin.visibility = View.GONE
            enableRetryButton()
        } else if (urlAsUri.getQueryParameter("code") == null) {
            Log.d(TAG, "Response does not contain a code. Please try again.")
            textView.text = "Response does not contain a code. Please try again."
            progressBarLogin.visibility = View.GONE
            enableRetryButton()
        } else if (urlAsUri.getQueryParameter("code") == "") {
            Log.d(TAG, "Invalid code in response. Please try again.")
            textView.text = "Invalid code in response. Please try again."
            progressBarLogin.visibility = View.GONE
            enableRetryButton()
        } else {
            Log.d(TAG, "Log in successful. Loading list of application.")

            TtnLoginAggregate.code = urlAsUri.getQueryParameter("code")
            getTokenWithCode()
        }
    }

    fun getTokenWithCode() {
        setStatusMessage("Logged in successfully. Exchanging code for token.")
        thread(start = true) {
            if (TtnLoginAggregate.exchangeCodeForToken()) {
                setStatusMessage("Token received")
                getApplications()
            } else {
                setStatusMessage("Token NOT received")
                enableRetryButton()
            }
        }
    }

    fun getApplications() {
        setStatusMessage("Getting list of your applications.")
        if (TtnLoginAggregate.getListOfApplications()) {
            setStatusMessage("List of Applications retrieved")
            getHandlers()
        } else {
            setStatusMessage("Failed to retrieve applications")
            enableRetryButton()
        }
    }

    fun getHandlers() {
        setStatusMessage("Discovering handlers for all applications.")
        if (TtnLoginAggregate.getHandlers()) {
            setStatusMessage("Handlers retrieved")
            val intent = Intent(this, ApplicationsListActivity::class.java)
            startActivity(intent)
            finish() // Finish this activity so that we can not go back
        } else {
            setStatusMessage("Failed to retrieve handlers from Discovery Server. Is this discovery server blocked on your internet connection?")
            enableRetryButton()
        }
    }

    fun onButtonRetryClicked(v: View) {
        //TODO: clearCookies(this)
        webview_ttn_login.visibility = View.VISIBLE
        textViewStatus.visibility = View.GONE
        progressBarLogin.visibility = View.GONE
        buttonRetry.visibility = View.GONE
        loadLoginPage()
    }

    fun setStatusMessage(status: String) {
        runOnUiThread {
            webview_ttn_login.visibility = View.GONE
            textViewStatus.visibility = View.VISIBLE
            textViewStatus.text = status
            Log.d(TAG, status)
        }
    }

    fun enableRetryButton() {
        runOnUiThread {
            buttonRetry.setOnClickListener { onButtonRetryClicked(it) }
            buttonRetry.visibility = View.VISIBLE
            progressBarLogin.visibility = View.GONE
        }
    }
}
