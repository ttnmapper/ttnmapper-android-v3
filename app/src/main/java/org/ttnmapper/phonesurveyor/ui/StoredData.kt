package org.ttnmapper.phonesurveyor.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.ttnmapper.phonesurveyor.aggregates.AppAggregate
import org.ttnmapper.phonesurveyor.databinding.ActivityStoredDataBinding
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.getISO8601StringForDate
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.util.*


class StoredData : AppCompatActivity() {

    private val TAG = StoredData::class.java.getName()

    private lateinit var binding: ActivityStoredDataBinding

    private val CREATE_REQUEST_CODE = 40
    private val OPEN_REQUEST_CODE = 41
    private val SAVE_REQUEST_CODE = 42

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoredDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        GlobalScope.launch {
            val count = AppAggregate.db?.linkDao()?.getCount()
            binding.textViewNumberPoints.text = "Number of points in storage: "+count.toString()
        }

        binding.buttonExportAll.setOnClickListener {
            val intent = Intent(Intent.ACTION_CREATE_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TITLE, "ttnmapper-"+getISO8601StringForDate(Date())+".csv")
            startActivityForResult(intent, CREATE_REQUEST_CODE)
        }

        binding.buttonDelete.setOnClickListener {
            GlobalScope.launch {
                AppAggregate.db?.linkDao()?.deleteAll()
                AppAggregate.db?.gatewayDao()?.deleteAll()
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int,
                                  resultData: Intent?) {
        super.onActivityResult(requestCode, resultCode, resultData)
        if (resultCode == RESULT_OK) {
            if (requestCode == CREATE_REQUEST_CODE) {
                if (resultData != null) {
                    var currentUri = resultData.getData();
                    Log.e(TAG, "File created: " + currentUri)
                    writeFileContent(currentUri!!)
                }
            }
        }
    }

    private fun writeFileContent(uri: Uri) {
        try {
            val pfd = this.contentResolver.openFileDescriptor(uri, "w")
            val fileOutputStream = FileOutputStream(pfd!!.fileDescriptor)
            var textContent = ""

            // Columns
            val cursor = AppAggregate.db?.query("SELECT * FROM link", null);
            val columns = cursor?.getColumnNames()
            columns?.forEach {
                textContent += it.toString() + ","
            }
            textContent.dropLast(1)
            textContent += "\n"

            while (cursor!!.moveToNext()) {
                var line = ""
                for (i in 0 until cursor.getColumnCount() - 1) {
                     line += cursor.getString(i) + ","
                }
                line.dropLast(1)
                textContent += line + "\n"
            }

            fileOutputStream.write(textContent.toByteArray())
            fileOutputStream.close()
            pfd.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}