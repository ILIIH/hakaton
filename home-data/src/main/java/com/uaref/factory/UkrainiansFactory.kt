package com.uaref.factory

import com.uaref.model.Ukrainian

internal class UkrainiansFactory {
    fun get(): List<Ukrainian> {
        return listOf(
            Ukrainian(
                1,
                "https://cdn.maximonline.ru/ec/5b/70/ec5b701b6dc90d27cbde89b6e19a0d07/728x728_1_848ca9ef388ee0fdc2c538677e5709a7@1024x1024_0xac120002_17992516771550233711.jpg",
                "Mykola",
                "Cleaning"
            ),
            Ukrainian(
                2,
                "https://cdn.maximonline.ru/ec/5b/70/ec5b701b6dc90d27cbde89b6e19a0d07/728x728_1_848ca9ef388ee0fdc2c538677e5709a7@1024x1024_0xac120002_17992516771550233711.jpg",
                "Mykola",
                "Cleaning"
            )
        )
    }
}
