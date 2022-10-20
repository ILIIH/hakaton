package com.example.servise_reviw_data.factory

import com.example.servise_review_domain.models.comment
import com.example.servise_review_domain.models.serviceEuropean
import com.example.servise_review_domain.models.serviseInfo.day
import com.example.servise_review_domain.models.serviseInfo.time
import com.example.servise_review_domain.models.serviseInfo.weekDay
import java.util.*

internal class serviseEuropeanFactory {
    fun get(): List<serviceEuropean> {
        return listOf(
            serviceEuropean(
                1,
                "English tutor",
                "Hello! I am twenty-five years old and I love helping people. I graduated from Dublin University of Linguology and I speak English very well. I would be happy to help you learn English both online and offline",
                time(
                    day("18:00", "23:00", weekDay.Fri),
                    day("14:00", "11:00", weekDay.Sat),
                    day("14:00", "11:00", weekDay.Sat)
                ),
                listOf(
                    comment("Eleanor Summers", "Great help, I love this dude \uD83D\uDE0D", Date(2022, 7, 20, 18, 22)),
                    comment("Brian Parsons", "Thanks for help! I really developed my english level \uD83D\uDE0D", Date(2022, 7, 20, 18, 22))
                )

            )
        )
    }
}