package g2301_2400.s2353_design_a_food_rating_system

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class FoodRatingsTest {
    @Test
    fun foodRatings() {
        val foodRatings = FoodRatings(
            arrayOf("kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"),
            arrayOf(
                "korean",
                "japanese",
                "japanese",
                "greek",
                "japanese",
                "korean",
            ),
            intArrayOf(9, 12, 8, 15, 14, 7),
        )
        // return "kimchi"
        assertThat(foodRatings.highestRated("korean"), equalTo("kimchi"))
        // "kimchi" is the highest rated korean food with a rating of 9.
        // return "ramen"
        assertThat(foodRatings.highestRated("japanese"), equalTo("ramen"))
        // "ramen" is the highest rated japanese food with a rating of 14.
        // "sushi" now has a rating of 16.
        foodRatings.changeRating("sushi", 16)
        // return "sushi"
        assertThat(foodRatings.highestRated("japanese"), equalTo("sushi"))
        // "sushi" is the highest rated japanese food with a rating of 16.
        // "ramen" now has a rating of 16.
        foodRatings.changeRating("ramen", 16)
        // return "ramen"
        assertThat(foodRatings.highestRated("japanese"), equalTo("ramen"))
        // Both "sushi" and "ramen" have a rating of 16.
        // However, "ramen" is lexicographically smaller than "sushi".
    }
}
