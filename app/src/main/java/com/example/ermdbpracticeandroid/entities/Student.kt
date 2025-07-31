package com.example.ermdbpracticeandroid.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey (autoGenerate = true)
    val studentId: Int,
    val schoolId: Int,
    val studentName: String,
    val semester: Int
)