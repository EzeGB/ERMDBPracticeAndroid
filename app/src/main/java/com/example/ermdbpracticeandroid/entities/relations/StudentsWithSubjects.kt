package com.example.ermdbpracticeandroid.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.ermdbpracticeandroid.entities.School
import com.example.ermdbpracticeandroid.entities.Student
import com.example.ermdbpracticeandroid.entities.Subject

data class StudentsWithSubjects (
    @Embedded val school: Student,
    @Relation (
        parentColumn = "studentId",
        entityColumn = "subjectId",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subject: List<Subject>
)