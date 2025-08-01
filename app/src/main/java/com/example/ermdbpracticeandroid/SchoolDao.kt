package com.example.ermdbpracticeandroid

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.ermdbpracticeandroid.entities.Director
import com.example.ermdbpracticeandroid.entities.School
import com.example.ermdbpracticeandroid.entities.Student
import com.example.ermdbpracticeandroid.entities.Subject
import com.example.ermdbpracticeandroid.entities.relations.SchoolAndDirector
import com.example.ermdbpracticeandroid.entities.relations.SchoolWithStudents
import com.example.ermdbpracticeandroid.entities.relations.StudentSubjectCrossRef
import com.example.ermdbpracticeandroid.entities.relations.StudentsWithSubjects
import com.example.ermdbpracticeandroid.entities.relations.SubjectsWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(studentSubjectCrossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String) : List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String) : List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun getSubjectsOfStudent(studentName: String) : List<StudentsWithSubjects>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName = :subjectName")
    suspend fun getStudentOfSubjects(subjectName: String) : List<SubjectsWithStudents>
}