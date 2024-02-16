package com.example.myjobs.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Task(
    val mainTask: MainTask? = null,
    val subtasks:  List<SubTask>? = null
): Parcelable
