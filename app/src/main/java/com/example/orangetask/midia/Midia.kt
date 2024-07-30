package com.example.orangetask.midia

import android.content.Context
import android.provider.MediaStore


fun Context.getAllImages(onLoadImages: (List<Pair<String, String>>) -> Unit) {
    val images = mutableListOf<Pair<String, String>>()

    val projection = arrayOf(
        MediaStore.Images.Media.DISPLAY_NAME,
        MediaStore.Images.Media.DATA
    )
    val selection = null
    val selectionArgs = null
    val sortOrder = null

    contentResolver.query(
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        projection,
        selection,
        selectionArgs,
        sortOrder
    )?.use { cursor ->
        while (cursor.moveToNext()) {
            val nameIndex =
                cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
            val name: String = cursor.getString(nameIndex)

            val pathIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            val path = cursor.getString(pathIndex)

            images.add(Pair(name, path))
        }
        onLoadImages(images)
    }
}
