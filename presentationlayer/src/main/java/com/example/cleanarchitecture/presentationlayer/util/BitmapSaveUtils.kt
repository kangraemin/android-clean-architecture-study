package com.example.cleanarchitecture.presentationlayer.util

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.presentationlayer.ui.extensions.getBackgroundColor
import com.example.cleanarchitecture.presentationlayer.ui.extensions.getBitmapFromView
import java.io.IOException
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

object BitmapSaveUtils {
    interface SaveImageCallBack {
        fun onSuccess()
        fun onFail()
    }

    @Throws(IOException::class)
    private fun saveCapturedImage(activity: Activity, capturedView: View) {
        capturedView.getBitmapFromView(activity.getBackgroundColor())?.run {
            saveBitmap(
                activity,
                this,
                extractImageFileName(activity, Instant.now())
            )
        }
    }

    fun saveImageForBackgroundOfView(activity: Activity, capturedView: View, callBack: SaveImageCallBack) {
        if (hasPermissionToSaveImage(activity)) {
            try {
                saveCapturedImage(activity, capturedView)
                callBack.onSuccess()
            } catch (e: IOException) {
                callBack.onFail()
            }
        } else {
            requestPermissionToSaveImage(activity)
        }
    }

    private fun requestPermissionToSaveImage(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            PERMISSIONS_REQUEST_SAVE_PICTURE
        )
    }

    private fun hasPermissionToSaveImage(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun extractImageFileName(context: Context, instant: Instant): String {
        val date = Date(instant.toEpochMilli())
        val sdf = SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA)
        return String.format(context.getString(R.string.main_saved_image_name_format), sdf.format(date))
    }

    // https://stackoverflow.com/a/56990305
    private fun saveBitmap(context: Context, bitmap: Bitmap, displayName: String) {
        val values = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, displayName)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/*")
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DCIM)
        }
        val resolver = context.contentResolver
        var uri: Uri? = null
        try {
            uri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
                ?: throw IOException("Failed to create new MediaStore record.")
            resolver.openOutputStream(uri)?.use {
                if (!bitmap.compress(Bitmap.CompressFormat.JPEG, 95, it))
                    throw IOException("Failed to save bitmap.")
            } ?: throw IOException("Failed to open output stream.")
        } catch (e: IOException) {
            uri?.let { orphanUri ->
                // Don't leave an orphan entry in the MediaStore
                resolver.delete(orphanUri, null, null)
            }
            throw e
        }
    }

    const val PERMISSIONS_REQUEST_SAVE_PICTURE = 1
}