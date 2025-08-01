package com.example.ermdbpracticeandroid.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.ermdbpracticeandroid.entities.School
import com.example.ermdbpracticeandroid.entities.Student
import com.example.ermdbpracticeandroid.entities.Subject

data class SubjectsWithStudents (
    @Embedded val subject: Subject,
    @Relation (
        parentColumn = "subjectId",
        entityColumn = "studentId",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>
)