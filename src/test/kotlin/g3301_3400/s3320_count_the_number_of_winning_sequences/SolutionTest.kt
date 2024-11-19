package g3301_3400.s3320_count_the_number_of_winning_sequences

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class SolutionTest {
    @Test
    fun countWinningSequences() {
        assertThat<Int?>(Solution().countWinningSequences("FFF"), equalTo<Int?>(3))
    }

    @Test
    fun countWinningSequences2() {
        assertThat<Int?>(Solution().countWinningSequences("FWEFW"), equalTo<Int?>(18))
    }
}