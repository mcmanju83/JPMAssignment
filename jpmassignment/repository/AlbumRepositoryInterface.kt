package com.mcm.jpmassignment.repository

import com.mcm.jpmassignment.model.Albums

interface AlbumRepositoryInterface {
    suspend fun getTitles(): List<Albums>
}
