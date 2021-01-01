package org.ttnmapper.phonesurveyor.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import org.ttnmapper.phonesurveyor.model.ttnV2.GatewayMetadata
import org.ttnmapper.phonesurveyor.model.ttnV2.TtnUplinkMessage
import org.ttnmapper.phonesurveyor.room.Link
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.OffsetDateTime
import java.util.*
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty
import kotlin.reflect.full.isSupertypeOf
import kotlin.reflect.full.memberProperties


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

        fun getISO8601StringForMillis(millis: Long): String {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"))

            val date = Date(millis)
            return dateFormat.format(date)
        }

        fun getDateForISO8601String(iso: String): Date {
            val offsetDateTime: OffsetDateTime = OffsetDateTime.parse(iso) // default is iso format
            return Date.from(Instant.from(offsetDateTime))
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

        fun <T : Any, R : Any> T.copyPropsFrom(fromObject: R, vararg props: KProperty<*>) {
            // only consider mutable properties
            val mutableProps = this::class.memberProperties.filterIsInstance<KMutableProperty<*>>()
            // if source list is provided use that otherwise use all available properties
            val sourceProps = if (props.isEmpty()) fromObject::class.memberProperties else props.toList()
            // copy all matching
            mutableProps.forEach { targetProp ->
                sourceProps.find {
                    // make sure properties have same name and compatible types
                    it.name == targetProp.name && targetProp.returnType.isSupertypeOf(it.returnType)
                }?.let { matchingProp ->
                    targetProp.setter.call(this, matchingProp.getter.call(fromObject))
                }
            }
        }

    }
}