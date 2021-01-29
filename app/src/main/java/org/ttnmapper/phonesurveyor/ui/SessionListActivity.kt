package org.ttnmapper.phonesurveyor.ui

import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.ttnmapper.phonesurveyor.adapters.SessionAdapter
import org.ttnmapper.phonesurveyor.aggregates.AppAggregate
import org.ttnmapper.phonesurveyor.databinding.ActivitySessionListBinding
import org.ttnmapper.phonesurveyor.room.SessionLinkCount
import org.ttnmapper.phonesurveyor.utils.CommonFunctions.Companion.getISO8601StringForDate
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.util.*


class SessionListActivity : AppCompatActivity() {

    private val TAG = SessionListActivity::class.java.getName()

    private lateinit var binding: ActivitySessionListBinding
    private lateinit var sessionAdapter: SessionAdapter

    private var exportSessionId: String? = null

    private val CREATE_REQUEST_CODE = 40
    private val OPEN_REQUEST_CODE = 41
    private val SAVE_REQUEST_CODE = 42

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySessionListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerViewSessionList.setLayoutManager(llm)

        GlobalScope.launch {

            var sessionLinkCounts: List<SessionLinkCount>? = AppAggregate.db?.linkDao()?.getSessions()

            if(sessionLinkCounts == null) {
                sessionLinkCounts = emptyList()
            }

            runOnUiThread{
                binding.textViewNumberSessions.text = "Number of recorded sessions: ${sessionLinkCounts.count()}"
            }

            Log.e(TAG, sessionLinkCounts.toString())
            sessionAdapter = SessionAdapter(sessionLinkCounts, object : SessionRowClickListener {
                override fun onExportClicked(sessionId: String) {
                    Log.e(TAG, "Export clicked for: " + sessionId)
                    exportSession(sessionId)
                }

                override fun onDeleteClicked(sessionId: String) {
                    Log.e(TAG, "Delete clicked for: " + sessionId)
                    confirmAndDeleteSession(sessionId)
                }
            })

            runOnUiThread {
                binding.recyclerViewSessionList.setAdapter(sessionAdapter)
            }
        }

        binding.buttonExportAll.setOnClickListener {
            exportSessionId = null

            val intent = Intent(Intent.ACTION_CREATE_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TITLE, "ttnmapper-all-" + getISO8601StringForDate(Date()) + ".csv")
            startActivityForResult(intent, CREATE_REQUEST_CODE)
        }

        binding.buttonDelete.setOnClickListener {
            confirmAndDeleteAll()
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

    private fun confirmAndDeleteSession(sessionId: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to delete " + sessionId + "?")
                .setCancelable(false)
                .setPositiveButton("Yes") { _, _ ->
                    deleteSession(sessionId)
                }
                .setNegativeButton("No") { dialog, _ ->
                    // Dismiss the dialog
                    dialog.dismiss()
                }
        val alert = builder.create()
        alert.show()
    }

    private fun confirmAndDeleteAll() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to delete all mapping data?")
                .setCancelable(false)
                .setPositiveButton("Yes") { _, _ ->
                    GlobalScope.launch {
                        AppAggregate.db?.linkDao()?.deleteAll()
                        AppAggregate.db?.gatewayDao()?.deleteAll()
                        refreshUi()
                    }
                }
                .setNegativeButton("No") { dialog, _ ->
                    // Dismiss the dialog
                    dialog.dismiss()
                }
        val alert = builder.create()
        alert.show()
    }

    private fun deleteSession(sessionId: String) {

        GlobalScope.launch {
            // Delete session
            AppAggregate.db?.linkDao()?.deleteSession(sessionId)

            refreshUi()
        }
    }

    private fun refreshUi() {

        // Select new total count
        val count = AppAggregate.db?.linkDao()?.getSessionCount()
        runOnUiThread {
            binding.textViewNumberSessions.text = "Number of recorded sessions: " + count.toString()
        }

        // Update list in UI
//        val testList = AppAggregate.db?.linkDao()?.getSessionIDs()
        runOnUiThread {
//            sessionAdapter.updateDataList(testList!!)
        }

    }

    private fun exportSession(sessionId: String) {
        exportSessionId = sessionId

        val intent = Intent(Intent.ACTION_CREATE_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TITLE, "ttnmapper-" + sessionId + ".csv")
        intent.putExtra("sessionId", sessionId)
        startActivityForResult(intent, CREATE_REQUEST_CODE)
    }

    private fun writeFileContent(uri: Uri) {
        try {
            val pfd = this.contentResolver.openFileDescriptor(uri, "w")
            val fileOutputStream = FileOutputStream(pfd!!.fileDescriptor)
            var textContent = ""

            // Columns
            val cursor: Cursor?
            if(exportSessionId == null) {
                cursor = AppAggregate.db?.query("SELECT * FROM link", null)
            } else {
                val bindArgs = arrayOfNulls<Any>(1)
                bindArgs[0] = exportSessionId
                cursor = AppAggregate.db?.query("SELECT * FROM link WHERE session = :sessionId", bindArgs)
            }
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