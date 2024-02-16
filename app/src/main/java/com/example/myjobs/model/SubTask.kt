package com.example.myjobs.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class SubTask(
    val id: Int? = null,
    val idTask: Int? = null,
    val title: String? = null,
    var isComplete: Boolean = false
): Parcelable
