package org.ttnmapper.phonesurveyor.ui

interface SessionRowClickListener {
        fun onExportClicked(sessionId: String)
        fun onDeleteClicked(sessionId: String)
}