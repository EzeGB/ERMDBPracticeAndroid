package com.example.ermdbpracticeandroid.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.ermdbpracticeandroid.entities.Director
import com.example.ermdbpracticeandroid.entities.School

data class SchoolAndDirector (
    @Embedded val school: School,
    @Relation (
        parentColumn = "schoolId",
        entityColumn = "schoolId"
    )
    val director: Director
)