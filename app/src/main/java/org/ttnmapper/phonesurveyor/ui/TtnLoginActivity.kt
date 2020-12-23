package org.ttnmapper.phonesurveyor.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.aggregates.TtnLoginAggregate
import org.ttnmapper.phonesurveyor.databinding.ActivityTtnLoginBinding
import java.util.*
import kotlin.concurrent.thread


class TtnLoginActivity : AppCompatActivity() {
    private val TAG = TtnLoginActivity::class.java.getName()

    private lateinit var binding: ActivityTtnLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTtnLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (intent.getBooleanExtra("SHOULD_LOGOUT", false)) {
            clearCookies(this)
        }

        loadLoginPage()
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun loadLoginPage() {
        binding.textViewStatus.visibility = View.GONE
        binding.buttonRetry.visibility = View.GONE
        binding.progressBarLogin.visibility = View.GONE

        TtnLoginAggregate.secretState = UUID.randomUUID().toString()

        binding.webviewTtnLogin.settings.javaScriptEnabled = true


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            binding.webviewTtnLogin.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                    val uri = request.url
                    val url = uri.toString()

                    if (url.startsWith(TtnLoginAggregate.redirectURI) == true) {
                        setStatusMessage("Logged in")
                        binding.webviewTtnLogin.loadUrl("about:blank")
                        checkCallbackURL(url)
                    } else {
                        view.loadUrl(url)
                    }
                    return false
                }
            }

        } else {

            binding.webviewTtnLogin.webViewClient = object : WebViewClient() {
                @Suppress("OverridingDeprecatedMember")
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {

                    if (url.startsWith(TtnLoginAggregate.redirectURI) == true) {
                        setStatusMessage("Logged in")
                        binding.webviewTtnLogin.loadUrl("about:blank")
                        checkCallbackURL(url)
                    } else {
                        view.loadUrl(url)
                    }
                    return false
                }
            }

        }

        binding.webviewTtnLogin.loadUrl(TtnLoginAggregate.authorizationUrl + "&state=" + TtnLoginAggregate.secretState)
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
        binding.webviewTtnLogin.visibility = View.GONE

        binding.textViewStatus.visibility = View.VISIBLE
        binding.textViewStatus.text = "Redirected back from TTN login page"

        binding.progressBarLogin.visibility = View.VISIBLE

        val urlAsUri = Uri.parse(url)

        if (urlAsUri.getQueryParameter("state") == null) {
            Log.d(TAG, "Response does not contain a secret state. Please try again.")
            binding.textViewStatus.text = "Response does not contain a secret state. Please try again."
            binding.progressBarLogin.visibility = View.GONE
            enableRetryButton()
        } else if (urlAsUri.getQueryParameter("state")?.equals(TtnLoginAggregate.secretState) == false) {
            Log.d(TAG, "Secret state does not match. " + urlAsUri.getQueryParameter("state") + " != " + TtnLoginAggregate.secretState)
            binding.textViewStatus.text = "Secret state does not match. Please try again."
            binding.progressBarLogin.visibility = View.GONE
            enableRetryButton()
        } else if (urlAsUri.getQueryParameter("code") == null) {
            Log.d(TAG, "Response does not contain a code. Please try again.")
            binding.textViewStatus.text = "Response does not contain a code. Please try again."
            binding.progressBarLogin.visibility = View.GONE
            enableRetryButton()
        } else if (urlAsUri.getQueryParameter("code") == "") {
            Log.d(TAG, "Invalid code in response. Please try again.")
            binding.textViewStatus.text = "Invalid code in response. Please try again."
            binding.progressBarLogin.visibility = View.GONE
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
        binding.webviewTtnLogin.visibility = View.VISIBLE
        binding.textViewStatus.visibility = View.GONE
        binding.progressBarLogin.visibility = View.GONE
        binding.buttonRetry.visibility = View.GONE
        loadLoginPage()
    }

    fun setStatusMessage(status: String) {
        runOnUiThread {
            binding.webviewTtnLogin.visibility = View.GONE
            binding.textViewStatus.visibility = View.VISIBLE
            binding.textViewStatus.text = status
            Log.d(TAG, status)
        }
    }

    fun enableRetryButton() {
        runOnUiThread {
            binding.buttonRetry.setOnClickListener { onButtonRetryClicked(it) }
            binding.buttonRetry.visibility = View.VISIBLE
            binding.progressBarLogin.visibility = View.GONE
        }
    }
}
