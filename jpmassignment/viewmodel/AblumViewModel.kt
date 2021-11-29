package com.mcm.jpmassignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mcm.jpmassignment.repository.AlbumRepository

class AblumViewModel : ViewModel() {
    var albumRepository: AlbumRepository = AlbumRepository()
    fun getTitles() = liveData {
        try {
            val response = albumRepository.getTitles()
            emit(Result.success(response))
        } catch (cause: Throwable) {
            emit(Result.failure(cause))
        }
    }
}
