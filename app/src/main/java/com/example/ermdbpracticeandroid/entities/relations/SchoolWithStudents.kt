package com.example.ermdbpracticeandroid.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.ermdbpracticeandroid.entities.School
import com.example.ermdbpracticeandroid.entities.Student

data class SchoolWithStudents (
    @Embedded val school: School,
    @Relation (
        parentColumn = "schoolId",
        entityColumn = "schoolId"
    )
    val students: List<Student>
)