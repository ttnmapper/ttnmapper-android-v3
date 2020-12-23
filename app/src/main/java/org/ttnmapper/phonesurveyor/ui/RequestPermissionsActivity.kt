package org.ttnmapper.phonesurveyor.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.ttnmapper.phonesurveyor.databinding.ActivityRequestPermissionsBinding

class RequestPermissionsActivity : AppCompatActivity() {

    private val TAG = "PermissionDemo"

    private lateinit var binding: ActivityRequestPermissionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestPermissionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonReqPhoneState.setOnClickListener {

        }
    }


}
