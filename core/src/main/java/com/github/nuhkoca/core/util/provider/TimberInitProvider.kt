package com.github.nuhkoca.core.util.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import com.github.ajalt.timberkt.Timber
import timber.log.Timber.DebugTree

class TimberInitProvider : ContentProvider() {

    override fun insert(p0: Uri, p1: ContentValues?): Uri? = null

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        throw UnsupportedOperationException("Not Implemented Yet")
    }

    override fun onCreate(): Boolean {
        Timber.uprootAll()
        Timber.plant(DebugTree())
        return true
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        throw UnsupportedOperationException("Not Implemented Yet")
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        throw UnsupportedOperationException("Not Implemented Yet")
    }

    override fun getType(p0: Uri): String? {
        throw UnsupportedOperationException("Not Implemented Yet")
    }
}
