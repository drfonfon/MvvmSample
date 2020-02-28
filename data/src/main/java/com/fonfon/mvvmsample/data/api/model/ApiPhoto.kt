package com.fonfon.mvvmsample.data.api.model

class ApiPhoto(
    val albumId: Int = 1,
    val id: Int = 1,
    val title: String = "",
    val url: String = "",
    val thumbnailUrl: String = ""
): ApiObject()