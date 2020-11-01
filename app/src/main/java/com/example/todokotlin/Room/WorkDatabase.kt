package com.example.todokotlin.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.todokotlin.Interface.WorkDao
import com.example.todokotlin.Model.Work
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Work::class], version = 1, exportSchema = false)
abstract class WorkDatabase : RoomDatabase() {

    abstract fun workDao(): WorkDao

    companion object {
        @Volatile
        private var instance: WorkDatabase? = null

        @Synchronized
        fun getInstance(context: Context, scope: CoroutineScope): WorkDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    WorkDatabase::class.java, "work_database"
                )

                    .fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
            }
            return instance
        }

        private class WordDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                instance?.let { database ->
                    scope.launch(Dispatchers.IO) {

                        populateDatabase(database.workDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(workDao: WorkDao) {
            workDao.Deleteallwork()
            workDao.insert(Work("project Work", "11/1/2020", "4:27 PM", 4.0f, true))
            workDao.insert(Work("English Class Work", "11/2/2020", "4:27 PM", 3.0f, false))
        }
    }
}