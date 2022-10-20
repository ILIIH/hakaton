package com.uaref.factory

import com.uaref.model.European

internal class EuropeansFactory {
    fun get(): List<European> {
        return listOf(
            European(
                1,
                "https://www.linkpicture.com/q/jor_photo.png",
                "Joe",
                "English"
            ),
            European(
                1,
                "https://www.linkpicture.com/q/jor_photo.png",
                "Joe",
                "English"
            )
        )
    }
}
