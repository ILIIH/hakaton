package com.uaref.factory

import com.uaref.model.Ukrainian

internal class UkrainiansFactory {
    fun get(): List<Ukrainian> {
        return listOf(
            Ukrainian(
                1,
                "https://www.linkpicture.com/q/Mycola_1.png",
                "Mykola",
                "Cleaning"
            ),
            Ukrainian(
                1,
                "https://www.linkpicture.com/q/Mycola_1.png",
                "Mykola",
                "Cleaning"
            )
        )
    }
}
