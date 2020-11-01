package com.example.todokotlin.Interface

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todokotlin.Model.Work

@Dao
interface WorkDao  {

    @Insert
    suspend fun insert(work: Work) //insert single data

    @Update
    suspend fun update(work: Work) //update single data

    @Delete
    suspend fun delete(work: Work) //delete single data

    @Query("DELETE FROM work_table")
    suspend fun Deleteallwork() //delete all work

    @Query("SELECT * FROM work_table ORDER BY rating DESC")
    fun getallworks(): LiveData<List<Work>> //showing data


}