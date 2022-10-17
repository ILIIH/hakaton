package com.uaref.factory

import com.uaref.model.European

internal class EuropeansFactory {
    fun get(): List<European> {
        return listOf(
            European(
                1,
                "https://images.pexels.com/photos/2449600/pexels-photo-2449600.png?auto=compress&cs=tinysrgb&w=600",
                "Joe",
                "English"
            ),
            European(
                2,
                "https://images.pexels.com/photos/2449600/pexels-photo-2449600.png?auto=compress&cs=tinysrgb&w=600",
                "Joe",
                "English"
            )
        )
    }
}
