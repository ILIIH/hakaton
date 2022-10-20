package com.example.servise_reviw_data.factory

import com.example.servise_review_domain.models.userInfo

internal class userInfoFactory {
    fun get(): List<userInfo> =
        listOf(userInfo("Joe", 1, "European", "https://www.linkpicture.com/q/jor_photo.png"), userInfo("Mycola", 1, "Ukrainian", "https://www.linkpicture.com/q/Mycola_1.png"))
}
