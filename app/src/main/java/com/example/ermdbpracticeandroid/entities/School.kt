package com.example.ermdbpracticeandroid.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class School(
    @PrimaryKey (autoGenerate = true)
    val schoolId: Int,
    val schoolName: String
)