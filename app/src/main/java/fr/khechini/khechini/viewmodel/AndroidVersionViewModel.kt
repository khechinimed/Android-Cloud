package fr.khechini.khechini.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.khechini.khechini.model.MyObjectForRecyclerView
import fr.khechini.khechini.repository.AndroidVersionRepository

class AndroidVersionViewModel : ViewModel() {

    private val androidVersionRepository: AndroidVersionRepository by lazy { AndroidVersionRepository() }
    private val _androidVersionList = MutableLiveData<List<MyObjectForRecyclerView>>()
    val androidVersionList: LiveData<List<MyObjectForRecyclerView>> get() = _androidVersionList

    init {
        _androidVersionList.postValue(androidVersionRepository.generateFakeData())
    }
}