package org.ttnmapper.phonesurveyor.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_request_permissions.*
import org.ttnmapper.phonesurveyor.R

class RequestPermissionsActivity : AppCompatActivity() {

    private val TAG = "PermissionDemo"
    private val RECORD_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_permissions)

        buttonReqPhoneState.setOnClickListener {

        }
    }


}
