package com.example.todokotlin.Model

import android.media.Rating
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "work_table")
data class Work(
    var event_name: String?,
    var date: String?,
    var due_time: String?,
    var rating: Float?,
    var isCom: Boolean?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}