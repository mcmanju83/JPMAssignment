package com.mcm.jpmassignment.repository

import com.mcm.jpmassignment.model.Albums
import com.mcm.jpmassignment.network.APIServices

class AlbumRepository : AlbumRepositoryInterface {
    override suspend fun getTitles(): List<Albums> {
        return APIServices.create().getTitles()
    }
}
