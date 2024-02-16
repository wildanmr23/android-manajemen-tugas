package com.example.myjobs.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MainTask(
    val id: Int? = null,
    val title: String? = null,
    val details: String? = null,
    val date: Int? = null,
    val isComplete: Boolean = false
): Parcelable
