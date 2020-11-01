package com.example.todokotlin.Room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todokotlin.Model.Work
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

 class WorkViewModel(application: Application) : AndroidViewModel(application) {


    private val workRepository: WorkRepository
    val allWorks: LiveData<List<Work>>

    init {
        val worksDao = WorkDatabase.getInstance(application, viewModelScope)?.workDao()
        workRepository = WorkRepository(worksDao!!)
        allWorks = workRepository.allworkes
    }


     fun insert(work: Work) = viewModelScope.launch(Dispatchers.IO) {
        workRepository.insert(work)
    }


     fun update(work: Work)= viewModelScope.launch(Dispatchers.IO) {
        workRepository.update(work)
    }

     fun delete(work: Work)= viewModelScope.launch(Dispatchers.IO) {
        workRepository.delete(work)
    }

     fun deleteallworks()= viewModelScope.launch(Dispatchers.IO) {
        workRepository.deleteallwork()
    }

}