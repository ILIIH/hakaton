package com.example.servise_reviw_data.factory

import com.example.servise_review_domain.models.*
import java.util.*

internal class serviseFactory {
    fun get(): List<servise> {
        return listOf(
            servise(
                "Mykola",
                "Cleaning",
                "I worked as cleaner at Custodian, i was responsible for keeping offices, homes, hotels or other public areas neat and organized. My main duties include sweeping, mopping and vacuuming floors, dusting countertops, ceilings and furniture and sanitizing bathrooms, kitchens or other public areas",
               time(
                        day("18:00", "23:00", weekDay.Fri),
                        day("14:00", "11:00", weekDay.Sat),
                        day("14:00", "11:00", weekDay.Sat)
                    )
                ,
                listOf(
                    comment("Eleanor Summers", "Great help, I love this dude \uD83D\uDE0D", Date(2022, 7, 20, 18, 22)),
                    comment("Brian Parsons", "Thanks for help! I really developed my english level \uD83D\uDE0D", Date(2022, 7, 20, 18, 22))
                )
            ),

            servise(
                "Joe",
                "English tutor",
                "I worked as cleaner at Custodian, i was responsible for keeping offices, homes, hotels or other public areas neat and organized. My main duties include sweeping, mopping and vacuuming floors, dusting countertops, ceilings and furniture and sanitizing bathrooms, kitchens or other public areas",
                time(
                        day("18:00", "23:00", weekDay.Fri),
                        day("14:00", "11:00", weekDay.Sat),
                        day("14:00", "11:00", weekDay.Sat)
                    )
                ,
                listOf(
                    comment("Eleanor Summers", "Great help, I love this dude \uD83D\uDE0D", Date(2022, 7, 20, 18, 22)),
                    comment("Brian Parsons", "Thanks for help! I really developed my english level \uD83D\uDE0D", Date(2022, 7, 20, 18, 22))
                )

            )
        )
    }
}
