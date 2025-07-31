package com.example.ermdbpracticeandroid

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.ermdbpracticeandroid.entities.Director
import com.example.ermdbpracticeandroid.entities.School
import com.example.ermdbpracticeandroid.entities.Student
import com.example.ermdbpracticeandroid.entities.relations.SchoolAndDirector
import com.example.ermdbpracticeandroid.entities.relations.SchoolWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String) : List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String) : List<SchoolWithStudents>
}