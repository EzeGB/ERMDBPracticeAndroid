package com.example.ermdbpracticeandroid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.ermdbpracticeandroid.entities.Director
import com.example.ermdbpracticeandroid.entities.Student
import com.example.ermdbpracticeandroid.entities.School
import com.example.ermdbpracticeandroid.entities.Subject
import com.example.ermdbpracticeandroid.entities.relations.StudentSubjectCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dao = SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf(
            Director(1, 1, "Mike Litoris"),
            Director(2, 2, "Jack Goff"),
            Director(3, 3, "Chris P. Chicken")
        )
        val schools = listOf(
            School(1, "Jake Wharton School"),
            School(2, "Kotlin School"),
            School(3, "JetBrains School")
        )
        val subjects = listOf(
            Subject(1, "Dating for programmers"),
            Subject(2, "Avoiding depression"),
            Subject(3, "Bug Fix Meditation"),
            Subject(4, "Logcat for Newbies"),
            Subject(5, "How to use Google")
        )
        val students = listOf(
            Student(1, 2, "Beff Jezos", 2),
            Student(2, 1, "Mark Suckerberg", 5),
            Student(3, 2, "Gill Bates", 8),
            Student(4, 2, "Donny Jepp", 1),
            Student(5, 3, "Hom Tanks", 2)
        )
        val studentSubjectRelations = listOf(
            StudentSubjectCrossRef(1, 1),
            StudentSubjectCrossRef(1, 2),
            StudentSubjectCrossRef(1, 3),
            StudentSubjectCrossRef(1, 4),
            StudentSubjectCrossRef(2, 1),
            StudentSubjectCrossRef(3, 5),
            StudentSubjectCrossRef(4, 4),
            StudentSubjectCrossRef(5, 2),
            StudentSubjectCrossRef(5, 1)
        )
        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it) }
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            students.forEach { dao.insertStudent(it) }
            studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }

            val schoolWithDirector = dao.getSchoolAndDirectorWithSchoolName("Kotlin School")
            schoolWithDirector.first().director
            val schoolWithStudents = dao.getSchoolWithStudents("Kotlin School")
            schoolWithStudents.first().students
        }
    }
}