package com.example.ermdbpracticeandroid.entities.relations

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ermdbpracticeandroid.entities.Student
import com.example.ermdbpracticeandroid.entities.Subject

@Entity(primaryKeys = ["studentId","subjectId"])
data class StudentSubjectCrossRef (
    val studentId: Int,
    val subjectId: Int
)