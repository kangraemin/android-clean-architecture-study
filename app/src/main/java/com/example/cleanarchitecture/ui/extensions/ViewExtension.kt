package com.example.cleanarchitecture.ui.extensions

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View


fun View.getBitmapFromView(backgroundColor: Int): Bitmap? {
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    canvas.drawColor(backgroundColor)
    draw(canvas)
    return bitmap
}