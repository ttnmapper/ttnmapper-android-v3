package org.ttnmapper.phonesurveyor.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.ttnmapper.phonesurveyor.R
import org.ttnmapper.phonesurveyor.databinding.ActivityLinkSelectNetworkBinding


class LinkSelectNetworkActivity : AppCompatActivity() {

    private val TAG = LinkSelectNetworkActivity::class.java.getName()

    private lateinit var binding: ActivityLinkSelectNetworkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLinkSelectNetworkBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonTtnV2.setOnClickListener {
            val intent = Intent(this, LinkTtnV2Activity::class.java)
            startActivity(intent)
            finish()
        }

        binding.buttonTtsV3.setOnClickListener {
            val intent = Intent(this, LinkTtsV3Activity::class.java)
            startActivity(intent)
            finish()
        }

        binding.buttonChirp.setOnClickListener {
            val intent = Intent(this, LinkChirpActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.buttonPatreon.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(getString(R.string.PATREON_URL))
            startActivity(i)
        }

        binding.buttonPaypal.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(getString(R.string.PAYPAL_URL))
            startActivity(i)
        }
    }
}