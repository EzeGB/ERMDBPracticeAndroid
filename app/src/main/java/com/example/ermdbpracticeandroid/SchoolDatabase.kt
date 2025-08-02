package com.example.ermdbpracticeandroid

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ermdbpracticeandroid.entities.Director
import com.example.ermdbpracticeandroid.entities.School
import com.example.ermdbpracticeandroid.entities.Student
import com.example.ermdbpracticeandroid.entities.Subject
import com.example.ermdbpracticeandroid.entities.relations.StudentSubjectCrossRef

@Database (entities = [
    Director::class,
    School::class,
    Student::class,
    Subject::class,
    StudentSubjectCrossRef::class,
],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase(){
    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile
        private var INSTANCE : SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}