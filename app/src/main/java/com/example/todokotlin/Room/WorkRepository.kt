package com.example.todokotlin.Room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.todokotlin.Interface.WorkDao
import com.example.todokotlin.Model.Work

class WorkRepository(private val workDao: WorkDao) {

    val allworkes: LiveData<List<Work>> = workDao.getallworks()

    @WorkerThread
    suspend fun insert(work: Work) {
        workDao.insert(work)
    }

    @WorkerThread
    suspend fun update(work: Work) {
        workDao.update(work)
    }

    @WorkerThread
    suspend fun delete(work: Work) {
        workDao.delete(work)
    }

    @WorkerThread
    suspend fun deleteallwork() {
        workDao.Deleteallwork()
    }

}