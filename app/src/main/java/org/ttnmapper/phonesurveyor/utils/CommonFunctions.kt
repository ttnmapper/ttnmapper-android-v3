package org.ttnmapper.phonesurveyor.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.util.Log
import org.ttnmapper.phonesurveyor.SurveyorApp
import java.text.SimpleDateFormat
import java.util.*


class CommonFunctions {

    companion object {
        private val TAG = CommonFunctions::class.java.getName()

        fun getColorForSignal(level: Double): Long {

            if (level == 0.0) {
                return 0x7f000000
            } else if (level > -100) {
                return 0x7fff0000
            } else if (level > -105) {
                return 0x7fff7f00
            } else if (level > -110) {
                return 0x7fffff00
            } else if (level > -115) {
                return 0x7f00ff00
            } else if (level > -120) {
                return 0x7f00ffff;
            } else if (level > -140) {
                return 0x7f0000ff;
            } else {
                return 0x7f000000
            }

        }

        fun getISO8601StringForDate(date: Date): String {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"))
            return dateFormat.format(date)
        }

        fun sanitiseMqttUri(handler: String): String {
            var mqttUri = handler

            // Assume a handler name will never contain a dot
            if (!mqttUri.contains(".")) {
                mqttUri = mqttUri + ".thethings.network"
            }

            if (mqttUri.startsWith("mqtt://")) {
                mqttUri = mqttUri.substring(7)
            }

            if (mqttUri.startsWith("mqtts://")) {
                mqttUri = mqttUri.substring(8)
            }

            if (!mqttUri.startsWith("tcp://")) {
                mqttUri = "tcp://" + mqttUri
            }

            return mqttUri
        }

        fun scanFile(path: String) {

            MediaScannerConnection.scanFile(SurveyorApp.instance,
                    arrayOf(path), null,
                    object : MediaScannerConnection.OnScanCompletedListener {

                        override fun onScanCompleted(path: String, uri: Uri) {
                            Log.i(TAG, "Finished scanning $path")
                        }
                    })
        }

        fun getBitmapFromVectorDrawable(context: Context, drawableId: Int): Bitmap {
            var drawable = ContextCompat.getDrawable(context, drawableId)
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                drawable = DrawableCompat.wrap(drawable!!).mutate()
            }

            val bitmap = Bitmap.createBitmap(drawable!!.intrinsicWidth,
                    drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight())
            drawable.draw(canvas)

            return bitmap
        }

    }
}