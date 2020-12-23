package org.ttnmapper.phonesurveyor.utils

import android.content.Context
import android.os.Build
import androidx.preference.Preference
import android.util.AttributeSet

class VersionPreference(context: Context, attrs: AttributeSet) : Preference(context, attrs) {

    init {
        var versionName = ""
        var versionCode = ""
        val packageManager = context.packageManager
        if (packageManager != null) {
            try {
                val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
                versionName = packageInfo.versionName

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    versionCode = packageInfo.longVersionCode.toString()
                } else {
                    versionCode = packageInfo.versionCode.toString()
                }
            } catch (e: Exception) {
                versionName = ""
            }
            summary = "$versionName (build $versionCode)"
        }
    }
}