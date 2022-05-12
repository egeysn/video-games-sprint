package com.egeysn.video_games_sprint.utils

import android.text.TextUtils
import org.joda.time.DateTime
import org.joda.time.DateTimeZone

fun String.toReleaseDate(): String {
    if (!TextUtils.isEmpty(this)) {
        val dt = DateTime(this, DateTimeZone.getDefault())
        return try {
            return dt.toString("d MMMM yyyy")
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }
    return ""
}
