package edu.uw.ss251.wefit.data

import edu.uw.ss251.wefit.model.Achievement

object AchievementProvider {

    val listOfAchievements = listOf(
        Achievement("Getting started!", true),
        Achievement("Two days in a row!", false),
        Achievement("Your first week: COMPLETE", false),
        Achievement("One month down, a lifetime to go.", false),
        Achievement("Has it been a year already?", false),
        Achievement("Wow... No one was supposed to make it this far!", false)
    )

    fun getNumCompleted(): String {
        var numCompleted = 0
        val listIterator = listOfAchievements.listIterator()
        while (listIterator.hasNext()) {
            if (listIterator.next().complete) {
                numCompleted++
            }
        }

        return numCompleted.toString()

    }
}
